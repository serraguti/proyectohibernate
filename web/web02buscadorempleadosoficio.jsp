<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerempleados"
             class="controllers.ControllerEmpleados"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscador empleados oficio</h1>
        <form method="post">
            <label>Introduzca un oficio: </label>
            <input type="text" name="cajaoficio" placeholder="Oficio"/>
            <button type="submit">Buscar empleados</button>
        </form>
        <%
        String oficio = request.getParameter("cajaoficio");
        if (oficio != null){
            %>
            <hr/>
            <%=controllerempleados.getEmpleadosOficio(oficio)%>
            <%
        }
        %>
    </body>
</html>
