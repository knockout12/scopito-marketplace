package com.scopito.marketplace.model;

import com.scopito.marketplace.domainmodel.model.StatusEntity;

import java.util.ArrayList;
import java.util.List;

public class StatusResponse {
    private long id;
    private String name;

    StatusResponse(StatusEntity statusEntity) {
        name = statusEntity.getName();
        id = statusEntity.getId();
    }

    public static List<StatusResponse> fromList(List<StatusEntity> list) {
        List<StatusResponse> result = new ArrayList<StatusResponse>();

        for (StatusEntity statusEntity : list) {
            result.add(new StatusResponse(statusEntity));
        }


        return result;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
