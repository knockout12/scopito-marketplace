package com.scopito.marketplace;

import com.scopito.marketplace.domainmodel.dao.profileInfo;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfile;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DroneOperatorProfileBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private ProfileInfo profileInfo;

    public Long countAll() {
        return profileInfo.count();
    }

    public List<DroneOperatorProfile> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return ProfileInfo.listRange(pageCount, pageSize);
    }

    public boolean create(String name) {
        if(name == null || name.isEmpty()) {
            return false;
        }

        final DroneOperatorProfile droneOperatorProfile = new DroneOperatorProfileBean();
        droneOperatorProfile.setName(name);

        return ProfileInfo.create(droneOperatorProfile) != null;
    }
}
