package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;

@Entity
@Table(name = "Region")
@NamedQueries({
        @NamedQuery(name ="Region.findAll", query = "SELECT s FROM Region")
})
public class RegionEntity {

    private int regionID;
    private String regionName;
    private int countryID;

    @Id
    @Column(name = "regionID")
    public int getRegionID() {
        return regionID;
    }
    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    @Column(columnDefinition = "regionName", name = "regionName")
    public String getRegionName() {return this.regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName;}

    @Column(name = "countryID")
    public int getCountryID() {
        return countryID;
    }
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
}
