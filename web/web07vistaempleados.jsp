<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller07VistaEmpleados"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vistas Hibernate</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Oficio</th>
                    <th>Departamento</th>
                    <th>Fecha Alta</th>
                    <th>Localidad</th>
                    <th>Salario</th>
                    <th>Salario Anual</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaVistaEmpleados()%>
            </tbody>
        </table>
    </body>
</html>
