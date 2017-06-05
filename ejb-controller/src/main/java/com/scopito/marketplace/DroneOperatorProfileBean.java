package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.DroneOperatorProfile;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.util.List;

/**
 * Class to contain all the business logic regarding the profile info. Manipulation of the table DroneOperatorProfile from the database can be performed from here
 */
@Stateless
public class DroneOperatorProfileBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private DroneOperatorProfile droneOperatorProfile;

    public Long countAll() {
        return droneOperatorProfile.count();
    }

    /**
     * Fetch from the database list of all the Drone Operators profiles info that are signed in the system
     *
     * @return list of Drone Operator Profile Info
     */
    public List<DroneOperatorProfileEntity> list() {
        logger.info(String.format("List all users from DroneOperatorProfile"));
        return droneOperatorProfile.listAll();
    }

    /**
     * Same as List but enabling pagination functionality
     *
     * @param pageCount
     * @param pageSize
     * @return List of drone operator in predefined chunks
     */
    public List<DroneOperatorProfileEntity> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return droneOperatorProfile.listRange(pageCount, pageSize);
    }


    /**
     * Fetch an profile info of given userID
     *
     * @param scopitoID
     * @return Object with profile info of the given userID
     */
    public DroneOperatorProfileEntity getByID(long scopitoID) {
        logger.info(String.format("Fetching profile info of user '%d'", scopitoID));
        return droneOperatorProfile.get(scopitoID);
    }

    public DroneOperatorProfileEntity updateCompanyName(long scopitoID, String companyName) {
        int res = droneOperatorProfile.updateCompanyName(scopitoID, companyName);
        logger.info(String.format("res returned = '%d", res));
        return droneOperatorProfile.get(scopitoID);
    }


    public DroneOperatorProfileEntity updateEmail(long scopitoID, String email) {
        int res = droneOperatorProfile.updateEmail(scopitoID, email);
        logger.info(String.format("res returned = '%d", res));
        return droneOperatorProfile.get(scopitoID);

    }

    public DroneOperatorProfileEntity updatePhoneNumber(long scopitoID, String phoneNumber) {
        int res = droneOperatorProfile.updatePhoneNumber(scopitoID, phoneNumber);
        logger.info(String.format("res returned = '%d", res));
        return droneOperatorProfile.get(scopitoID);
    }
}


