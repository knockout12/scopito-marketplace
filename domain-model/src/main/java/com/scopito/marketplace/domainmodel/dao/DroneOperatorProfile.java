package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import com.scopito.marketplace.domainmodel.model.StatusEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 * Created by SagiAlagem on 15/05/2017.
 */
    @RequestScoped
    public class DroneOperatorProfile extends AbstractDao<DroneOperatorProfileEntity> {


        private final Logger logger = Logger.getLogger(getClass());

        DroneOperatorProfile() {
            super(DroneOperatorProfileEntity.class);
        }

        public List<DroneOperatorProfileEntity> listAll() {
            logger.info("Reading all from named query 'StatusEntity.findAll'");
            return listAll("DroneOperators.FindAll");
        }



        /*
        public List<StatusEntity> listRange(int pageCount, int pageSize) {
            logger.info("Reading range from named query 'StatusEntity.findAll'");
            return listAllRange("StatusEntity.findAll", pageCount, pageSize);
        }
         */




    }
