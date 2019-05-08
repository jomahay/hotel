create sequence chambresequence;
create sequence administrateursequence;
create sequence equipementsequence;
create sequence typechambresequence;
create sequence equipementchambresequence;

create table typechambre(
id int primary key,
nomtype varchar(70),
imagetype varchar(150);
);
insert into typechambre values(nextval('typechambresequence'),'simple','img_1.jpg');
insert into typechambre values(nextval('typechambresequence'),'double','img_2.jpg');
create table chambre (
	id int primary key,
    nomchambre varchar(30),
    prix int,
  	idtype int ,
    description varchar(150),
    nombrepersonne int,
    	imagechambre varchar(150),
 	foreign key (idtype) references typechambre(id)
);


create table equipement (
	id int primary key,
	nomequipement varchar(100)
);
create table equipementchambre(
	id int primary key,
	idchambre int ,
	idequipement int,
	nombre int,
	foreign key (idchambre) references chambre(id),
	foreign key (idequipement) references equipement(id),
);

create table administrateur(
	id int primary key,
    nom varchar(50),
    mdpadmin varchar(100)
);
insert into administrateur values(nextval('administrateursequence'),'admin','admin');


CREATE OR REPLACE VIEW public.chambreview AS
 SELECT chambre.id,
    chambre.nomchambre,
    typechambre.nomtype,
    chambre.prix,
    chambre.description,
    chambre.nombrepersonne,
    chambre.imagechambre,
    equipement.nomequipement,
    equipementchambre.nombre AS nombreequipement
   FROM chambre
     JOIN equipementchambre ON chambre.id = equipementchambre.idchambre
     JOIN equipement ON equipement.id = equipementchambre.idequipement
     JOIN typechambre ON typechambre.id = chambre.idtype;