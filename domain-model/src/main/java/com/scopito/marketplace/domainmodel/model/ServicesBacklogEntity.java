package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;

/**
 * Created by SagiAlagem on 15/05/2017.
 */
@Entity
@Table(name = "ServiceBacklog")
@NamedQueries({
        @NamedQuery(name="ServiceBacklog.findAll", query = "SELECT s FROM ServiceBacklog")
})
public class ServicesBacklogEntity{

    private int serviceID;
    private String serviceName;
    private String description;


    @Id
    @Column(columnDefinition = "serviceID", name = "serviceID")
    public int getServiceID() {return this.serviceID; }
    public void setServiceID(int serviceID) { this.serviceID = serviceID;}

    @Column(columnDefinition = "serviceName", name = "serviceName")
    public String getServiceName() {return this.serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName;}


    @Column(columnDefinition = "description", name = "description")
    public String getDescription() {return this.description; }
    public void setDescription(String description) { this.description = description;}

}


