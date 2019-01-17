INSERT INTO ROLE(ROLE_NAME,ROLE_ISDELETED) VALUES ('Admin',0);
INSERT INTO ROLE(ROLE_NAME,ROLE_ISDELETED) VALUES ('Organizer',0);
INSERT INTO ROLE(ROLE_NAME,ROLE_ISDELETED) VALUES ('Attender',0);



INSERT INTO USERS (USER_ID,USER_FNAME, USER_LNAME,USER_EMAIL,USER_PHONE,USER_GENDER,USER_BIRTH,USER_PASS,USER_ISDELETED,USER_ROLE_ID)
VALUES (1085888888,'Yazeed','Almansour','yhmyazeed@gmail.com','0562281281','MALE','1995-05-21','1234',0,1);
INSERT INTO USERS (USER_ID,USER_FNAME, USER_LNAME,USER_EMAIL,USER_PHONE,USER_GENDER,USER_BIRTH,USER_PASS,USER_ISDELETED,USER_ROLE_ID)
VALUES (1075777777,'Hamad','alqatani','HAMAD@GMAIL.COM','0504199491','MALE','1999-05-21','1234',0,2);
INSERT INTO USERS (USER_ID,USER_FNAME, USER_LNAME,USER_EMAIL,USER_PHONE,USER_GENDER,USER_BIRTH,USER_PASS,USER_ISDELETED,USER_ROLE_ID)
VALUES (1065666666,'Saad','altamimi','abu4saad@gmail.com','0556455576','MALE','1989-05-21','1234',0,3);




INSERT INTO EVENT (EVENT_NAME,EVENT_LOCATION,EVENT_CAPACITY,EVENT_DATE_TIME,EVENT_APPROVAL,EVENT_ISDELETED,EVENT_ORGNAIZER_ID,EVENT_COUNTER)
VALUES ('Junadriyah','Riyadh',2,'2018-11-11',1,0,2,0);
INSERT INTO EVENT (EVENT_NAME,EVENT_LOCATION,EVENT_CAPACITY,EVENT_DATE_TIME,EVENT_APPROVAL,EVENT_ISDELETED,EVENT_ORGNAIZER_ID,EVENT_COUNTER)
VALUES ('Bokk Gallery','Riyadh',2,'2018-12-11',1,0,2,0);
INSERT INTO EVENT (EVENT_NAME,EVENT_LOCATION,EVENT_CAPACITY,EVENT_DATE_TIME,EVENT_APPROVAL,EVENT_ISDELETED,EVENT_ORGNAIZER_ID,EVENT_COUNTER)
VALUES ('Car','Jeddah',2,'2018-11-04',1,0,2,0);


--
--INSERT INTO TICKET(TICKET_CONFORMED,TICKET_ISDELETED,TICKET_ATTENDER_ID,TICKET_EVENT_NUMBER) VALUES (1,0,3,1);
--INSERT INTO TICKET(TICKET_CONFORMED,TICKET_ISDELETED,TICKET_ATTENDER_ID,TICKET_EVENT_NUMBER) VALUES (1,0,3,2);
--
--
--INSERT INTO REVIEW(REVIEW_COMMENT,REVIEW_RATE,REVIEW_ISDELETED,REVIEW_TICKET_ID) VALUES ('Very Good',5,0,1);
--INSERT INTO REVIEW(REVIEW_COMMENT,REVIEW_RATE,REVIEW_ISDELETED,REVIEW_TICKET_ID) VALUES ('Good',4,0,2);
--


