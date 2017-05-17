package com.scopito.marketplace.domainmodel.model;

/**
 * Created by SagiAlagem on 15/05/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "DroneOperatorProfile")
@NamedQueries({
   /*     @NamedQuery(name="FindDroneOperatorProfileByID", query = "FROM DroneOperatorProfile s where s.scopitoID = :scopitoID"),*/
        @NamedQuery(name ="DroneOperators.FindAll", query = "SELECT s FROM DroneOperatorProfile")
})

public class DroneOperatorProfileEntity {


    private int scopitoID;
    private boolean published;
    private String companyName;
    private boolean scopitoCertified;
    private String email;
    private String phoneNumber;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "scopitoID")
    public int getScopitoID() {
        return scopitoID;
    }
    public void setScopitoID(int scopitoID) {
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
