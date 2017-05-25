package com.scopito.marketplace.model;
import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import java.util.List;


public class ServicesBacklogResponse {

    private int serviceID;
    private String serviceName;

    ServicesBacklogResponse(ServicesBacklogEntity servicesBacklogEntity)
    {

        serviceID = servicesBacklogEntity.getServiceID();
        serviceName = servicesBacklogEntity.getServiceName();
    }
/*
    public static List<ServicesResponse> fromList(List<ServicesEntity> list) {
        List<ServicesResponse> result = new ArrayList<ServicesResponse>();

        for (ServicesEntity servicesEntity : list) {
            result.add(new ServicesResponse(servicesEntity));
        }

        return result;
    }

    public static ServicesResponse getServicesByID(ServicesEntity servicesEntity)
    {
        return new ServicesResponse(servicesEntity);
    }
*/


}
