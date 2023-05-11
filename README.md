# tekbeesRepo

En el primer commit se entrega la siguiente funcionalidad:
a. Consultar la cantidad de viajes totales.
b. Consultar la cantidad de viajes totales por ciudad.
c. Consultar la cantidad de viajes totales por país.
d. Crear un viaje.
e. Actualizar un viaje.
f. Consultar los viajes actuales.

Instalacion:
1.Crear una nueva collection en MongoDb Compasss llamada Trip
2.Clonar el proyecto.
3.Ejecutar el proyecto 
4. en Postman probar los siguientes endpoints:
  4.1 http://localhost:8080/trips/all/Medellin?pageNumber=2&pageSize=10  Obtener todos los viajes por ciudad
  4.2 http://localhost:8080/trips/count    total de viajes
  4.3 http://localhost:8080/trips/city  totald de viajes por ciudad
  4.4 http://localhost:8080/trips/country total de viajes por pais
  4.5 http://localhost:8080/trips/create  crear un viaje
  4.6 http://localhost:8080/trips/update/{id}  actualizar un viaje

 
