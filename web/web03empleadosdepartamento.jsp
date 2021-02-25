<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller03EmpleadosDepartamento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados Departamento</h1>
        <form method="post" action="web03empleadosdept.jsp">
            <label>Seleccione departamento</label>
            <select name="selectdepartamento">
                <%=controller.getOptionsDepartamentos()%>
            </select>
            <button type="submit">Mostrar empleados</button>
        </form>
    </body>
</html>
