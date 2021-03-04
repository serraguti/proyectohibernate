package controllers;

import java.util.List;
import models.Emp;
import repositories.RepositoryEmpleadosProcedimiento;

public class Controller10EmpleadosProcedimiento {

    RepositoryEmpleadosProcedimiento repo;

    public Controller10EmpleadosProcedimiento() {
        this.repo = new RepositoryEmpleadosProcedimiento();
    }

    public String getTablaEmpleados() {
        List<Emp> empleados = this.repo.getEmpleados();
        String html = "";
        for (Emp emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getDeptNo() + "</td>";
            html += "<td style='color:blue'>" + emp.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void incrementarSalarioEmpleados(int deptno, int incremento) {
        this.repo.incrementarSalarioEmpleados(deptno, incremento);
    }
}
