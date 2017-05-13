package com.scopito.marketplace;

import com.scopito.marketplace.domainmodel.dao.Status;
import com.scopito.marketplace.domainmodel.model.StatusEntity;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DroneOperatorProfile {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private ProfileInfo profileInfo;

    public Long countAll() {
        return profileInfo.count();
    }

    public List<droneOperatorProfile> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return ProfileInfo.listRange(pageCount, pageSize);
    }

    public boolean create(String name) {
        if(name == null || name.isEmpty()) {
            return false;
        }

        final droneOperatorProfile droneOperatorProfile = new droneOperatorProfile();
        droneOperatorProfile.setName(name);

        return ProfileInfo.create(statusEntity) != null;
    }
}
