package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;

@Entity
@Table(name = "Country")
@NamedQueries({
        @NamedQuery(name ="Country.findAll", query = "SELECT s FROM Country")
})

public class CountryEntity {

    private int countryID;
    private String countryName;

    @Id
    @Column(name = "countryID")
    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Column(columnDefinition = "countryName", name = "countryName")
    public String getCountryName() {return this.countryName;}

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
