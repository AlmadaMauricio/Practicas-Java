package dao;

import entidad.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProducto {
    private String dbName = "bdInventario";
    private String host = "jdbc:mysql://localhost:3306/"+ dbName + "?useSSL=false";
    private String user = "root";
    private String pass = "root";
    
    public int agregarProducto(Producto producto) {
    	String query = "INSERT INTO Productos(Codigo,Nombre,Precio,Stock,IdCategoria) values (?,?,?,?,?)";
    
    	Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host, user, pass);
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, producto.getCodigo());
            pst.setString(2, producto.getNombre());
            pst.setDouble(3, producto.getPrecio());
            pst.setInt(4, producto.getStock());
            pst.setInt(5, producto.getIdCategoria());

            filas = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filas;
    }
    
    public int bajaProducto(Producto producto) {
        String query = "DELETE FROM Productos WHERE Codigo = ?";
        int filas = 0;

        try (Connection cn = DriverManager.getConnection(host, user, pass);
             PreparedStatement pst = cn.prepareStatement(query)) {

            pst.setString(1, producto.getCodigo());
            filas = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filas;
    }
    
    public int modificarProducto(Producto producto) {
        Connection cn = null;
        int row = 0;
        
        try {
            cn = DriverManager.getConnection(host, user, pass);
            String query = "UPDATE Productos SET Nombre=?, Precio=?, Stock=?, IdCategoria=? WHERE Codigo=?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, producto.getNombre());
            pst.setDouble(2, producto.getPrecio());
            pst.setInt(3, producto.getStock());
            pst.setInt(4, producto.getIdCategoria());
            pst.setString(5, producto.getCodigo());
            
            row = pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }

    public int altaProductoConProcedimiento(Producto producto) {
        String query = "{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}";
        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host, user, pass);
            CallableStatement cs = cn.prepareCall(query);
            cs.setString(1, producto.getCodigo());
            cs.setString(2, producto.getNombre());
            cs.setDouble(3, producto.getPrecio());
            cs.setInt(4, producto.getStock());
            cs.setInt(5, producto.getIdCategoria());
            filas = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filas;
    }
    
    public ArrayList<Producto> listadoProducto(){
    	ArrayList<Producto> lProducto = new ArrayList<Producto>();
    	
    	Connection cn=null;
    	try {
    		cn = DriverManager.getConnection(host, user, pass);
    		String query = "Select * from Productos";
    		Statement st = cn.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()) {
    			Producto x = new Producto();
    			x.setCodigo(rs.getString(1));
    			x.setNombre(rs.getString(2));
    			x.setPrecio(rs.getDouble(3));
    			x.setStock(rs.getInt(4));
    			x.setIdCategoria(rs.getInt(5));
    			lProducto.add(x);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (cn != null) {
                    cn.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	
    	return lProducto;
    }
}