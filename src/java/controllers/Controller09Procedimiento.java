package controllers;

import java.util.List;
import models.Doctor;
import repositories.RepositoryProcedimiento;

public class Controller09Procedimiento {

    RepositoryProcedimiento repo;

    public Controller09Procedimiento() {
        this.repo = new RepositoryProcedimiento();
    }

    public String getTablaDoctores() {
        List<Doctor> doctores = this.repo.getDoctores();
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getDoctorNo() + "</td>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void modificarEspecialidadDoctor(int iddoctor, String especialidad) {
        this.repo.modificarEspecialidadDoctor(iddoctor, especialidad);
    }
}
