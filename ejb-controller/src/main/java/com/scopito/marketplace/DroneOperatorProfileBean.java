package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.DroneOperatorProfile;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DroneOperatorProfileBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DroneOperatorProfile droneOperatorProfile;

    public Long countAll() {
        return droneOperatorProfile.count();
    }

    public List<DroneOperatorProfileEntity> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return droneOperatorProfile.getEntityManager().createQuery("SELECT s FROM DroneOperatorProfileEntity s", DroneOperatorProfileEntity.class).getResultList();
        //return droneOperatorProfile.listRange(pageCount, pageSize);
    }

    public boolean create(String name) {
        final DroneOperatorProfileEntity droneOperatorProfileEntity = new DroneOperatorProfileEntity();
        droneOperatorProfileEntity.setCompanyName(name);
        return droneOperatorProfile.create(droneOperatorProfileEntity) != null;
    }

    public DroneOperatorProfileEntity getByID(long scopitoID) {
        return droneOperatorProfile.get(scopitoID);
    }
}


