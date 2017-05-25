package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;


@Entity
@Table(name = "ServicesBacklog")
@NamedQueries({
        @NamedQuery(name="ServicesBacklog.findAll", query = "SELECT s FROM ServicesBacklogEntity s ")
})
public class ServicesBacklogEntity{

    private int serviceID;
    private String serviceName;
  //  private String description;


    @Id
    @Column(name = "serviceID")
    public int getServiceID() {return this.serviceID; }
    public void setServiceID(int serviceID) { this.serviceID = serviceID;}

    @Column(name = "serviceName")
    public String getServiceName() {return this.serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName;}

   // @Column(name = "description")
   // public String getDescription() {return this.description; }
   // public void setDescription(String description) { this.description = description;}


}


