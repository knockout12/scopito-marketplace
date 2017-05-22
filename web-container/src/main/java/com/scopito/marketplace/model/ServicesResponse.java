package com.scopito.marketplace.model;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ServicesResponse implements Serializable {
    private long scopitoID;
    private int serviceID;
    private Double price;
    private String description;

    ServicesResponse(ServicesEntity servicesEntity)
    {
        scopitoID = servicesEntity.getScopitoID();
        serviceID = servicesEntity.getServiceID();
        price = servicesEntity.getServicePrice();
        description = servicesEntity.getDescription();
    }

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

}
