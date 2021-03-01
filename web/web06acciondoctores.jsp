<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller06AccionDoctores"
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
            String accion = request.getParameter("accion");
            if (accion.equalsIgnoreCase("eliminar")){
                controller.eliminarDoctor(iddoctor);
            }else{
                String apellido = request.getParameter("cajaapellido");
                String espe = request.getParameter("cajaespecialidad");
                String datohosp = request.getParameter("cajahospital");
                String datosal = request.getParameter("cajasalario");
                int hospitalcod = Integer.parseInt(datohosp);
                int salario = Integer.parseInt(datosal);
                if (accion.equalsIgnoreCase("insertar")){
                    controller.insertarDoctor(iddoctor, apellido, espe, hospitalcod, salario);
                }else if (accion.equalsIgnoreCase("modificar")){
                    controller.modificarDoctor(iddoctor, apellido, espe, hospitalcod, salario);
                }
            }
        }
        %>
        <h1>Accion Doctores Hibernate</h1>
        <form method="post">
            <label>Id doctor</label>
            <input type="text" name="cajaiddoctor" required/><br/>
            <label>Apellido</label>
            <input type="text" name="cajaapellido"/><br/>
            <label>Especialidad</label>
            <input type="text" name="cajaespecialidad"/><br/>
            <label>Hospital: </label>
            <input type="text" name="cajahospital"/><br/>
            <label>Salario </label>
            <input type="text" name="cajasalario"/><br/>
            <button type="submit" name="accion" value="insertar">Insertar</button>
            <button type="submit" name="accion" value="modificar">Modificar</button>
            <button type="submit" name="accion" value="eliminar">Eliminar</button>
        </form>
        <hr/>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Hospital</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDoctores()%>
            </tbody>
        </table>
    </body>
</html>
