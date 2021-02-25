package controllers;

import java.util.List;
import models.Emp;
import repositories.RepositoryEmpleados;

public class ControllerEmpleados {
    RepositoryEmpleados repo;
    
    public ControllerEmpleados(){
        this.repo = new RepositoryEmpleados();
    }
    
    public String getTablaEmpleados(){
        List<Emp> empleados = this.repo.getEmpleados();
        String html = "<table border='1'>";
        html += "<thead>";
        html += "<tr><th>Apellido</th><th>Oficio</th><th>Salario</th></tr>";
        html += "</thead>";
        html += "<tbody>";
        for (Emp emp: empleados){
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "</tr>";
        }
        html += "</tbody>";
        html += "</table>";
        return html;
    }
    
    public String getEmpleadosOficio(String oficio){
        List<Emp> empleados = this.repo.buscarEmpleadosOficio(oficio);
        if (empleados == null){
            //NO HAY DATOS
            return "<h1 style='color:red'>No existen datos del oficio: " + oficio + "</h1>";
        }
        String html = "<ul>";
        for (Emp emp : empleados){
            html += "<li>" + emp.getApellido() + "</li>";
        }
        html += "</ul>";
        return html;
    }
}
