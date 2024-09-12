<%-- 
    Document   : show_usuarios
    Created on : 4/09/2024, 07:00:58 PM
    Author     : ALEJANDRO DIAZ 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.List"%>
<%@page import = "Model.Usuario"%>
<%@page import = "ModelDAO.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lISTA DE LOS USUARIOS REGISTRADOS</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>APELLIDOS</th>
                    <th>NOMBRE</th>
                    <th>CORREO</th>
                    <th>MATRICULA</th>
                    <th>CELULAR</th>
                    <th>FECHA DE NACIMIENTO</th>
                </tr>
            </thead>
            <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> lista = dao.listar();
                    if (lista.isEmpty()){
                        System.out.println("No hay registros en la lista");
                    }
                    
                    Iterator <Usuario> iterador = lista.iterator();
                    Usuario user1 = null;
                    
                    while (iterador.hasNext()){
                        user1 = iterador.next();  
                       
                %>
            <tbody>
                
                <tr>
                    <td><%= user1.getApellidos() %></td>
                    <td><%= user1.getNombre() %></td>
                    <td><%= user1.getCorreo() %></td>
                    <td><%= user1.getMatricula() %></td>
                    <td><%= user1.getFecha_nac() %></td>
                    <td><%= user1.getCelular() %></td>
                </tr>
                <%}%>
                
            </tbody>
        </table>

    </body>
</html>
