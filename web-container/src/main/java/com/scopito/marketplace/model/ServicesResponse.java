package com.scopito.marketplace.model;
import com.scopito.marketplace.domainmodel.model.ServicesViewEntity;

import java.util.ArrayList;
import java.util.List;


public class ServicesViewResponse {
    private long scopitoID;
    private int serviceID;
    private String serviceName;
    private Double price;

    ServicesViewResponse(ServicesViewEntity servicesViewEntity)
    {
        scopitoID = servicesViewEntity.getScopitoID();
        serviceID = servicesViewEntity.getServiceID();
        serviceName = servicesViewEntity.getServiceName();
        price = servicesViewEntity.getServicePrice();
    }

    public static List<ServicesViewResponse> fromList(List<ServicesViewEntity> list) {
        List<ServicesViewResponse> result = new ArrayList<ServicesViewResponse>();

        for (ServicesViewEntity servicesViewEntity : list) {
            result.add(new ServicesViewResponse(servicesViewEntity));
        }

        return result;
    }

    public static ServicesViewResponse getServicesByID(ServicesViewEntity servicesViewEntity)
    {
        return new ServicesViewResponse(servicesViewEntity);
    }

}
