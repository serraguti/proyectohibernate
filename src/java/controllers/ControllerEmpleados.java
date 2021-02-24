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
}
