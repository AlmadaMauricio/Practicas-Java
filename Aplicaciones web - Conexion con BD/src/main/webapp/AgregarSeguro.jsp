<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TipoSeguro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar seguro</title>
</head>
<body>

<a href="Inicio.jsp">Inicio</a>
<a href="AgregarSeguro">Agregar Seguros</a>
<a href="ListarSeguros">Listar Seguros</a>

<h1>Agregar Seguros</h1>

<%
    Integer proximoId = (Integer) request.getAttribute("proximoId");
    String mensaje = (String) request.getAttribute("mensaje");
%>

<form action="AgregarSeguro" method="post">
    <table>
        <tr>
            <td>Id Seguro:</td>
            <td><%= (proximoId != null ? proximoId : "") %></td>
        </tr>
        <tr>
            <td>Descripción:</td>
            <td><input type="text" name="txtDescripcion" size="35" /></td>
        </tr>
        <tr>
            <td>Tipo de Seguro:</td>
            <td>
                <select name="idTipo">
                    <%
                        ArrayList<TipoSeguro> lista =
                            (ArrayList<TipoSeguro>) request.getAttribute("tiposSeguro");

                        if (lista != null) {
                            for (TipoSeguro tipo : lista) {
                    %>
                                <option value="<%=tipo.getIdTipo()%>">
                                    <%=tipo.getDescripcion()%>
                                </option>
                    <%
                            }
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Costo contratación:</td>
            <td><input type="text" name="txtCostoContratacion" /></td>
        </tr>
        <tr>
            <td>Costo Máximo Asegurado:</td>
            <td><input type="text" name="txtCostoAsegurado" /></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="btnAceptar" value="Aceptar" />
            </td>
        </tr>
    </table>
</form>

<% if (mensaje != null) { %>
    <p><%= mensaje %></p>
<% } %>

</body>
</html>
