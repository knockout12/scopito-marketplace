package com.scopito.marketplace.domainmodel.model;

import java.util.Date;

/**
 * Created by SagiAlagem on 10/05/2017.
 */
public class Reviews {

    private int reviewItemID;
    private int scopitoID;
    private int authorID;
    private int rating;
    private String comment;
    private Date created;


    private Reviews(int reviewItemID, int scopitoID, int authorID, int rating, String comment, Date created)
    {

    }


    public int getReviewItemID() {
        return reviewItemID;
    }

    public int getScopitoID() {
        return scopitoID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
