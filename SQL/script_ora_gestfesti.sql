
-- La création des tables est à faire dans le compte gestfesti14
-- Création des tables et supression si elles existent

drop table Attribution cascade constraints;
drop table Offre cascade constraints;
drop table TypeChambre cascade constraints;
drop table Groupe cascade constraints;
drop table Etablissement cascade constraints;

create table Etablissement 
(Eta_Id        char(8) not null, 
Eta_Nom        varchar2(45) not null,
Eta_Rue        varchar2(45) not null, 
Eta_CP         char(5) not null, 
Eta_Ville      varchar2(35) not null,
Eta_Tel        varchar2(13) not null,
Eta_Mail       varchar2(70),
Eta_Type       number(1) not null,
Eta_CivilResp  varchar2(12) not null,
Eta_NomResp    varchar2(25) not null,
Eta_PrenomResp varchar2(25),
constraint pk_Etablissement primary key(Eta_Id));

create table TypeChambre
(TCh_Id     char(2) not null, 
TCh_Libelle varchar2(15) not null, 
constraint pk_TypeChambre primary key(TCh_Id)) ;

create table Offre
(Off_Etablissement  char(8) not null, 
Off_TypeChambre    char(2) not null, 
Off_NbChambres     number(2) not null, 
constraint pk_Offre primary key(Off_Etablissement, Off_TypeChambre));

create index OffreTypeChambre_FK on offre (Off_TypeChambre asc) ;

create table Groupe
(Gp_Id         char(4) not null, 
 Gp_Nom        varchar2(40) not null, 
 Gp_IdentResp  varchar2(40) default null,
Gp_Adresse     varchar2(120) default null,
Gp_NbPers      number(2) not null, 
Gp_NomPays     varchar2(40) not null, 
Gp_Hebergement char(1) not null,
constraint pk_Groupe primary key(Gp_Id));

create table Attribution
(Att_Etablissement char(8) not null, 
Att_TypeChambre    char(2) not null, 
Att_Groupe         char(4) not null, 
Att_NbChambres     number(2) not null,
constraint pk_Attribution primary key(Att_Etablissement, Att_TypeChambre, Att_Groupe)) ;

create index AttributionTypeChambre_FK on attribution (Att_TypeChambre asc) ;
create index AttributionGroupe_FK on attribution (Att_Groupe asc) ;

ALTER TABLE offre
add constraint  fk1_Offre foreign key(Off_Etablissement) references Etablissement(Eta_Id) ;
 
ALTER TABLE offre
add constraint fk2_Offre foreign key(Off_Typechambre) references TypeChambre(Tch_Id);

ALTER TABLE attribution
add constraint fk1_Attribution foreign key(Att_Groupe) references Groupe(Gp_Id) ;

ALTER TABLE attribution
add constraint fk2_Attribution foreign key(Att_Etablissement, Att_TypeChambre) references Offre(Off_Etablissement, Off_TypeChambre) ;

-- Insertion des données dans les tables

-- les dirigeants du collège de Moka et de l'Institution St-Malo Providence sont fictifs
-- idem pour le prénom de Mme Lefort
insert into Etablissement values ('0350785N', 'Collège de Moka', '2 avenue Aristide Briand BP 6', '35401', 'Saint-Malo', '0299206990', null,1,'Monsieur','Dupont','Alain');
insert into Etablissement values ('0350773A', 'Collège Ste Jeanne d''Arc-Choisy', '3, avenue de la Borderie BP 32', '35404', 'Paramé', '0299560159', null, 1,'Madame','Lefort','Anne');  
insert into Etablissement values ('0352072M', 'Institution Saint-Malo Providence', '2 rue du collège BP 31863', '35418', 'Saint-Malo', '0299407474', null, 1,'Monsieur','Durand','Pierre');   
insert into Etablissement values ('11111111', 'Centre de rencontres internationales', '37 avenue du R.P. Umbricht BP 108', '35407', 'Saint-Malo', '0299000000', null, 0, 'Monsieur','Guenroc','Guy');

insert into TypeChambre values ('C1', '1 lit');
insert into TypeChambre values ('C2', '2 à 3 lits');
insert into TypeChambre values ('C3', '4 à 5 lits');
insert into TypeChambre values ('C4', '6 à 8 lits');
insert into TypeChambre values ('C5', '8 à 12 lits');
 
