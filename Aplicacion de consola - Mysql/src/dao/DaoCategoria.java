package dao;

import entidad.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCategoria {

    private String dbName = "bdInventario";
    private String host = "jdbc:mysql://localhost:3306/"+ dbName + "?useSSL=false";
	private String user = "root";
	private String pass = "root";

	public int agregarCategoria(Categoria categoria) {
		String query = "INSERT INTO Categorias (Nombre) VALUES (?)";
		Connection cn = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, categoria.getNombre());
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

	public int bajaCategoria(Categoria categoria) {
	    String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
	    Connection cn = null;
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host, user, pass);
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setInt(1, categoria.getIdCategoria());
	        filas = pst.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return filas;
	}

	public int modificarCategoria(Categoria categoria) {
		Connection cn = null;
		int row = 0;

		try {
			cn = DriverManager.getConnection(host, user, pass);
			String query = "Update Categorias set Nombre=? WHERE IdCategoria=?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, categoria.getNombre());
			pst.setInt(2, categoria.getIdCategoria());

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

	public ArrayList<Categoria> listadoCategoria() {
		ArrayList<Categoria> lCategoria = new ArrayList<Categoria>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host, user, pass);
			String query = "Select * from Categorias";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Categoria x = new Categoria();
				x.setIdCategoria(rs.getInt(1));
				x.setNombre(rs.getString(2));
				lCategoria.add(x);
			}

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

		return lCategoria;
	}
}