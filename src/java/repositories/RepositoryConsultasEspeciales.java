package repositories;

import java.util.List;
import models.Dept;
import models.Emp;
import models.HibernateUtil;
import models.ResumenDepartamento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryConsultasEspeciales {

    Session session;
    Transaction transaction;

    public RepositoryConsultasEspeciales() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public ResumenDepartamento getResumenDepartamento(int id) {
        this.iniciarTransaccion();
        String hql = "select count(emp.empNo), max(emp.salario), min(emp.salario) "
                + " from Emp as emp where emp.deptNo=?";
        Query query = this.session.createQuery(hql);
        query.setParameter(0, id);
        List lista = query.list();
        this.session.close();
        ResumenDepartamento resumen = null;
        for (Object obj : lista) {
            //DENTRO DE LA LISTA, EXISTE UN ARRAY DE Object[]
            Object[] array = (Object[]) obj;
            Long personas = (Long) array[0];
            if (array[1] == null) {
                //NO HAY DATOS
                return null;
            }
            int maximo = (int) array[1];
            int minimo = (int) array[2];
            resumen = new ResumenDepartamento();
            resumen.setPersonas(personas.intValue());
            resumen.setMaximoSalario(maximo);
            resumen.setMinimoSalario(minimo);
        }
        return resumen;
    }

    public List<Dept> getDepartamentos() {
        this.iniciarTransaccion();
        String hql = "from Dept as d";
        Query query = this.session.createQuery(hql);
        List<Dept> departamentos = query.list();
        this.session.close();
        return departamentos;
    }

    public List<Emp> getEmpleadosDepartamento(int id) {
        this.iniciarTransaccion();
        String hql = "from Emp as emp where emp.deptNo=?";
        Query query = this.session.createQuery(hql);
        query.setParameter(0, id);
        List<Emp> empleados = query.list();
        this.session.close();
        if (empleados.isEmpty()) {
            return null;
        } else {
            return empleados;
        }
    }
}
