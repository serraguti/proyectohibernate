<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller08VistaPlantilla"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vista Plantilla Hibernate</h1>
        <form method="post">
            <label>Nombre de hospital</label>
            <select name="hospital">
                <%=controller.getSelectHospitales()%>
            </select>
            <button type="submit">Buscar empleados</button>
        </form>
        <hr/>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Funcion</th>
                    <th>Salario</th>
                    <th>Hospital</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <%
                String nombre = request.getParameter("hospital");
                if (nombre == null){
                    %>
                    <%=controller.getTablaPlantilla()%>    
                    <%
                }else{
                    %>
                    <%=controller.getTablaPlantillaHospital(nombre)%>
                    <%
                }
                %>
                
            </tbody>
        </table>
    </body>
</html>
