<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller05AccionDepartamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String dato = request.getParameter("cajanumero");
        if (dato != null){
            int num = Integer.parseInt(dato);
            String nom = request.getParameter("cajanombre");
            String loc = request.getParameter("cajalocalidad");
            String accion = request.getParameter("accion");
            if (accion.equalsIgnoreCase("insertar")){
                controller.insertarDepartamento(num, nom, loc);
            }else if (accion.equalsIgnoreCase("eliminar")){
                controller.eliminarDepartamento(num);
            }else if (accion.equalsIgnoreCase("modificar")){
                controller.modificarDepartamento(num, nom, loc);
            }
        }
        %>
        <h1>Consultas acción Hibernate</h1>
        <form method="post">
            <label>Número: </label>
            <input type="text" name="cajanumero" placeholder="Id departamento" required/>
            <br/>
            <label>Nombre </label>
            <input type="text" name="cajanombre" placeholder="Nombre departamento"/>
            <br/>
            <label>Localidad </label>
            <input type="text" name="cajalocalidad" placeholder="Localidad"/>
            <br/>
            <button type="submit" name="accion" value="insertar">Insertar</button>
            <button type="submit" name="accion" value="eliminar">Eliminar</button>
            <button type="submit" name="accion" value="modificar">Modificar</button>
        </form>
        <hr/>
        <table border="1">
            <thead>
                <tr>
                    <th>Número</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
