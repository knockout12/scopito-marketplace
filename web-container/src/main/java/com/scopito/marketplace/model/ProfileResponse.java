package com.scopito.marketplace.model;
import com.scopito.marketplace.domainmodel.model.DroneOperatorProfile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SagiAlagem on 13/05/2017.
 */

public class ProfileResponse
{
    private int scopitoID;
    private boolean published;
    private String companyName;
    private boolean scopitoCertified;
    private String email;
    private String phoneNumber;

    ProfileResponse(DroneOperatorProfile droneOperatorProfile) {
        scopitoID = droneOperatorProfile.getID();
        published = droneOperatorProfile.isPublished();
        companyName = droneOperatorProfile.getCompanyName();
        scopitoCertified =droneOperatorProfile.isScopitoCertified();
        email = droneOperatorProfile.getEmail();
        phoneNumber = droneOperatorProfile.getPhoneNumber();

    }

    public static List<ProfileResponse> fromList(List<DroneOperatorProfile> list) {
        List<ProfileResponse> result = new ArrayList<ProfileResponse>();

        for (DroneOperatorProfile droneOperatorProfile : list) {
            result.add(new ProfileResponse(droneOperatorProfile));
        }

        return result;
    }

}

