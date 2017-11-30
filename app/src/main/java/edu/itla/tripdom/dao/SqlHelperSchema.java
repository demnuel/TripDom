package edu.itla.tripdom.dao;

/**
 * Created by David on 26/11/2017.
 */

public class SqlHelperSchema {

    public static final String USUARIO_TABLE = "CREATE TABLE `Usuario` (`id`	INTEGER PRIMARY KEY AUTOINCREMENT,`nombre`	TEXT NOT NULL,`tipoUsuario`	TEXT NOT NULL,`descripcion`	TEXT NOT NULL,`estatus`	TEXT NOT NULL, `email`	TEXT NOT NULL,`origen`	TEXT NOT NULL,`cupo`	TEXT NOT NULL);";
    // CREAR LAS RESTANTES ENTIDADE

    public static final String PUBLICACION_TABLE= "CREATE TABLE `Publicacion` (`id`	INTEGER PRIMARY KEY AUTOINCREMENT,`fecha`	NUMERIC NOT NULL,`fechaViaje`	NUMERIC NOT NULL,`costo`	NUMERIC NOT NULL, `estado`	TEXT NOT NULL, `usuarioId`	NUMERIC NOT NULL );";

    public static final String PUBLICACIONDETALLE_TABLE = "CREATE TABLE `PublicacionDetalle` (`id`	INTEGER PRIMARY KEY AUTOINCREMENT,`publicacionId`	INTEGER NOT NULL,`lugar`	TEXT NOT NULL);";
}
