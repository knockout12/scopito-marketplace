package com.scopito.marketplace.domainmodel.model;

/**
 * Created by SagiAlagem on 10/05/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "DroneOperatorProfile")
@NamedQueries({
        @NamedQuery(name="DroneOperatorProfile.findAll", query = "SELECT s FROM DroneOperatorProfile s")

})

public class DroneOperatorProfile {


    private int scopitoID;
    private boolean published;
    private String companyName;
    private boolean scopitoCertified;
    private String email;
    private String phoneNumber;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "scopitoID")
    public int getID() {
        return scopitoID;
    }
    public void setID(int scopitoID) {
        this.scopitoID = scopitoID;
    }

    @Column(columnDefinition = "boolean", name = "published")
    public boolean isPublished() {return this.published; }
    public void setPublished(boolean published) { this.published = published;}

    @Column(name = "companyName")
    public String getCompanyName() {return this.companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName;}

    @Column(columnDefinition = "boolean", name = "scopitoCertified")
    public boolean isScopitoCertified() {return this.scopitoCertified; }
    public void setScopitoCertified(boolean certified) { this.scopitoCertified = certified;}

    @Column(name = "email")
    public String getEmail() {return this.email;}
    public void setEmail(String email) { this.email = email;}

    @Column(name = "email")
    public String getPhoneNumber() {return this.phoneNumber;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}
}
