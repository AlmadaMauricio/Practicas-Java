package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.SeguroDao;
import dao.TipoSeguroDao;
import dominio.Seguro;

@WebServlet("/ListarSeguros")
public class ListarSegurosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarSegurosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoSeguroDao tipoDao = new TipoSeguroDao();
		SeguroDao sDao = new SeguroDao();

        request.setAttribute("tiposSeguro", tipoDao.listadoTipoSeguro());
        request.setAttribute("listaS", sDao.obtenerTodos());
        request.setAttribute("tipoSeleccionado", 0);
        request.getRequestDispatcher("/ListarSeguros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnFiltrar")==null) {
			doGet(request, response);
			return;
		}

		int id;
		try {
			id = Integer.parseInt(request.getParameter("tipoSeguro"));
		} catch (NumberFormatException e) {
			doGet(request, response);
			return;
		}
		if (id < 0) {
			doGet(request, response);
			return;
		}

		TipoSeguroDao tipoDao = new TipoSeguroDao();
		SeguroDao sDao = new SeguroDao();
		ArrayList<Seguro> lista;
		if(id!=0) {
			lista=sDao.obtenerPorTipo(id);
		}
		else {
			lista=sDao.obtenerTodos();
		}

		request.setAttribute("listaS", lista);
		request.setAttribute("tiposSeguro", tipoDao.listadoTipoSeguro());
		request.setAttribute("tipoSeleccionado", id);
		request.getRequestDispatcher("/ListarSeguros.jsp").forward(request, response);
	}

}
