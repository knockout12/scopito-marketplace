package com.scopito.marketplace;

import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import com.scopito.marketplace.domainmodel.model.ServicesEntity;

public class PresentableServices
{
    private String serviceName;
    private double price;

    /**
     * This class is data model of presentable item with information on services provided. the name and the assigned price from Services table in the database.
     * In this case 'name' and 'price' but it can be expended.
     * @param servicesEntity
     * @param servicesBacklogEntity
     */
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