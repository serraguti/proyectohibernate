package controllers;

import java.util.List;
import models.Doctor;
import models.Hospital;
import repositories.RepositoryDoctores;
import repositories.RepositoryHospital;

public class Controller04HospitalDoctores {
    RepositoryHospital repohospital;
    RepositoryDoctores repodoc;
    
    public Controller04HospitalDoctores(){
        this.repohospital = new RepositoryHospital();
        this.repodoc = new RepositoryDoctores();
    }
    
    public String getDoctoresHospital(int idhospital){
        List<Doctor> doctores = this.repodoc.getDoctoresHospital(idhospital);
        String html = "<ul>";
        for (Doctor doc: doctores){
            html += "<li>" + doc.getApellido() + "</li>";
        }
        
        html += "</ul>";
        return html;
    }
    
    public String getTablaHospitales(){
        List<Hospital> hospitales = this.repohospital.getHospitales();
        String html = "";
        for (Hospital h:hospitales){
            html += "<tr>";
            html += "<td>" + h.getNombre() + "</td>";
            html += "<td>" + h.getDireccion() + "</td>";
            html += "<td>" + h.getTelefono() + "</td>";
            html += "<td>" + h.getNumCama() + "</td>";
            html += "<td>";
            html += "<a href='web04hospitaldoctores2.jsp?hospitalcod="
                    + h.getHospitalCod() + "'>Doctores</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
}
