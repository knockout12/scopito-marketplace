package com.scopito.marketplace.domainmodel.model;

/**
 * Created by SagiAlagem on 10/05/2017.
 */
public class droneOperatorProfile {


    private int scopitoID;


    private boolean published;
    private String companyName;
    private boolean scopitoCertified;
    private String email;
    private String phoneNumber;

    public droneOperatorProfile(int scopitoID, boolean published, String companyName, boolean scopitoCertified, String email, String phoneNumber) {
        this.scopitoID = scopitoID;
        this.published = published;
        this.companyName = companyName;
        this.scopitoCertified = scopitoCertified;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getScopitoID() {
        return scopitoID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isScopitoCertified() {
        return scopitoCertified;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPublished(boolean published) {
        this.published = published;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private void setScopitoCertified(boolean scopitoCertified) {
        this.scopitoCertified = scopitoCertified;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    private void updateProfileInfo( String companyName, String email, String phoneNumber)
//    {
//        setCompanyName(companyName);
//        setEmail(email);
//        setPhoneNumber(phoneNumber);
//
//    }
    private void publishProfile()
    {
        setPublished(true);
    }
}
