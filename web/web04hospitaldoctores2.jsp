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
        <h1>Doctores</h1>
        <%
        String dato = request.getParameter("hospitalcod");
        if (dato != null){
            int hospitalcod = Integer.parseInt(dato);
            %>
            <h1></h1>
            <%=controller.getDoctoresHospital(hospitalcod)%>
            <%
        }
        %>
    </body>
</html>
