<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" 
             class="controllers.Controller03EmpleadosDepartamento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados Dept</h1>
        <%
        String dato = request.getParameter("selectdepartamento");
        if (dato != null){
            int id = Integer.parseInt(dato);
            %>
            <%=controller.getEmpleadosDepartamento(id)%>
            <%
        }
        %>
    </body>
</html>
