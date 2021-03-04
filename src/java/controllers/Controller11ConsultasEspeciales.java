package controllers;

import java.util.List;
import models.Dept;
import models.Emp;
import models.ResumenDepartamento;
import repositories.RepositoryConsultasEspeciales;

public class Controller11ConsultasEspeciales {

    RepositoryConsultasEspeciales repo;

    public Controller11ConsultasEspeciales() {
        this.repo = new RepositoryConsultasEspeciales();
    }

    public String getResumenDepartamento(int id) {
        ResumenDepartamento resumen = this.repo.getResumenDepartamento(id);
        if (resumen == null) {
            return "<h1 style='color:red'>No existe el departamento " + id + "</h1>";
        }
        String html = "<h1>Personas: " + resumen.getPersonas() + "</h1>";
        html += "<h2 style='color:blue'>Máximo salario: " + resumen.getMaximoSalario() + "</h2>";
        html += "<h2 style='color:red'>Mínimo salario: " + resumen.getMinimoSalario() + "</h2>";
        return html;
    }

    public String getOptionsDepartamento() {
        List<Dept> departamentos = this.repo.getDepartamentos();
        String html = "";
        for (Dept dept : departamentos) {
            html += "<option value='" + dept.getDeptNo() + "'>"
                    + dept.getDnombre() + "</option>";
        }
        return html;
    }

    public String getTablaEmpleadosDepartamento(int id) {
        List<Emp> empleados = this.repo.getEmpleadosDepartamento(id);
        if (empleados == null) {
            return "<h1 style='color:red'>No hay empleados en el departamento "
                    + id + "</h1>";
        }
        String html = "";
        for (Emp emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "<td>" + emp.getDeptNo() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
