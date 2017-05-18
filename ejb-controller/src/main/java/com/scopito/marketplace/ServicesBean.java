package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.ServicesView;
import com.scopito.marketplace.domainmodel.model.ServicesViewEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ServicesViewBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private ServicesView servicesView;

    public Long countAll() {
        return servicesView.count();
    }

    public List<ServicesViewEntity> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return servicesView.getEntityManager().createQuery("SELECT s FROM ServicesViewEntity s", ServicesViewEntity.class).getResultList();
        //return droneOperatorProfile.listRange(pageCount, pageSize);
    }

    public boolean create(Double price) {
        final ServicesViewEntity servicesViewEntity = new ServicesViewEntity();
        servicesViewEntity.setServicePrice(price);
        return servicesView.create(servicesViewEntity) != null;
    }

    public ServicesViewEntity getServicesByID(long scopitoID) {
        return servicesView.getServicesByID(scopitoID);
    }
}


