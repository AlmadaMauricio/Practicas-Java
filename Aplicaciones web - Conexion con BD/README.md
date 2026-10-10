# Aplicaciones web - Conexion con BD

Trabajo práctico de Java: aplicación web con JSP y conexión a base de datos.

## Consigna

### Ejercicio 1

El ejercicio trabaja con la base de datos **SegurosGroup** y tiene tres vistas:

- Inicio
- Agregar seguro
- Listar seguros

En cada vista hay tres enlaces que llevan a las vistas respectivas.

#### Inicio.jsp

Solo muestra la información: *"Soy la página inicio"*.

#### AgregarSeguro.jsp

Permite agregar seguros a la base de datos.

- El **ID Seguro** se genera automáticamente y contiene el ID del nuevo seguro a registrar.
- Los **tipos de seguros** se cargan con los tipos existentes en la base de datos.

#### ListarSeguros.jsp

Muestra todos los seguros que se encuentran en la base de datos. También permite filtrar los seguros seleccionando un tipo de seguro.