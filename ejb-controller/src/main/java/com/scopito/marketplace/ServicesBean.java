package com.scopito.marketplace;

import javax.ejb.Stateless;
import com.scopito.marketplace.domainmodel.dao.Services;
import com.scopito.marketplace.domainmodel.dao.ServicesBacklog;
import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import java.util.ArrayList;
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

    @Inject
    private ServicesBacklog servicesBacklog;

    public List<ServicesBacklogEntity> getServicesBacklog() {
        return servicesBacklog.getEntityManager().createQuery("SELECT s FROM ServicesBacklogEntity s", ServicesBacklogEntity.class).getResultList();
    }


    public List<PresentableServices> getPresentableServicesListByID(long scopitoID)
    {
        List<ServicesBacklogEntity> listServiceBacklogEntity = new ArrayList<>(getServicesBacklog());

        List<ServicesEntity> listServices = new ArrayList<>(getServicesByID(scopitoID));

        List<PresentableServices> temp = new ArrayList<>();


        for (ServicesEntity servicesEntity: listServices)
        {
            for (ServicesBacklogEntity servicesBacklogEntity: listServiceBacklogEntity)
            {
                if(servicesBacklogEntity.getServiceID() == servicesEntity.getServiceID() )
                {
                    temp.add(new PresentableServices(servicesEntity, servicesBacklogEntity));
                   // listServiceBacklogEntity.remove(servicesBacklogEntity);
                }
                else {
                    continue;
                }

            }

        }
        return temp;
    }


}


