package com.scopito.marketplace.model;

import com.scopito.marketplace.PresentableServices;
import com.scopito.marketplace.ServicesBean;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;

import java.util.ArrayList;
import java.util.List;


public class PresentableServicesResponse {

    private String serviceName;
    private double price;

    public PresentableServicesResponse( PresentableServices presentableServices) {
        serviceName = presentableServices.getServiceName();
        price = presentableServices.getPrice();
    }


    public static List<PresentableServicesResponse> fromList(List<PresentableServices> list) {
        List<PresentableServicesResponse> result = new ArrayList<PresentableServicesResponse>();

        for (PresentableServices presentableServices : list) {
            result.add(new PresentableServicesResponse(presentableServices));
        }

        return result;
    }

    public static PresentableServicesResponse getPresentableServices(PresentableServices presentableServices)
    {
        return new PresentableServicesResponse(presentableServices);
    }


}
