package controllers;

import java.util.List;
import models.VistaplantillaId;
import repositories.RepositoryVistaPlantilla;

public class Controller08VistaPlantilla {

    RepositoryVistaPlantilla repo;

    public Controller08VistaPlantilla() {
        this.repo = new RepositoryVistaPlantilla();
    }

    public String getTablaPlantilla() {
        List<VistaplantillaId> plantilla = this.repo.getVistaPlantilla();
        String html = "";
        for (VistaplantillaId plan : plantilla) {
            html += "<tr>";
            html += "<td>" + plan.getApellido() + "</td>";
            html += "<td>" + plan.getFuncion() + "</td>";
            html += "<td>" + plan.getSalario() + "</td>";
            html += "<td>" + plan.getHospital() + "</td>";
            html += "<td>" + plan.getTelefono() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getTablaPlantillaHospital(String nombre) {
        List<VistaplantillaId> plantilla = this.repo.getVistaPlantillaHospital(nombre);
        if (plantilla == null) {
            return "<h1 style='color:red'>No existen empleados en " + nombre + "</h1>";
        }
        String html = "";
        for (VistaplantillaId plan : plantilla) {
            html += "<tr>";
            html += "<td>" + plan.getApellido() + "</td>";
            html += "<td>" + plan.getFuncion() + "</td>";
            html += "<td>" + plan.getSalario() + "</td>";
            html += "<td>" + plan.getHospital() + "</td>";
            html += "<td>" + plan.getTelefono() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
