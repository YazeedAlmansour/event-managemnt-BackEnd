package com.yazeed.entity;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class ReviewEntity {

    @Id
    @Column(name = "REVIEW_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewnumber;

    @Column(name = "REVIEW_COMMENT")
    private String reviewcommet;
    @Column(name = "REVIEW_RATE")
    private int reviewrate;

    @Column(name = "REVIEW_ISDELETED")
    private boolean isdeleted;

    /*====================RELATIONSHIP===================*/
    @OneToOne
    @JoinColumn(name = "REVIEW_TICKET_ID")
    private TicketEntity ticketid;

    public TicketEntity getTicketid() {
        return ticketid;
    }

    public void setTicketid(TicketEntity ticketid) {
        this.ticketid = ticketid;
    }

    /*====================RELATIONSHIP===================*/



    public ReviewEntity(){}

    public ReviewEntity(long reviewnumber, String reviewcommet, int reviewrate, boolean isdeleted, TicketEntity ticketid) {
        this.reviewnumber = reviewnumber;
        this.reviewcommet = reviewcommet;
        this.reviewrate = reviewrate;
        this.isdeleted = isdeleted;
        this.ticketid = ticketid;
    }

    public long getReviewnumber() {
        return reviewnumber;
    }

    public void setReviewnumber(long reviewnumber) {
        this.reviewnumber = reviewnumber;
    }

    public String getReviewcommet() {
        return reviewcommet;
    }

    public void setReviewcommet(String reviewcommet) {
        this.reviewcommet = reviewcommet;
    }

    public int getReviewrate() {
        return reviewrate;
    }

    public void setReviewrate(int reviewrate) {
        this.reviewrate = reviewrate;
    }

    public boolean isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
