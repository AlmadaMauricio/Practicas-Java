package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguro;
import dominio.TipoSeguro;

public class SeguroDao {

    private String dbName = "SegurosGroup";
    private String host = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    private String user = "root";
    private String pass = "root";

    // Método para insertar un seguro nuevo en la BD
    public boolean agregarSeguro(Seguro seguro) {
        boolean filasAfectadas = false;
        Connection cn = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	cn = DriverManager.getConnection(host, user, pass);
            String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, seguro.getDescripcion());
            pst.setInt(2, seguro.getTipo().getIdTipo());
            pst.setDouble(3, seguro.getCostoContratacion());
            pst.setDouble(4, seguro.getCostoAsegurado());

            if (pst.executeUpdate() > 0) {
                filasAfectadas = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filasAfectadas;
    }
    
    // Método para obtener la lista de seguros
    public ArrayList<Seguro> obtenerTodos() {
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        Connection cn = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	cn = DriverManager.getConnection(host, user, pass);
            // Hacemos un JOIN para traer también la descripción del Tipo de Seguro
            String query = "SELECT s.idSeguro, s.descripcion, s.idTipo, s.costoContratacion, s.costoAsegurado, t.descripcion as descTipo " +
                           "FROM seguros s " +
                           "INNER JOIN tipoSeguros t ON s.idTipo = t.idTipo";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Seguro seguro = new Seguro();
                seguro.setIdSeguro(rs.getInt("idSeguro"));
                seguro.setDescripcion(rs.getString("descripcion"));
                seguro.setCostoContratacion(rs.getDouble("costoContratacion"));
                seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));

                TipoSeguro tipo = new TipoSeguro();
                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setDescripcion(rs.getString("descTipo"));
                
                seguro.setTipo(tipo);

                listaSeguros.add(seguro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaSeguros;
    }
    
 // Método para obtener los seguros de un tipo determinado (filtro)
    public ArrayList<Seguro> obtenerPorTipo(int idTipo) {
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(host, user, pass);
            String query = "SELECT s.idSeguro, s.descripcion, s.idTipo, s.costoContratacion, s.costoAsegurado, t.descripcion as descTipo " +
                           "FROM seguros s " +
                           "INNER JOIN tipoSeguros t ON s.idTipo = t.idTipo " +
                           "WHERE s.idTipo = ?";

            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, idTipo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Seguro seguro = new Seguro();
                seguro.setIdSeguro(rs.getInt("idSeguro"));
                seguro.setDescripcion(rs.getString("descripcion"));
                seguro.setCostoContratacion(rs.getDouble("costoContratacion"));
                seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));

                TipoSeguro tipo = new TipoSeguro();
                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setDescripcion(rs.getString("descTipo"));

                seguro.setTipo(tipo);

                listaSeguros.add(seguro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaSeguros;
    }
    
 // Método para saber qué ID mostrar en el formulario
    public Integer obtenerProximoId() {
        Integer proximoId = null;
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(host, user, pass);
            Statement st = cn.createStatement();

            String query = "SHOW TABLE STATUS LIKE 'seguros'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                proximoId = rs.getInt("Auto_increment");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return proximoId;
    }
}
