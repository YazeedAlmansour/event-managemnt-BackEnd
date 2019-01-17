package com.yazeed.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Validated
public class CommentEntity {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;

    @Column(name = "COMMENT_DATE_TIME")
    private LocalDateTime localDateTime;

    @Column(name = "COMMENT_MSG")
//    @Size(min = 2,max = 255)
    private String comment;

    @Column(name = "COMMENT_ISDELETED")
    private boolean isdeleted;


    /*====================RELATIONSHIP===================*/
    @ManyToOne
    @JoinColumn(name = "COMMENT_USER_ID" ,referencedColumnName = "USER_NUMBER")
    @JsonIgnore
    private UserEntity userEntityfk;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "COMMENT_EVENT_NUMBER")
    @JsonIgnore
    private EventEntity eventEntityfk;

    public UserEntity getUserEntityfk() {
        return userEntityfk;
    }

    public void setUserEntityfk(UserEntity userEntityfk) {
        this.userEntityfk = userEntityfk;
    }

    public EventEntity getEventEntityfk() {
        return eventEntityfk;
    }

    public void setEventEntityfk(EventEntity eventEntityfk) {
        this.eventEntityfk = eventEntityfk;
    }

    /*====================RELATIONSHIP===================*/

    public CommentEntity() {
    }



    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}
