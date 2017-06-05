package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.Services;
import com.scopito.marketplace.domainmodel.dao.ServicesBacklog;
import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to contain all the business logic regarding Services.
 * Manipulation of the tables Services and ServicesBacklog from the database can be performed from here.
 */
@Stateless
public class ServicesBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private Services services;

    /**
     * helping method to count the number of objects in the list
     * @return number of items
     */
    public Long countAll() {
        return services.count();
    }

    /**
     * Method to list all the services assigned to all the users in the system.
     * @return List of all services and their assignees
     */
    public List<ServicesEntity> list() {
        return services.listAll();
    }

    /**Same as list with pagination functionality.
     * @param pageCount number of page
     * @param pageSize items per chunk
     * @return list of all of the services assignees in the system
     */
    public List<ServicesEntity> list(int pageCount, int pageSize)
    {
        return services.listRange(pageCount, pageSize);
    }

    /**
     *Method to list all the services assigned to given users in the system.
     * @param scopitoID
     * @return List of all the assigned services
     */
    public List<ServicesEntity> getServicesByID(long scopitoID) {
        return services.getServicesByID(scopitoID);
    }


    @Inject
    private ServicesBacklog servicesBacklog;

    /**
     * Method to list all the possible services that users can assign for themselves in the system, with their corresponding ID
     * @return List object representing lines from the table ServicesBacklog in the database.
     * All the services that can be assigned to user in the system
     */
    public List<ServicesBacklogEntity> getServicesBacklog() {
        return servicesBacklog.getBacklog();
    }

    /**
     * Same as getServicesBacklog() adding pagination functionality
     * @param pageCount
     * @param pageSize
     * @return chunk of objects representing lines from the table ServicesBacklog in the database.
     * All the services that can be assigned to user in the system
     */
    public List<ServicesBacklogEntity> getServicesBacklogRange(int pageCount, int pageSize) {
        return servicesBacklog.getBacklogListRange(pageCount, pageSize);
    }


    /**
     * The methods fetch two lists. the first is all the provided services available in the database,
     * the second is all the services assigned to user with the param scopitoID.
     * merge operation match items from the list with their correspondence item by checking the serviceID,
     * and pass over to constructor of PresentableServices object.
     *
     * @param scopitoID
     * @return List of matched services names and their prices inside each one of the
     * PresentableService that are assigned to the user with the given ScopitoID
     */
    public List<PresentableServices> getPresentableServicesListByID(long scopitoID) {

            List<ServicesBacklogEntity> listServiceBacklogEntity = new ArrayList<>(getServicesBacklog());

            List<ServicesEntity> listServices = new ArrayList<>(getServicesByID(scopitoID));

            List<PresentableServices> temp = new ArrayList<>();

            for (ServicesEntity servicesEntity : listServices)
            {
                for (ServicesBacklogEntity servicesBacklogEntity : listServiceBacklogEntity) {
                    if (servicesBacklogEntity.getServiceID() == servicesEntity.getServiceID())
                    {
                        temp.add(new PresentableServices(servicesEntity, servicesBacklogEntity));
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            return temp;
    }
}



