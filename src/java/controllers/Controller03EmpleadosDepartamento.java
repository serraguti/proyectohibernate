package controllers;

import java.util.List;
import models.Dept;
import models.Emp;
import repositories.RepositoryDepartamentos;
import repositories.RepositoryEmpleados;

public class Controller03EmpleadosDepartamento {
    RepositoryDepartamentos repodept;
    RepositoryEmpleados repoemp;
    
    public Controller03EmpleadosDepartamento(){
        this.repodept = new RepositoryDepartamentos();
        this.repoemp = new RepositoryEmpleados();
    }
    
    public String getEmpleadosDepartamento(int id){
        List<Emp> empleados = this.repoemp.getEmpleadosDepartamento(id);
        if (empleados == null){
            return "<h1 style='color:red'>No hay empleados</h1>";
        }
        String html = "<ul>";
        for (Emp emp: empleados){
            html += "<li>" + emp.getApellido() + "</li>";
        }
        html += "</ul>";
        return html;
    }
    
    public String getOptionsDepartamentos(){
        List<Dept> departamentos = this.repodept.getDepartamentos();
        String html = "";
        for (Dept d: departamentos){
            html += "<option value='" + d.getDeptNo() + "'>"
                    + d.getDnombre() + "</option>";
        }
        return html;
    }
}