-- certains groupes sont incomplètement renseignés
insert into Groupe (Gp_Id, Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g001','Groupe folklorique du Bachkortostan',40,'Bachkirie','O');
insert into Groupe (Gp_Id, Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g002','Marina Prudencio Chavez',25,'Bolivie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g003','Nangola Bahia de Salvador',34,'Brésil','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g004','Bizone de Kawarma',38,'Bulgarie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g005','Groupe folklorique camerounais',22,'Cameroun','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g006','Syoung Yaru Mask Dance Group',29,'Corée du Sud','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g007','Pipe Band',19,'Ecosse','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g008','Aira da Pedra',5,'Espagne','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g009','The Jersey Caledonian Pipe Band',21,'Jersey','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g010','Groupe folklorique des Émirats',30,'Emirats arabes unis','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g011','Groupe folklorique mexicain',38,'Mexique','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g012','Groupe folklorique de Panama',22,'Panama','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g013','Groupe folklorique papou',13,'Papouasie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g014','Paraguay Ete',26,'Paraguay','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g015','La Tuque Bleue',8,'Québec','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g016','Ensemble Leissen de Oufa',40,'République de Bachkirie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g017','Groupe folklorique turc',40,'Turquie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g018','Groupe folklorique russe',43,'Russie','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g019','Ruhunu Ballet du village de Kosgoda',27,'Sri Lanka','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g020','L''Alen',34,'France - Provence','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g021','L''escolo Di Tourre',40,'France - Provence','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g022','Deloubes Kévin',1,'France - Bretagne','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g023','Daonie See',5,'France - Bretagne','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g024','Boxty',5,'France - Bretagne','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g025','Soeurs Chauvel',2,'France - Bretagne','O');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g026','Cercle Gwik Alet',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g027','Bagad Quic En Groigne',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g028','Penn Treuz',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g029','SavGp_Idan Launay',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g030','Cercle Boked Er Lann',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g031','Bagad Montfortais',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g032','Vent de Noroise',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g033','Cercle Strollad',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g034','Bagad An Hanternoz',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g035','Cercle Ar Vro Melenig',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g036','Cercle An Abadenn Nevez',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g037','Kerc''h Keltiek Roazhon',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g038','Bagad Plougastel',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g039','Bagad Nozeganed Bro Porh-Loeiz',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g040','Bagad Nozeganed Bro Porh-Loeiz',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g041','Jackie Molard Quartet',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g042','Deomp',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g043','Cercle Olivier de Clisson',0,'France - Bretagne','N');
insert into Groupe (Gp_Id,Gp_Nom, Gp_NbPers, Gp_NomPays, Gp_Hebergement) values ('g044','Kan Tri',0,'France - Bretagne','N');

-- les offres sont fictives
insert into Offre values ('0350785N', 'C1', 5);
insert into Offre values ('0350785N', 'C2', 10);
insert into Offre values ('0350785N', 'C3', 5);

insert into Offre values ('0350773A', 'C2', 15);
insert into Offre values ('0350773A', 'C3', 1);

insert into Offre values ('0352072M', 'C1', 5);
insert into Offre values ('0352072M', 'C2', 10);
insert into Offre values ('0352072M', 'C3', 3);

-- les attributions sont fictives
insert into Attribution values ('0350785N', 'C1', 'g001', 1);
insert into Attribution values ('0350785N', 'C1', 'g002', 2);
insert into Attribution values ('0350785N', 'C1', 'g003', 2);
insert into Attribution values ('0350785N', 'C2', 'g001', 2);
insert into Attribution values ('0350785N', 'C2', 'g002', 1);
insert into Attribution values ('0350785N', 'C3', 'g001', 2);
insert into Attribution values ('0350785N', 'C3', 'g002', 1);

insert into Attribution values ('0350773A', 'C2', 'g004', 2);
insert into Attribution values ('0350773A', 'C3', 'g005', 1);

insert into Attribution values ('0352072M', 'C1', 'g006', 1);
insert into Attribution values ('0352072M', 'C2', 'g007', 3);
insert into Attribution values ('0352072M', 'C3', 'g006', 3);

-- Création des tables d'archivage

CREATE TABLE archi_typechambre AS SELECT * FROM typechambre;
CREATE TABLE archi_etablissement AS SELECT * FROM etablissement;
CREATE TABLE archi_offre AS SELECT * FROM offre;
CREATE TABLE archi_groupe AS SELECT * FROM groupe;
CREATE TABLE archi_attribution AS SELECT * FROM attribution;
ALTER TABLE archi_typechambre add (tch_date VARCHAR2(12),
tch_manip CHAR(1));
ALTER TABLE archi_etablissement add (eta_date VARCHAR2(12),
eta_manip CHAR(1));
ALTER TABLE archi_offre add (off_date VARCHAR2(12),
off_manip CHAR(1));
ALTER TABLE archi_groupe add (grou_date VARCHAR2(12),
grou_manip CHAR(1));
ALTER TABLE archi_attribution add (att_date VARCHAR2(12),
att_manip CHAR(1));

