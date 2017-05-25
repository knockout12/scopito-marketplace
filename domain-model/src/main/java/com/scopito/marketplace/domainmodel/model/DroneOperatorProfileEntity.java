package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;

@Entity
@Table(name = "DroneOperatorProfile")
@NamedQueries({
        @NamedQuery(name="DroneOperatorProfile.findByID", query = "SELECT s FROM DroneOperatorProfileEntity s where s.scopitoID = :scopitoID"),
        @NamedQuery(name ="DroneOperatorProfile.findAll", query = "SELECT s FROM DroneOperatorProfileEntity s")
})
public class DroneOperatorProfileEntity {
    private long scopitoID;
    private Boolean published;
    private String companyName;
    private Boolean scopitoCertified;
    private String email;
    private String phoneNumber;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "scopitoID")
    public long getScopitoID() {
        return scopitoID;
    }
    public void setScopitoID(long scopitoID) {
        this.scopitoID = scopitoID;
    }

    @Column(name = "published")
    public Boolean isPublished() {return this.published; }
    public void setPublished(Boolean published) { this.published = published;}

    @Column(name = "companyName")
    public String getCompanyName() {return this.companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName;}

    @Column(name = "scopitoCertified")
    public Boolean isScopitoCertified() {return this.scopitoCertified; }
    public void setScopitoCertified(Boolean certified) { this.scopitoCertified = certified;}

    @Column(name = "email")
    public String getEmail() {return this.email;}
    public void setEmail(String email) { this.email = email;}

    @Column(name = "phoneNumber")
    public String getPhoneNumber() {return this.phoneNumber;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}
}
