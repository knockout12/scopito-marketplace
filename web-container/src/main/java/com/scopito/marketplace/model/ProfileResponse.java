import com.scopito.marketplace.domainmodel.model.DroneOperatorProfile;
import java.util.ArrayList;
import java.util.List;package com.scopito.marketplace.model;
import com.scopito.marketplace.domainmodel.model.StatusEntity;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SagiAlagem on 13/05/2017.
 */

public class ProfileResponse {
    private long id;
    private String name;

    ProfileResponse(DroneOperatorProfile droneOperatorProfile) {
        name = droneOperatorProfile.getName();
        id = droneOperatorProfile.getId();
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

