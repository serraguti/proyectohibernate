package controllers;

import java.util.List;
import models.Dept;
import repositories.RepositoryDepartamentos;

public class Controller05AccionDepartamentos {

    RepositoryDepartamentos repo;

    public Controller05AccionDepartamentos() {
        this.repo = new RepositoryDepartamentos();
    }

    public String getTablaDepartamentos() {
        List<Dept> departamentos = this.repo.getDepartamentos();
        String html = "";
        for (Dept d : departamentos) {
            html += "<tr>";
            html += "<td>" + d.getDeptNo() + "</td>";
            html += "<td>" + d.getDnombre() + "</td>";
            html += "<td>" + d.getLoc() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void insertarDepartamento(int num, String nom, String loc) {
        this.repo.insertarDepartamento(num, nom, loc);
    }

    public void eliminarDepartamento(int num) {
        this.repo.eliminarDepartamento(num);
    }

    public void modificarDepartamento(int num, String nom, String loc) {
        this.repo.modificarDepartamento(num, nom, loc);
    }
}
