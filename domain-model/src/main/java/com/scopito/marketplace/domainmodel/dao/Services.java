package com.scopito.marketplace.domainmodel.dao;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;
import org.jboss.logging.Logger;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class Services extends AbstractDao<ServicesEntity> {
    private final Logger logger = Logger.getLogger(getClass());

    Services() {
        super(ServicesEntity.class);
    }

    /**
     * Return all the Services provided by all the users as they assigned in the database with prices provided by the users
     * @return List of all services provided by user
     */
    public List<ServicesEntity> listAll() {
        logger.info("Reading all from named query 'ServiceView.findAll'");
        return listAll("Services.findAll");
    }

    /**Provide the same functionality as listAll but with pagination capabilities
     * @param pageCount the ordinary number of the chunk
     * @param pageSize the size of the chunk
     * @return List of number of services provided by user
     */
    public List<ServicesEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'Services.findAll'");
        return listAllRange("Services.findAll", pageCount, pageSize);
    }

    /**
     * @param scopitoID The scopitoID of the user
     * @return List of assigned services. The object does not include name of the services due to the normalized tables. Include the price.
     * To get services and their names look for ServicesBean.getPresentableServicesListByID()
     */
    public List<ServicesEntity> getServicesByID(long scopitoID) {
        logger.info("Reading range from named query 'Services.findByID'");
        return getEntityManager().createNamedQuery("Services.findByID", ServicesEntity.class).setParameter("scopitoID", scopitoID).getResultList();
    }
}



