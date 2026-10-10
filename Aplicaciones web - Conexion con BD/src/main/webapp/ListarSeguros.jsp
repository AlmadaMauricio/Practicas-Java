<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.Seguro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de seguros</title>
</head>
<body>

<a href="Inicio.jsp">Inicio</a>
<a href="AgregarSeguro">Agregar Seguros</a>
<a href="ListarSeguros">Listar Seguros</a>

<h2>Tipo de seguros en la base de datos</h2>

<form method="post" action="ListarSeguros">
	<label>Busqueda por tipo de seguro: </label>
	<select name="tipoSeguro" id="tipoSeguro">
		<%
			Integer tipoSeleccionado = (Integer) request.getAttribute("tipoSeleccionado");
			if (tipoSeleccionado == null) tipoSeleccionado = 0;
		%>
		<option value="0" <%= (tipoSeleccionado == 0) ? "selected" : "" %>>Todo</option>
		<%
			ArrayList<TipoSeguro> listTipos=(ArrayList<TipoSeguro>) request.getAttribute("tiposSeguro");
			if(listTipos !=null){
				for(TipoSeguro tSeguros : listTipos){
		%>
				<option value="<%=tSeguros.getIdTipo()%>"<%=(tipoSeleccionado == tSeguros.getIdTipo()) ? "selected" : "" %>><%=tSeguros.getDescripcion()%></option>
		
		<%			
				}
			}
		%>
	</select>
	<input type="submit" name="btnFiltrar" value="Filtrar">
</form>

<%
	ArrayList<Seguro> listaSeguros=(ArrayList<Seguro>) request.getAttribute("listaS");
%>

<table border="1">
	<tr> <th> ID Seguros</th> <th>Descripcion Seguros</th> <th>Descripcion Tipo Seguro</th> <th>Costo Contratacion</th> <th>Costo Maximo Asegurado</th></tr>
	
	<%
	if(listaSeguros != null){
		for(Seguro seguros : listaSeguros){%>	
		
		<tr> <th><%=seguros.getIdSeguro() %></th> <th><%=seguros.getDescripcion() %></th> <th><%=seguros.getTipo().getDescripcion() %></th> <th><%=seguros.getCostoContratacion() %></th> <th><%=seguros.getCostoAsegurado()%></th></tr>
	
	<%
		}
	}%>

</table>

</body>
</html>
