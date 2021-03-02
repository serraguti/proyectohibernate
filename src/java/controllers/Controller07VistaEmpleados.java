package controllers;

import java.util.List;
import models.VistaempleadosId;
import repositories.RepositoryVistaEmpleados;

public class Controller07VistaEmpleados {

    RepositoryVistaEmpleados repo;

    public Controller07VistaEmpleados() {
        this.repo = new RepositoryVistaEmpleados();
    }

    public String getTablaVistaEmpleados() {
        List<VistaempleadosId> empleados = this.repo.getVistaEmpleados();
        String html = "";
        for (VistaempleadosId emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getDepartamento() + "</td>";
            html += "<td>" + emp.getFechaalta() + "</td>";
            html += "<td>" + emp.getLocalidad() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "<td>" + emp.getAnual() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
