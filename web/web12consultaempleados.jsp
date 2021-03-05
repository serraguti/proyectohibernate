<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller12ConsultaEmpleados"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta empleados personalizada</h1>
        <form method="post">
            <label>Seleccione un oficio </label>
            <select name="oficio">
                <%=controller.getOptionsOficios()%>
            </select>
            <button type="submit">Buscar empleados</button>
        </form>
        <hr/>
        <%
        String oficio = request.getParameter("oficio");
        if (oficio != null){
            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Oficio</th>
                        <th>Salario</th>
                        <th>Salario anual</th>
                        <th>Salario total</th>
                    </tr>
                </thead>
                <tbody>
                    <%=controller.getTablaEmpleadosOficio(oficio)%>
                </tbody>
            </table>
            <%
        }
        %>
    </body>
</html>
