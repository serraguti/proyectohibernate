package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Empleado;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryConsultaEmpleados {

    Session session;
    Transaction transaction;

    public RepositoryConsultaEmpleados() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<Empleado> getEmpleadosOficio(String oficio) {
        this.iniciarTransaccion();
        //QUE LENGUAJE ES ESTE DE LA CONSULTA?? HQL
        String hql = "select emp.apellido, emp.oficio, emp.salario, "
                + " emp.salario * 12, coalesce(emp.salario + emp.comision, 0) "
                + " from Emp as emp "
                + " where upper(emp.oficio)=upper(?)";
        Query query = this.session.createQuery(hql);
        query.setParameter(0, oficio);
        List lista = query.list();
        this.session.close();
        ArrayList<Empleado> empleados = new ArrayList<>();
        for (Object obj : lista) {
            Object[] array = (Object[]) obj;
            String ape = array[0].toString();
            String ofi = array[1].toString();
            int sal = (int) array[2];
            int anual = (int) array[3];
            int total = (int) array[4];
            Empleado emp = new Empleado(ape, ofi, sal, anual, total);
            empleados.add(emp);
        }
        return empleados;
    }

    public List<String> getOficios() {
        this.iniciarTransaccion();
        String hql = "select distinct emp.oficio from Emp as emp";
        Query query = this.session.createQuery(hql);
        List<String> oficios = query.list();
        this.session.close();
        return oficios;
    }
}
