create table visitor(
vID char(9)not null  ,
vName varchar2(30) NOT NULL,
vPassword varchar2(30)not null,
BDate Date not null,
Address varchar2(30) NOT NULL ,
PhoneNumber char(10) unique ,



 primary Key(vID));
 

insert into visitor values ('1111','Hanan Qazmoz','12345','1-Aug-1991','Nablus', '059987654' );
     insert into visitor values ('1521','Ahmed Farouq','56789','29-Mar-1999','Tulkarm', '059887653' );
      insert into visitor values ('1131','Saja Jamous','12355','1-Aug-1991','Nablus', '059987754' );

create table prisoner(
PrisonerID char(9)not null ,
pName varchar2(30) NOT NULL,
Gender varchar2(1)NOT NULL,
BDate Date not null,
NumOfYearsInPrison INT not null,
PrisonName varchar2(30) NOT NULL,
PrisonDate Date not null,


  primary Key(PrisonerID));
   
insert into  prisoner values ('0000','Ammar Qazmoz','M','11-June-1978','23', 'AL-Naqap','10-Mar-2003' );
    insert into  prisoner values ('9999','Saleem Farouq','M','7-Jan-1990','15','Jalbou','12-Aug-2009');
         insert into  prisoner values ('0008','Samer Jamous','M','16-Feb-2000','10','Asqalan','27-Aug-2013');


create table prisonerVisiter(
PrisonerID char(9)not null  ,
vID char(9)not null  ,
RelativeRelation varchar2(30) NOT NULL,

  PRIMARY KEY (PrisonerID, vID) ,
  Foreign Key (PrisonerID)references prisoner(PrisonerID),
    Foreign Key (vID)references visitor(vID));
  
  
   
insert into prisonerVisiter values ('0000','1111','sister');
     insert into prisonerVisiter values ('9999','1521','brother');
        insert into prisonerVisiter values ('0008','1131','sister');

create table Employee(
eName varchar2(30) NOT NULL,
Gmail varchar2(100) unique ,
ePassword varchar2(30)not null,
SSN char(9)not null  ,
PhoneNumber char(10) unique ,
eGender varchar2(1)NOT NULL,
BDate Date not null,
Address varchar2(30)not null,
   
 primary Key(SSN));


insert into Employee values ('Masa Issa','masaissa@gmail.com','55555','106','059812345','F','9-June-2001','Tulkarm');
     insert into Employee values ('Sojod','sojod@gmail.com','66666','119','0597183010','F','11-July-2001','Nablus');

create table visit(
PrisonName varchar2(20) NOT NULL,
visitID char(9)not null,
VisitingTime Date NOT NULL,
RegDate Date not null,
Address varchar2(30)not null,
VisiterNum char(9) not null,
SSN char(9)not null,
   
 primary Key(visitID),

  Foreign Key (SSN)references Employee(SSN) );



  insert into visit values ('AL-Naqap','10','25-Dec-2021','20-Sep-2021','Nablus','15','106');
     insert into visit values ('Jalbou','8','12-Jan-2022','10-Oct-2021','Tulkarm','18','106');
	 insert into visit values ('Asqalan','30','17-Feb-2022','14-Nov-2021','Nablus','20','119');


create table visitPrisoner(
PrisonerID char(9)not null  ,
visitID char(9)not null  ,
  PRIMARY KEY (PrisonerID, visitID) ,
    Foreign Key (PrisonerID)references prisoner(PrisonerID),
    Foreign Key (visitID)references visit(visitID));

  
insert into visitPrisoner values ('0000','10');
     insert into visitPrisoner values ('9999','8');
        insert into visitPrisoner values ('0008','30');


create table visitVisitor(
vID char(9)not null  ,
visitID char(9)not null ,
  PRIMARY KEY (visitID, vID),
  Foreign Key (vID)references visitor(vID),
    Foreign Key (visitID)references visit(visitID));
  
insert into visitVisitor values ('1111','10');
     insert into visitVisitor values ('1521','8');
        insert into visitVisitor values ('1131','30');

