<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller10EmpleadosProcedimiento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String dato = request.getParameter("cajadeptno");
        if (dato != null){
            int deptno = Integer.parseInt(dato);
            int incremento = Integer.parseInt(request.getParameter("incremento"));
            controller.incrementarSalarioEmpleados(deptno, incremento);
        }
        %>
        <h1>Empleados procedimiento</h1>
        <form method="post">
            <label>Id departamento</label>
            <input type="text" name="cajadeptno" required/><br/>
            <label>Incremento salarial: </label>
            <input type="text" name="incremento" required/><br/>
            <button type="submit">Incrementar salarios</button>
        </form>
        <hr/>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Oficio</th>
                    <th>Departamento</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaEmpleados()%>
            </tbody> 
        </table>
    </body>
</html>
