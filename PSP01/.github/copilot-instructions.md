# Guía para agentes AI en este proyecto

Este proyecto contiene un único archivo Java: `Ejemplo5.java`. A continuación se detallan las convenciones y flujos relevantes para que los agentes AI sean productivos rápidamente:

## Arquitectura y propósito
- El proyecto es un ejemplo simple de ejecución de comandos del sistema operativo desde Java usando la clase `Runtime`.
- No existen componentes adicionales, servicios, ni flujos de datos complejos. Todo el código relevante está en `Ejemplo5.java`.

## Flujo principal
- El método `main` ejecuta el comando `date '+%d-%m-%y'` en el sistema operativo y muestra el resultado en consola.
- El proceso se gestiona con manejo explícito de excepciones (`IOException`, `InterruptedException`).
- El valor de salida del proceso se imprime tras la ejecución.

## Convenciones específicas
- Los comandos del sistema se definen como arrays de `String` y se ejecutan con `Runtime.getRuntime().exec()`.
- La lectura de la salida estándar del proceso se realiza con `InputStream` y `BufferedReader`.
- Se utiliza try-with-resources para cerrar automáticamente los streams.
- El formato de fecha del comando puede variar según el sistema operativo; actualmente está adaptado para Unix/Linux/MacOS.

## Ejemplo de patrón principal
```java
String[] comando = {"/bin/sh", "-c", "date '+%d-%m-%y'"};
Process process = Runtime.getRuntime().exec(comando);
try (InputStream is = process.getInputStream();
     BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}
```

## Workflows de desarrollo
- **Compilación:**
  - Compilar con: `javac Ejemplo5.java`
- **Ejecución:**
  - Ejecutar con: `java Ejemplo5`
- **Depuración:**
  - No hay configuración específica; se recomienda usar las herramientas estándar de Java.

## Integraciones y dependencias
- No hay dependencias externas ni integración con otros sistemas.
- El único requisito es tener Java instalado y acceso al shell del sistema.

## Recomendaciones para agentes AI
- Mantener el manejo de excepciones y el uso de try-with-resources.
- Adaptar el comando del sistema si se requiere compatibilidad con Windows.
- Documentar cualquier cambio en el flujo principal en este archivo.

---

Si alguna sección no está clara o falta información relevante, por favor indícalo para mejorar estas instrucciones.