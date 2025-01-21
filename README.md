
# LiterAlura

**LiterAlura** es una aplicación desarrollada en Java que permite buscar libros y sus autores a través de una API pública, almacenarlos en una base de datos y realizar diversas consultas sobre ellos.

## Características

- **Búsqueda de libros**: Permite buscar libros por título utilizando la API de Gutendex.
- **Almacenamiento**: Guarda la información de los libros y autores en una base de datos relacional.
- **Consultas**:
  - Listar libros registrados.
  - Listar autores registrados.
  - Listar autores vivos en un determinado año.
  - Listar libros por idioma.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para facilitar la creación de aplicaciones Java.
- **JPA/Hibernate**: Para el mapeo objeto-relacional y gestión de la base de datos.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Requisitos Previos

- **Java 17** o superior instalado.
- **Maven 3.8.1** o superior instalado.

## Configuración del Proyecto

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/JuanMA0190/LiterAlura.git
   ```

2. **Ingresar al directorio del proyecto**:

   ```bash
   cd LiterAlura
   ```

3. **Construir el proyecto con Maven**:

   ```bash
   mvn clean install
   ```

## Ejecución de la Aplicación

Para ejecutar la aplicación, utiliza el siguiente comando:

```bash
mvn spring-boot:run
```

La aplicación se ejecutará en la consola y mostrará un menú interactivo para realizar las diferentes operaciones disponibles.

## Uso de la Aplicación

Al iniciar la aplicación, se presentará un menú con las siguientes opciones:

1. **Buscar libro por título**: Solicita el título del libro, realiza una búsqueda en la API de Gutendex y almacena la información obtenida en la base de datos.
2. **Listar libros registrados**: Muestra una lista de todos los libros almacenados en la base de datos.
3. **Listar autores registrados**: Muestra una lista de todos los autores almacenados en la base de datos.
4. **Listar autores vivos en un determinado año**: Solicita un año y muestra los autores que estaban vivos en ese año.
5. **Listar libros por idioma**: Solicita un código de idioma y muestra los libros disponibles en ese idioma.

Para seleccionar una opción, ingresa el número correspondiente y sigue las instrucciones proporcionadas.

## Estructura del Proyecto

- **`src/main/java/com/new19/literalura`**: Contiene el código fuente de la aplicación.
  - **`model`**: Define las clases `Libro` y `Autor`, que representan las entidades principales de la aplicación.
  - **`repositorio`**: Contiene las interfaces `LibroRepositorio` y `AutorRepositorio` para la interacción con la base de datos.
  - **`service`**: Incluye las clases `ConsumoAPI` y `ConvierteDatos` para la comunicación con la API externa y la conversión de datos.
  - **`principal`**: Contiene la clase `Principal` que maneja la lógica del menú y las operaciones principales de la aplicación.
- **`src/main/resources`**: Contiene los archivos de configuración y recursos estáticos.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, por favor, abre un issue o envía un pull request con tus sugerencias o mejoras.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
