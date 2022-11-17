CREATE DATABASE biblioteca_escobar;
use biblioteca_escobar;


CREATE TABLE escobar_usuarios(
    usuario VARCHAR(20) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL
);


CREATE TABLE escobar_libros_infantiles(
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_superacion_personal (
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_cientificos (
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_literatura (
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_colecciones (
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_ebook (
    id_libro INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    resumen TEXT NOT NULL
);

CREATE TABLE escobar_libros_reservados(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    id_libro INTEGER NOT NULL,
    usuario VARCHAR(20) NOT NULL
);

INSERT INTO escobar_usuarios VALUES('juan_diego.cobo', 'Juan Diego Cobo', '123');

