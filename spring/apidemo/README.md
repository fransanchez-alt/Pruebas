# Ejemplo de API REST con Spring Boot y Neodatis

Este proyecto demuestra cómo crear una API REST simple usando Spring Boot que consulta una base de datos orientada a objetos Neodatis.

## Funcionalidades

- **Entidad Jugador**: Representa un jugador con id, nombre, posición y edad.
- **Servicio JugadorService**: Maneja las operaciones con la base de datos Neodatis.
- **Controlador REST JugadorController**: Expone endpoints para obtener datos de jugadores.
- **Cliente ClienteJugadores**: Demuestra cómo hacer peticiones HTTP al servidor (basado en conceptos de GestorPeticionesHTTP).

## Endpoints

- `GET /jugadores`: Retorna una lista de todos los jugadores.
- `GET /jugadores/{id}`: Retorna un jugador específico por ID.

## Cómo ejecutar

1. Compilar el proyecto:
   ```
   mvn clean compile
   ```

2. Ejecutar el servidor:
   ```
   mvn spring-boot:run
   ```

3. En otra terminal, ejecutar el cliente para probar:
   ```
   mvn dependency:copy-dependencies -DoutputDirectory=target/dependency
   java -cp target/classes:target/dependency/* com.fran.apidemo.ClienteJugadores
   ```

O usar curl:
```
curl http://localhost:8080/jugadores
curl http://localhost:8080/jugadores/1
```

## Tecnologías utilizadas

- Spring Boot (Web MVC)
- Neodatis ODB (Base de datos orientada a objetos)
- Maven

## Conceptos enseñados

- Creación de APIs REST con Spring Boot
- Integración con bases de datos NoSQL orientadas a objetos
- Manejo de peticiones HTTP (cliente y servidor)
- Serialización JSON automática