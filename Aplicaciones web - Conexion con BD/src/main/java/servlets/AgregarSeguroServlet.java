package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import dominio.Seguro;
import dominio.TipoSeguro;

import dao.SeguroDao;
import dao.TipoSeguroDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AgregarSeguro")
public class AgregarSeguroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        TipoSeguroDao tipoDao = new TipoSeguroDao();
        SeguroDao seguroDao = new SeguroDao();

        request.setAttribute("tiposSeguro", tipoDao.listadoTipoSeguro());
        request.setAttribute("proximoId", seguroDao.obtenerProximoId());

        request.getRequestDispatcher("/AgregarSeguro.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String mensaje;

        try {
            String descripcion = request.getParameter("txtDescripcion");
            int idTipo = Integer.parseInt(request.getParameter("idTipo"));
            BigDecimal costoContratacion = new BigDecimal(request.getParameter("txtCostoContratacion"));
            BigDecimal costoAsegurado = new BigDecimal(request.getParameter("txtCostoAsegurado"));

            TipoSeguro tipo = new TipoSeguro();
            tipo.setIdTipo(idTipo);

            Seguro seguro = new Seguro();
            seguro.setDescripcion(descripcion);
            seguro.setTipo(tipo);
            seguro.setCostoContratacion(costoContratacion.doubleValue());
            seguro.setCostoAsegurado(costoAsegurado.doubleValue());

            SeguroDao seguroDao = new SeguroDao();
            boolean exito = seguroDao.agregarSeguro(seguro);

            mensaje = exito ? "Seguro agregado correctamente" : "No se pudo agregar el seguro";

        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error al agregar el seguro: datos inválidos";
        }

        request.setAttribute("mensaje", mensaje);
        doGet(request, response);
    }
}
