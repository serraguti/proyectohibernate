package controllers;

import java.util.List;
import models.Empleado;
import repositories.RepositoryConsultaEmpleados;

public class Controller12ConsultaEmpleados {

    RepositoryConsultaEmpleados repo;

    public Controller12ConsultaEmpleados() {
        this.repo = new RepositoryConsultaEmpleados();
    }

    public String getOptionsOficios() {
        List<String> oficios = this.repo.getOficios();
        String html = "";
        for (String ofi : oficios) {
            html += "<option value='" + ofi + "'>" + ofi + "</option>";
        }
        return html;
    }

    public String getTablaEmpleadosOficio(String oficio) {
        List<Empleado> empleados = this.repo.getEmpleadosOficio(oficio);
        String html = "";
        for (Empleado emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "<td>" + emp.getSalarioAnual() + "</td>";
            html += "<td>" + emp.getSalarioTotal() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
