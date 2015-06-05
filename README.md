# id_practica
Java, Maven, Hibernate, Spring, PostgreSQL.

Tecnologías:
 Java SE 7
 Maven 3
 Spring 4.1.2 RELEASE
 PostgreSQL 9.3
 Log4j1.2.17
 JUnit4.11
 Hibernate 4.3.7




Instrucciones de uso

3.1. Importación del proyecto

Desde Eclipse:
File -->Import... -->Maven -->Existing Maven Projects -->(Ruta del proyecto) -->Finish. 


3.2. Ejecución de los test

Para poder ejecutar los test es necesario tener instalado el gestor de base de datos PostgreSQL.
Luego crear una BD con nombre "appsBD" con el usuario "hib" y password "hib123".
Los datos de configuración de la BD están en el archivo "src/main/resources/database.properties". 
Ejecutar "AllTests.java"(subdirectorio src/test/...) para ejecutar todos los test creados en este proyecto.

