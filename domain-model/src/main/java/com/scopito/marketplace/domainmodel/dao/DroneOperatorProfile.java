package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class DroneOperatorProfile extends AbstractDao<DroneOperatorProfileEntity> {
    private final Logger logger = Logger.getLogger(getClass());

    DroneOperatorProfile() {
        super(DroneOperatorProfileEntity.class);
    }

    /**Fetch from the database list of all the Drone Operators profiles info that are signed in the system
     * @return list of Drone Operator Profile Info
     */
    public List<DroneOperatorProfileEntity> listAll() {
        logger.info("Reading all from named query 'DroneOperatorProfile.findAll'");
        return listAll("DroneOperatorProfile.findAll");
    }

    /**
     * Same as List but enabling pagination functionality
     * @param pageCount
     * @param pageSize
     * @return List of drone operator in predefined chunks
     */
    public List<DroneOperatorProfileEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'DroneOperatorProfile.findAll'");
        return listAllRange("DroneOperatorProfile.findAll", pageCount, pageSize);
    }
    /**
     * brings profile info of given userID
     * @param scopitoID userID
     * @return profile info of given user
     */
    public DroneOperatorProfileEntity get(long scopitoID) {
        return getEntityManager()
                .createNamedQuery("DroneOperatorProfile.findByID", DroneOperatorProfileEntity.class)
                .setParameter("scopitoID", scopitoID)
                .getSingleResult();
    }

    public int updateCompanyName(long scopitoID, String companyName)
    {

         int res = getEntityManager().createNamedQuery("DroneOperatorProfile.updateCompanyName")
                .setParameter("scopitoID", scopitoID)
                .setParameter("companyName", companyName)
                .executeUpdate();
         logger.info(String.format("---- updateCompanyName in DroneOperatorProfile returned:  '%d' ", res ));

        return res;
    }

    public int updateEmail(long scopitoID, String email )
    {

        int res = getEntityManager().createNamedQuery("DroneOperatorProfile.updateEmail")
                .setParameter("scopitoID", scopitoID)
                .setParameter("email", email)
                .executeUpdate();
        logger.info(String.format("---- updateCompanyName in DroneOperatorProfile returned:  '%d' ", res ));

        return res;
    }

    public int updatePhoneNumber(long scopitoID, String phoneNumber)
    {

        int res = getEntityManager().createNamedQuery("DroneOperatorProfile.updatePhoneNumber")
                .setParameter("scopitoID", scopitoID)
                .setParameter("phoneNumber", phoneNumber)
                .executeUpdate();
        logger.info(String.format("---- updateCompanyName in DroneOperatorProfile returned:  '%d' ", res ));

        return res;
    }





}


