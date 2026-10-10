package dao;

import dominio.TipoSeguro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {

    private String dbName = "SegurosGroup";
    private String host = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    private String user = "root";
    private String pass = "root";

    public ArrayList<TipoSeguro> listadoTipoSeguro() {
        ArrayList<TipoSeguro> lTipoSeguro =
                new ArrayList<TipoSeguro>();

        Connection cn = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	cn = DriverManager.getConnection(host, user, pass);

            String query = "Select idTipo, descripcion from tipoSeguros";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                TipoSeguro x = new TipoSeguro();
                x.setIdTipo(rs.getInt(1));
                x.setDescripcion(rs.getString(2));
                lTipoSeguro.add(x);
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

        return lTipoSeguro;
    }
}