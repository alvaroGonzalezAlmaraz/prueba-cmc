# api-rest-springboot
Api REST creada con Springboot y VisualCodeStudio

Base de datos H2
Nombre base datos: test
user: admin
password: 1234

He creado un archivo import.sql que crea varios usuarios al inciciar la aplicacion.

Las urls para las peticiones son:
 - /usuario- Method Get devuelve el listado de usuarios. 
 - /usuario- Method Post crea un nuevo usuario que se pase en el body de la petición http.
 - /usuario/{id} - Method Get, devuelve el usuario cuyo id coincida con el especificado en la ruta.
 - /usuario/{id} - Method Delete, elimina el usuario cuyo id coincida con el especificado en la ruta.

 Tests: he creado un test unitario con Junit y Mockito que comprueba una de las peticiones, en concreto la que devuelve el usuario por la id.

