Aplicación de Consola JDBC / DAO
📋 Consigna y Pautas del Proyecto

Nota: Todas las clases e interfaces pertenecientes a este ejercicio deben organizarse según la estructura de paquetes indicada (dao, entidad, main).

Configuración de Base de Datos

Motor de Base de Datos: MySQL.

Procedimientos Almacenados: Crear y utilizar el procedimiento almacenado sp_AgregarProducto en la base de datos para gestionar la inserción de nuevos productos.

Estructura de Paquetes y Clases

Paquete entidad:

Clase Categoria: Modela las categorías de los productos. Aplicar encapsulamiento (atributos privados, getters y setters) y sobrescribir el método toString().

Clase Producto: Modela los productos y su relación con una categoría. Aplicar encapsulamiento y sobrescribir el método toString().

Paquete dao:

Clase DaoCategoria: Implementar los métodos correspondientes para realizar las operaciones de ABML (Alta, Baja, Modificación y Listado) sobre la entidad Categoria.

Clase DaoProducto: Implementar las operaciones de ABML sobre la entidad Producto.

Requisito especial: El método de Alta en DaoProducto debe invocar de forma obligatoria el procedimiento almacenado sp_AgregarProducto.

Clase Principal y Prueba de Funcionamiento

Paquete main:

Crear la clase Principal con el método main.

Probar de manera secuencial el ABML completo de categorías.

Probar de manera secuencial el ABML completo de productos.

Realizar el alta de productos verificando la correcta ejecución del procedimiento almacenado sp_AgregarProducto.

Carga de datos: Cargar al menos 10 productos asociándolos a sus respectivas categorías para validar el correcto funcionamiento del sistema y la persistencia de los datos en MySQL.
