package repositories;

import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryDoctor {

    Session session;
    Transaction transaction;

    public RepositoryDoctor() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<Doctor> getDoctores() {
        this.iniciarTransaccion();
        String hql = "from Doctor as doc";
        Query query = this.session.createQuery(hql);
        return query.list();
    }

    public void insertarDoctor(int iddoctor, String apellido, String espe,
            int hospitalcod, int salario) {
        this.iniciarTransaccion();
        Doctor doc = new Doctor(iddoctor, hospitalcod, apellido, espe, salario);
        this.session.save(doc);
        this.transaction.commit();
    }

    public void modificarDoctor(int iddoctor, String apellido, String espe,
            int hospitalcod, int salario) {
        this.iniciarTransaccion();
        Doctor doc = (Doctor) this.session.load(Doctor.class, iddoctor);
        doc.setApellido(apellido);
        doc.setEspecialidad(espe);
        doc.setHospitalCod(hospitalcod);
        doc.setSalario(salario);
        this.session.update(doc);
        this.transaction.commit();
    }

    public void eliminarDoctor(int iddoctor) {
        this.iniciarTransaccion();
        Doctor doc = (Doctor) this.session.load(Doctor.class, iddoctor);
        this.session.delete(doc);
        this.transaction.commit();
    }
}
