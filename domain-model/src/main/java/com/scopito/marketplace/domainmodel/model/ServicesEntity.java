package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Services")
@NamedQueries({
        @NamedQuery(name="Services.findByID", query = "SELECT s FROM ServicesEntity s where s.scopitoID = :scopitoID"),
        @NamedQuery(name="Services.findAll", query = "SELECT s FROM ServicesEntity s ")

})
@IdClass(ServicesEntity.class)

public class ServicesEntity implements Serializable{

private long scopitoID;
private int serviceID;
private double price;
private String description;


    public ServicesEntity(){}

    public ServicesEntity(long scopitoID, int serviceID, double price, String description) {
        this.scopitoID = scopitoID;
        this.serviceID = serviceID;
        this.price = price;
        this.description = description;
    }

    @Id
    @Column(name = "scopitoID")
    public long getScopitoID() {
        return scopitoID;
    }
    public void setScopitoID(long scopitoID) {
        this.scopitoID = scopitoID;
    }

    @Id
    @Column(name = "serviceID")
    public int getServiceID() {return this.serviceID; }
    public void setServiceID(int serviceID) { this.serviceID = serviceID;}

    @Column(name = "price")
    public Double getServicePrice() {return this.price; }
    public void setServicePrice(Double price) { this.price = price;}

    @Column(name = "description")
    public String getDescription() {return this.description; }
    public void setDescription(String description) { this.description = description;}


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ServicesEntity)) {
            return false;
        }

        ServicesEntity servicesEntity = (ServicesEntity) o;

        return servicesEntity.scopitoID== scopitoID &&
                servicesEntity.serviceID == serviceID &&
                servicesEntity.price == price &&
                servicesEntity.description.equals(description);
    }

    @Override
    public int hashCode() {
        long result = 14;
        result = 31 * result + scopitoID;
        result = 31 * result + serviceID;
        result = 31 * result + (long)price;
        result = 31 * result + description.hashCode();
        return (int)result;
    }
}
