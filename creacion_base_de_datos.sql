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


/*
    ¡Categoría!
    Si no tenemos una categoría podría suceder que el id_libro 1 aplique
    para libro de ciencias o para libro de literatura, etc.

    Infantiles => 1
    Superación personal => 2
    Científicos => 3
    Literatura => 4
    Colecciones => 5
    Ebook => 6
*/
CREATE TABLE escobar_libros_reservados(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    id_libro INTEGER NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    categoria INTEGER NOT NULL -- Ver comentario de arriba
);

-- Inserciones de usuarios
INSERT INTO escobar_usuarios VALUES('juan_diego.cobo', 'Juan Diego Cobo', '123');
INSERT INTO escobar_usuarios VALUES('laura.yusu', 'Laura Escobar', '124');

-- Inserciones de libros infantiles
INSERT INTO escobar_libros_infantiles(nombre, autor, resumen) VALUES(
    "The Little Prince",
    "Antoine de Saint-Exupéry",
    "The Little Prince (French: Le Petit Prince, pronounced [lә p(ә)ti pᴚἕS]) is a novella..."
);

INSERT INTO escobar_libros_infantiles(nombre, autor, resumen) VALUES(
    "Las aventuras de Alicia en el país de las maravillas",
    "Lewis_Carroll",
    "Las aventuras de Alicia en el país de las maravillas, comúnmente..."
);

INSERT INTO escobar_libros_infantiles(nombre, autor, resumen) VALUES(
    "El pollo pepe",
    "Nick Denchfield",
    "Pepe es un simpático pollito que ha dado nombre a multitud de escuelas infantiles y aulas de los colegios."
);

-- Inserciones de libros de superación
INSERT INTO escobar_libros_superacion_personal(nombre, autor, resumen) VALUES(
    "Libro de superación personal #1",
    "Laura",
    "El mejor libro de superación"
);

-- Inserciones de libros de cientificos
INSERT INTO escobar_libros_cientificos(nombre, autor, resumen) VALUES(
    "Libro de ciencia #1",
    "Valentina",
    "El mejor libro de ciencia del mundo"
);

-- Inserciones de libros de literatura
INSERT INTO escobar_libros_literatura(nombre, autor, resumen) VALUES(
    "Libro de literatura #1",
    "Key",
    "El mejor libro de literatura del universo"
);

-- Inserciones de libros de colecciones
INSERT INTO escobar_libros_colecciones(nombre, autor, resumen) VALUES(
    "Libro de colecciones #1",
    "SH. Val",
    "De colecciones antiguas"
);

-- Inserciones de libros de ebooks
INSERT INTO escobar_libros_ebook(nombre, autor, resumen) VALUES(
    "Libro E-Book #1",
    "JJ. Darwing",
    "Libros digitales."
);

-- Inserción de dos libros de categorías diferentes reservados para el usuario laura.yusu
INSERT INTO escobar_libros_reservados(id_libro, usuario, categoria) VALUES(
    1,
    "laura.yusu",
    4
);

INSERT INTO escobar_libros_reservados(id_libro, usuario, categoria) VALUES(
    1,
    "laura.yusu",
    3
);