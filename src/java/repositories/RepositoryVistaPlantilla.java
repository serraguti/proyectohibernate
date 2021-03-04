/*
create or replace view VISTAPLANTILLA
AS
       select plantilla.apellido, plantilla.funcion
       , plantilla.salario, hospital.nombre as hospital, hospital.telefono
       from plantilla
       inner join hospital
       on plantilla.hospital_cod = hospital.hospital_cod;
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import models.HibernateUtil;
import models.Hospital;
import models.Vistaplantilla;
import models.VistaplantillaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryVistaPlantilla {

    Session session;
    Transaction transaction;

    public RepositoryVistaPlantilla() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<VistaplantillaId> getVistaPlantilla() {
        this.iniciarTransaccion();
        String hql = "from Vistaplantilla as vista";
        Query query = this.session.createQuery(hql);
        List<Vistaplantilla> lista = query.list();
        ArrayList<VistaplantillaId> plantilla = new ArrayList<>();
        for (Vistaplantilla v : lista) {
            plantilla.add(v.getId());
        }
        this.session.close();
        return plantilla;
    }

    public List<VistaplantillaId> getVistaPlantillaHospital(String nombre) {
        this.iniciarTransaccion();
        String hql = "from Vistaplantilla as vista where lower(vista.id.hospital)='"
                + nombre.toLowerCase() + "'";
        Query query = this.session.createQuery(hql);
        List<Vistaplantilla> lista = query.list();
        this.session.close();
        if (lista.isEmpty()) {
            return null;
        } else {
            ArrayList<VistaplantillaId> plantilla = new ArrayList<>();
            for (Vistaplantilla v : lista) {
                plantilla.add(v.getId());
            }
            return plantilla;
        }
    }

    public List<Hospital> getHospitales() {
        this.session.beginTransaction();
        String hql = "from Hospital as h";
        Query query = this.session.createQuery(hql);
        List<Hospital> lista = query.list();
        System.out.println("Estoy aqui ANTES HOSPITAL...");
        this.session.close();
        return lista;
    }
}
