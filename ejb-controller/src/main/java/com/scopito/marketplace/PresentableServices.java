package com.scopito.marketplace;

import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;

public class PresentableServices
{
    private String serviceName;
    private double price;

    PresentableServices(ServicesEntity servicesEntity, ServicesBacklogEntity servicesBacklogEntity)
    {
        serviceName = servicesBacklogEntity.getServiceName();
        price = servicesEntity.getServicePrice();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}