package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;

@Entity
@Table(name = "Status")
@NamedQueries({
    @NamedQuery(name="StatusEntity.findAll", query = "SELECT s FROM StatusEntity s")
})
public class StatusEntity {
    private long id;
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
