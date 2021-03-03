<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller09Procedimiento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String dato = request.getParameter("cajaiddoctor");
        if (dato != null){
            int iddoctor = Integer.parseInt(dato);
            String especialidad = request.getParameter("especialidad");
            controller.modificarEspecialidadDoctor(iddoctor, especialidad);
        }
        %>
        <h1>Procedimientos almacenados HQL</h1>
        <form method="post">
            <label>Id Doctor: </label>
            <input type="text" name="cajaiddoctor" required/><br/>
            <label>Nueva especialidad:</label>
            <input type="text" name="especialidad" required/><br/>
            <button type="submit">Modificar datos</button>
        </form>
        <hr/>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDoctores()%>
            </tbody>
        </table>
    </body>
</html>
