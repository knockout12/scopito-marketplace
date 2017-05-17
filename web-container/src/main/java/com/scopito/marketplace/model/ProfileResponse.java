package com.scopito.marketplace.model;

import com.scopito.marketplace.domainmodel.model.DroneOperatorProfileEntity;
import java.util.ArrayList;
import java.util.List;

public class ProfileResponse {
    private long scopitoID;
    private Boolean published;
    private String companyName;
    private Boolean scopitoCertified;
    private String email;
    private String phoneNumber;

    ProfileResponse(DroneOperatorProfileEntity droneOperatorProfileEntity) {
        scopitoID = droneOperatorProfileEntity.getScopitoID();
        published = droneOperatorProfileEntity.isPublished();
        companyName = droneOperatorProfileEntity.getCompanyName();
        scopitoCertified = droneOperatorProfileEntity.isScopitoCertified();
        email = droneOperatorProfileEntity.getEmail();
        phoneNumber = droneOperatorProfileEntity.getPhoneNumber();
    }

    public static List<ProfileResponse> fromList(List<DroneOperatorProfileEntity> list) {
        List<ProfileResponse> result = new ArrayList<ProfileResponse>();

        for (DroneOperatorProfileEntity droneOperatorProfileEntity : list) {
            result.add(new ProfileResponse(droneOperatorProfileEntity));
        }

        return result;
    }

    public static ProfileResponse getByID(DroneOperatorProfileEntity profile)
    {
        return new ProfileResponse(profile);
    }

    public long getScopitoID() {
        return scopitoID;
    }

    public Boolean isPublished() {
        return published;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Boolean isScopitoCertified() {
        return scopitoCertified;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
