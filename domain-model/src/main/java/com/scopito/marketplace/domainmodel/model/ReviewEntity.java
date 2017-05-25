package com.scopito.marketplace.domainmodel.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Reviews")
@NamedQueries({
        @NamedQuery(name ="Review.findAll", query = "SELECT s FROM Reviews")
})
public class ReviewEntity {

    private int reviewItemID;
    private int scopitoID;
    private int authorID;
    private int rating;
    private String comment;
    private Date created;


    @Id

    @Column(name = "reviewItemID")
    public int getReviewItemID() {
        return reviewItemID;
    }

    public void setReviewItemID(int reviewItemID) {
        this.reviewItemID = reviewItemID;
    }

    @Column(name = "scopitoID")
    public int getID() {
        return scopitoID;
    }

    public void setID(int scopitoID) {
        this.scopitoID = scopitoID;
    }

    @Column(columnDefinition = "authorID", name = "authorID")
    public int getAuthorID() {
        return this.authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
    @Column(columnDefinition = "rating", name = "rating")
    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created)
    {
        this.created = created;
    }


}
