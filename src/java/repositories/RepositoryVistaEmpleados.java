package repositories;

import java.util.List;
import models.HibernateUtil;
import models.VistaempleadosId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryVistaEmpleados {

    Session session;
    Transaction transaction;

    public RepositoryVistaEmpleados() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session
                    = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<VistaempleadosId> getVistaEmpleados() {
        this.iniciarTransaccion();
        String hql = "from VistaempleadosId as vista";
        Query query = this.session.createQuery(hql);
        return query.list();
    }
}
