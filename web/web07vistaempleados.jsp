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
        <form method="post">
            <label>Introduzca localidad: </label>
            <input type="text" name="localidad" required/>
            <button type="submit">Buscar empleados</button>
        </form>
        <hr/>
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
                <%
                String localidad = request.getParameter("localidad");
                if (localidad == null){
                    //DIBUJAMOS TODOS LOS DATOS
                    %>
                    <%=controller.getTablaVistaEmpleados()%>    
                    <%
                }else{
                    //DIBUJAMOS LOS DATOS DE LA BUSQUEDA
                    %>
                    <%=controller.getTablaEmpleadosLocalidad(localidad)%>
                    <%
                }
                %>
            </tbody>
        </table>
    </body>
</html>
