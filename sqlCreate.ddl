-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-07-02 23:39:50 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE accidente (
    id_accidente          INTEGER NOT NULL,
    hora                  DATE,
    fecha                 DATE,
    descripcion           VARCHAR2(500),
    gravedad_id_gravedad  INTEGER NOT NULL,
    persona_id_persona    INTEGER NOT NULL,
    asesoria_id_asesoria  INTEGER
);

CREATE UNIQUE INDEX accidente__idx ON
    accidente (
        asesoria_id_asesoria
    ASC );

ALTER TABLE accidente ADD CONSTRAINT accidente_pk PRIMARY KEY ( id_accidente );

CREATE TABLE asesoria (
    id_asesoria         INTEGER NOT NULL,
    tema                VARCHAR2(200),
    objetivo            VARCHAR2(500),
    fecha_solicitud     DATE,
    cliente_id_cliente  INTEGER NOT NULL,
    visita_id_visita    INTEGER
);

CREATE UNIQUE INDEX asesoria__idx ON
    asesoria (
        visita_id_visita
    ASC );

ALTER TABLE asesoria ADD CONSTRAINT asesoria_pk PRIMARY KEY ( id_asesoria );

CREATE TABLE capacitacion (
    id_capacitacion     INTEGER NOT NULL,
    descripcion         VARCHAR2(500),
    objetivo            VARCHAR2(200),
    fecha_solicitud     DATE,
    cliente_id_cliente  INTEGER NOT NULL,
    visita_id_visita    INTEGER
);

CREATE UNIQUE INDEX capacitacion__idx ON
    capacitacion (
        visita_id_visita
    ASC );

ALTER TABLE capacitacion ADD CONSTRAINT capacitacion_pk PRIMARY KEY ( id_capacitacion );

CREATE TABLE cliente (
    id_cliente          INTEGER NOT NULL,
    nombre              VARCHAR2(200),
    rut                 VARCHAR2(12),
    correo_electronico  VARCHAR2(200),
    direccion           VARCHAR2(200),
    comuna_id_comuna    INTEGER NOT NULL,
    numero_direccion    INTEGER
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_cliente );

CREATE TABLE comuna (
    id_comuna         INTEGER NOT NULL,
    comuna            VARCHAR2(200),
    region_id_region  INTEGER NOT NULL
);

ALTER TABLE comuna ADD CONSTRAINT comuna_pk PRIMARY KEY ( id_comuna );

CREATE TABLE gravedad (
    id_gravedad  INTEGER NOT NULL,
    nivel        VARCHAR2(10)
);

ALTER TABLE gravedad ADD CONSTRAINT gravedad_pk PRIMARY KEY ( id_gravedad );

CREATE TABLE persona (
    id_persona  INTEGER NOT NULL,
    nombre      VARCHAR2(200),
    apellido    VARCHAR2(200),
    edad        INTEGER
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( id_persona );

CREATE TABLE profesional (
    id_profesional  INTEGER NOT NULL,
    rut             VARCHAR2(12),
    nombre          VARCHAR2(100),
    apellido        VARCHAR2(100)
);

ALTER TABLE profesional ADD CONSTRAINT profesional_pk PRIMARY KEY ( id_profesional );

CREATE TABLE region (
    id_region  INTEGER NOT NULL,
    region     VARCHAR2(200)
);

ALTER TABLE region ADD CONSTRAINT region_pk PRIMARY KEY ( id_region );

CREATE TABLE rol (
    id_rol  INTEGER NOT NULL,
    rol     VARCHAR2(20)
);

ALTER TABLE rol ADD CONSTRAINT rol_pk PRIMARY KEY ( id_rol );

CREATE TABLE usuario (
    id_usuario   INTEGER NOT NULL,
    usuario      VARCHAR2(20),
    contrasenia  VARCHAR2(20),
    rol_id_rol   INTEGER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

CREATE TABLE visita (
    id_visita                     INTEGER NOT NULL,
    fecha_visita                  DATE,
    hora_visita                   DATE,
    duracion                      VARCHAR2(20),
    asesoria_id_asesoria          INTEGER,
    capacitacion_id_capacitacion  INTEGER
);

CREATE UNIQUE INDEX visita__idx ON
    visita (
        capacitacion_id_capacitacion
    ASC );

CREATE UNIQUE INDEX visita__idxv1 ON
    visita (
        asesoria_id_asesoria
    ASC );

ALTER TABLE visita ADD CONSTRAINT visita_pk PRIMARY KEY ( id_visita );

ALTER TABLE accidente
    ADD CONSTRAINT accidente_asesoria_fk FOREIGN KEY ( asesoria_id_asesoria )
        REFERENCES asesoria ( id_asesoria );

ALTER TABLE accidente
    ADD CONSTRAINT accidente_gravedad_fk FOREIGN KEY ( gravedad_id_gravedad )
        REFERENCES gravedad ( id_gravedad );

ALTER TABLE accidente
    ADD CONSTRAINT accidente_persona_fk FOREIGN KEY ( persona_id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE asesoria
    ADD CONSTRAINT asesoria_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE asesoria
    ADD CONSTRAINT asesoria_visita_fk FOREIGN KEY ( visita_id_visita )
        REFERENCES visita ( id_visita );

ALTER TABLE capacitacion
    ADD CONSTRAINT capacitacion_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE capacitacion
    ADD CONSTRAINT capacitacion_visita_fk FOREIGN KEY ( visita_id_visita )
        REFERENCES visita ( id_visita );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_comuna_fk FOREIGN KEY ( comuna_id_comuna )
        REFERENCES comuna ( id_comuna );

ALTER TABLE comuna
    ADD CONSTRAINT comuna_region_fk FOREIGN KEY ( region_id_region )
        REFERENCES region ( id_region );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_rol_fk FOREIGN KEY ( rol_id_rol )
        REFERENCES rol ( id_rol );

ALTER TABLE visita
    ADD CONSTRAINT visita_asesoria_fk FOREIGN KEY ( asesoria_id_asesoria )
        REFERENCES asesoria ( id_asesoria );

ALTER TABLE visita
    ADD CONSTRAINT visita_capacitacion_fk FOREIGN KEY ( capacitacion_id_capacitacion )
        REFERENCES capacitacion ( id_capacitacion );


CREATE SEQUENCE idvisita_sequence MINVALUE 1 START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE idcliente_sequence MINVALUE 1 START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE idPersona INCREMENT BY 1 START WITH 1; 

CREATE SEQUENCE idAccidente INCREMENT BY 1 START WITH 1;

create sequence IDCAPACITACION increment by 1 start with 1;


INSERT INTO Gravedad VALUES(1, 'Grave');
INSERT INTO Gravedad VALUES(2, 'Medio');
INSERT INTO Gravedad VALUES(3, 'Leve');


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            12
-- CREATE INDEX                             5
-- ALTER TABLE                             24
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
