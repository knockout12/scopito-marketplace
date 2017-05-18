package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.Services;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ServicesBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private Services services;

    public Long countAll() {
        return services.count();
    }

    public List<ServicesEntity> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return services.getEntityManager().createQuery("SELECT s FROM ServicesEntity s", ServicesEntity.class).getResultList();
        //return droneOperatorProfile.listRange(pageCount, pageSize);
    }

    public boolean create(Double price) {
        final ServicesEntity servicesEntity = new ServicesEntity();
        servicesEntity.setServicePrice(price);
        return services.create(servicesEntity) != null;
    }

    public List<ServicesEntity> getServicesByID(long scopitoID) {
        return services.getEntityManager().createQuery("SELECT s FROM ServicesEntity s where s.scopitoID = :scopitoID", ServicesEntity.class)
                .setParameter("scopitoID", scopitoID).getResultList();
    }
}


