package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.StatusEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

abstract class AbstractDao<T> {
    private final Class<T> entityClass;

    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public T create(T entity) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        T t = em.merge(entity);
        em.flush();
        et.commit();

        return t;
    }

    public T edit(T entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.merge(entity));
        em.flush();
        et.commit();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> listAll(String namedQuery) {
        return getEntityManager().createNamedQuery(namedQuery, entityClass).getResultList();
    }

    public List<T> listAllRange(String namedQuery, int pageCount, int pageSize) {
        return getEntityManager().createNamedQuery(namedQuery, entityClass)
                .setFirstResult(pageCount * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public Long count() {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        cq.select(getEntityManager().getCriteriaBuilder().count(cq.from(entityClass)));
        return (Long)getEntityManager().createQuery(cq).getSingleResult();
    }
}
