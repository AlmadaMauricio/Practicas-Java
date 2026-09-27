package main;

import entidad.Categoria;
import entidad.Producto;

import java.util.ArrayList;
import java.util.ListIterator;

import dao.DaoCategoria;
import dao.DaoProducto;

public class Principal {

    public static void main(String[] args) {
        
        DaoCategoria daoCategoria = new DaoCategoria();
        DaoProducto daoProducto = new DaoProducto();
        
        System.out.println("=== PRUEBA ABML ===");
        
        // 1. Alta de Categorías 
        System.out.println("Cargando categorías iniciales...");
        Categoria cat1 = new Categoria(1, "Tecnología");
        Categoria cat2 = new Categoria(2, "Muebles");
        
        daoCategoria.agregarCategoria(cat1);
        daoCategoria.agregarCategoria(cat2);
        
        // Prueba de modificacion de categoria
        Categoria categoriaModificada = new Categoria(1, "Tecnologia y Computacion");
        int filasModificadas = daoCategoria.modificarCategoria(categoriaModificada);

        if (filasModificadas > 0) {
            System.out.println("Categoría modificada correctamente.");
        } else {
            System.out.println("No se pudo modificar categoría.");
        }

        // Prueba de baja de categoria temporal
        Categoria categoriaTemporal = new Categoria(3, "Temporal");
        int filasAltaTemporal = daoCategoria.agregarCategoria(categoriaTemporal);

        if (filasAltaTemporal > 0) {
            daoCategoria.bajaCategoria(categoriaTemporal);
            System.out.println("Categoria temporal eliminada correctamente");
        } else {
            System.out.println("No se pudo crear categoria temporal para borrarla");
        }
        
        System.out.println("Categorías cargadas correctamente. Listo para ingresar productos.");
        
     // 2. Carga de 10 productos utilizando el procedimiento almacenado
        System.out.println("Enviando 10 productos para su alta en bdInventario...");
        
        Producto p1 = new Producto("PROD01", "Notebook", 1500.50, 10, 1);
        Producto p2 = new Producto("PROD02", "Mouse Inalámbrico", 25.00, 50, 1);
        Producto p3 = new Producto("PROD03", "Teclado Mecánico", 85.50, 30, 1);
        Producto p4 = new Producto("PROD04", "Monitor 24", 200.00, 15, 1);
        Producto p5 = new Producto("PROD05", "Auriculares", 45.00, 40, 1);
        Producto p6 = new Producto("PROD06", "Silla Gamer", 250.00, 5, 2);
        Producto p7 = new Producto("PROD07", "Escritorio", 180.00, 8, 2);
        Producto p8 = new Producto("PROD08", "Pad Mouse", 10.00, 100, 1);
        Producto p9 = new Producto("PROD09", "Webcam HD", 60.00, 20, 1);
        Producto p10 = new Producto("PROD10", "Micrófono", 120.00, 12, 1);
        
        // Ejecutamos el SP para cada producto
        daoProducto.altaProductoConProcedimiento(p1);
        daoProducto.altaProductoConProcedimiento(p2);
        daoProducto.altaProductoConProcedimiento(p3);
        daoProducto.altaProductoConProcedimiento(p4);
        daoProducto.altaProductoConProcedimiento(p5);
        daoProducto.altaProductoConProcedimiento(p6);
        daoProducto.altaProductoConProcedimiento(p7);
        daoProducto.altaProductoConProcedimiento(p8);
        daoProducto.altaProductoConProcedimiento(p9);
        daoProducto.altaProductoConProcedimiento(p10);
        
        System.out.println("Los 10 productos fueron procesados por el Procedimiento Almacenado.");
        
     // 3. Modificacion de Producto
        System.out.println("Modificando producto PROD01...");
        Producto productoModificado = new Producto("PROD01", "Notebook Pro", 1800.00, 8, 1);
        int filasModProd = daoProducto.modificarProducto(productoModificado);
        if (filasModProd > 0) {
            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("No se pudo modificar el producto.");
        }
        
     // 4. Prueba de alta y baja de producto (ABML)
        System.out.println("Baja de producto temporal");

        Producto productoTemporal = new Producto(
            "TEMP01",
            "Producto temporal",
            1.00,
            1,
            1
        );

        int filasAltaProd = daoProducto.agregarProducto(productoTemporal);

        if (filasAltaProd > 0) {
            System.out.println("Producto temporal creado correctamente.");

            int filasBajaProd = daoProducto.bajaProducto(productoTemporal);

            if (filasBajaProd > 0) {
                System.out.println("Producto temporal eliminado correctamente");
            } else {
                System.out.println("No se pudo eliminar el producto temporal");
            }
        } else {
            System.out.println("No se pudo crear el producto temporal");
        }
        
     // 5.Listamos las catogorias y Productos
        System.out.println("-------Listado de Catogorias----------");
        
        ArrayList<Categoria> lCategoria = new ArrayList<Categoria>();
        lCategoria=daoCategoria.listadoCategoria();
        ListIterator<Categoria> ILC = lCategoria.listIterator();
        while (ILC.hasNext()) {
			Categoria categoria = (Categoria) ILC.next();
			System.out.println(categoria.toString());
		}
        
        System.out.println("-------Listado de Productos----------");
        
        ArrayList<Producto> lProducto = new ArrayList<Producto>();
        lProducto=daoProducto.listadoProducto();
        ListIterator<Producto> ILP = lProducto.listIterator();
        while (ILP.hasNext()) {
			Producto producto = (Producto) ILP.next();
			System.out.println(producto.toString());;
		}
    }
}