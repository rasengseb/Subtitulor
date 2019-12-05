
CREATE SEQUENCE fichier_id_seq;

CREATE TABLE Fichier (
                id INTEGER NOT NULL DEFAULT nextval('fichier_id_seq'),
                nom VARCHAR NOT NULL,
                CONSTRAINT fichier_pk PRIMARY KEY (id)
);


ALTER SEQUENCE fichier_id_seq OWNED BY Fichier.id;

CREATE SEQUENCE language_id_seq;

CREATE TABLE Language (
                id INTEGER NOT NULL DEFAULT nextval('language_id_seq'),
                langue VARCHAR NOT NULL,
                CONSTRAINT language_pk PRIMARY KEY (id)
);


ALTER SEQUENCE language_id_seq OWNED BY Language.id;

CREATE TABLE Traduction (
                id_fichier INTEGER NOT NULL,
                numeroTrad INTEGER NOT NULL,
                temps VARCHAR NOT NULL,
                id_langue_source INTEGER NOT NULL,
                ligne1_source VARCHAR NOT NULL,
                ligne2_source VARCHAR NOT NULL,
                id_langue_trad INTEGER NOT NULL,
                ligne1_trad VARCHAR NOT NULL,
                ligne2_trad VARCHAR NOT NULL
);


ALTER TABLE Traduction ADD CONSTRAINT fichier_traduction_fk
FOREIGN KEY (id_fichier)
REFERENCES Fichier (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Traduction ADD CONSTRAINT language_traduction_fk
FOREIGN KEY (id_langue_source)
REFERENCES Language (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Traduction ADD CONSTRAINT language_traduction_fk1
FOREIGN KEY (id_langue_trad)
REFERENCES Language (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
