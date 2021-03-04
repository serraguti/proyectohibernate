/*
create or replace procedure updatesalarioempleados
(p_deptno emp.dept_no%type
, p_incremento int)
as
begin
  update emp set salario = salario + p_incremento
  where dept_no = p_deptno;
  commit;
end;
 */
package repositories;

import java.util.List;
import models.Emp;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryEmpleadosProcedimiento {

    Session session;
    Transaction transaction;

    public RepositoryEmpleadosProcedimiento() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<Emp> getEmpleados() {
        this.iniciarTransaccion();
        String hql = "from Emp as emp";
        Query query = this.session.createQuery(hql);
        List<Emp> empleados = query.list();
        //UNA VEZ QUE HEMOS LEIDO LOS DATOS O HEMOS REALIZADO
        //LA ACCION DE RECUPERAR UN LIST, CERRAMOS SESSION
        this.session.close();
        return empleados;
    }

    public void incrementarSalarioEmpleados(int deptno, int incremento) {
        this.iniciarTransaccion();
        String sql = "CALL UPDATESALARIOEMPLEADOS(?,?)";
        Query query = this.session.createSQLQuery(sql);
        query.setParameter(0, deptno);
        query.setParameter(1, incremento);
        query.executeUpdate();
        this.transaction.commit();
    }
}
