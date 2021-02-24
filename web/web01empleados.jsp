<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerempleados" class="controllers.ControllerEmpleados"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hibernate empleados</h1>
        <%=controllerempleados.getTablaEmpleados()%>
    </body>
</html>
