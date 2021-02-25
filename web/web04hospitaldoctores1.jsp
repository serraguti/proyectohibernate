<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller04HospitalDoctores"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hospitales</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Camas</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaHospitales()%>
            </tbody>
        </table>
    </body>
</html>
