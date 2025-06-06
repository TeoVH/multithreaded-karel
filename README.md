# Simulación Multihilo del Metro de Medellín con KarelJRobot

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)
[![Karel](https://img.shields.io/badge/KarelJRobot-1.0.0-blue?style=for-the-badge)](https://github.com/your-repo)

Simulación del sistema de metro de Medellín implementada en Java utilizando programación multihilo. El proyecto simula el funcionamiento de tres líneas principales (Niquía, Estrella y San Javier) con 32 trenes operando simultáneamente, implementando mecanismos de sincronización para evitar colisiones y coordinar el movimiento de los trenes.

## Características Principales

- Simulación de tres líneas del metro: Niquía, Estrella y San Javier
- Sistema de control de colisiones mediante matriz de ocupación
- Sincronización de trenes usando CyclicBarrier
- Coordinación de inicio de rutas principales
- Visualización en tiempo real del movimiento de los trenes
- Control especial para el cruce en San Antonio B
- Sistema de retorno al taller al finalizar operaciones (11 PM)

## Requisitos

- Java JDK 8 o superior
- KarelJRobot.jar
- Sistema operativo compatible con Java

## Estructura del Proyecto

```
multithreaded-karel/
├── Trabajos/
│   ├── Main.java                 # Punto de entrada y configuración inicial
│   ├── MetroMedellin.java        # Clase principal con lógica de trenes
│   ├── Rutas.java               # Definición de rutas para cada línea
│   ├── MetroMedellin.kwld       # Archivo de configuración del mundo
│   ├── KarelJRobot.jar          # Biblioteca KarelJRobot
│   ├── Compilar.bat             # Script para compilar el proyecto
│   └── Run.bat                  # Script para ejecutar la simulación
```

## Compilación y Ejecución

1. Ingresar a la carpeta

   ```bash
   cd Trabajos/
   ```

2. Compilar el proyecto:

   ```bash
   ./Compilar.bat
   ```

3. Ejecutar la simulación:

   ```bash
   ./Run.bat
   ```

## Mecanismos de Sincronización

- **Matriz de Ocupación**: Controla las posiciones de los trenes para evitar colisiones
- **CyclicBarrier**: Coordina el inicio de las rutas principales
- **Barrera San Javier**: Asegura que los trenes de San Javier lleguen primero
- **Locks**: Gestionan el acceso a recursos compartidos
- **Semáforo San Antonio B**: Controla el acceso a la estación compartida

## Distribución de Trenes

- **Línea Niquía**: 7 trenes (color rojo)
- **Línea Estrella**: 15 trenes (color azul)
- **Línea San Javier**: 10 trenes (color verde)

## Controles

- Presiona Enter para iniciar los recorridos de los trenes
- Presiona Enter nuevamente cuando sean las 11 PM para finalizar la operación

## Autores

- [Santiago Gómez Ospina]
- [Juan Esteban Alzate]
- [Mateo Villada]