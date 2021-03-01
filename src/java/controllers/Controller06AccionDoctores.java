package controllers;

import java.util.List;
import models.Doctor;
import repositories.RepositoryDoctor;
import repositories.RepositoryDoctores;

public class Controller06AccionDoctores {

    RepositoryDoctor repo;

    public Controller06AccionDoctores() {
        this.repo = new RepositoryDoctor();
    }

    public String getTablaDoctores() {
        List<Doctor> doctores = this.repo.getDoctores();
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>";
            html += "<button type='button' value='" + doc.getDoctorNo() + "'>Eliminar</button>";
            html += "<a href='web06acciondoctores.jsp?eliminar=" + doc.getDoctorNo() + "'>Eliminar</a>";
            html += "</td>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getHospitalCod() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void eliminarDoctor(int iddoctor) {
        this.repo.eliminarDoctor(iddoctor);
    }

    public void insertarDoctor(int iddoctor, String apellido, String espe,
            int hospitalcod, int salario) {
        this.repo.insertarDoctor(iddoctor, apellido, espe, hospitalcod, salario);
    }

    public void modificarDoctor(int iddoctor, String apellido, String espe,
            int hospitalcod, int salario) {
        this.repo.modificarDoctor(iddoctor, apellido, espe, hospitalcod, salario);
    }
}
