package com.scopito.marketplace.domainmodel.model;
import javax.persistence.*;

@Entity
@Table(name = "Location")
@NamedQueries({
        @NamedQuery(name ="Location.findAll", query = "SELECT s FROM Location")
})
public class LocationEntity {

    private int scopitoID;
    private int regionID;

    @Id
    @Column(name = "scopitoID")
    public int getScopitoID() {
        return scopitoID;
    }
    public void setScopitoID(int scopitoID) {
        this.scopitoID = scopitoID;
    }

    @Column(columnDefinition = "regionID", name = "regionID")
    public int getRegionID() {return this.regionID; }
    public void setRegionID(int regionID) { this.regionID = regionID;}

}
