package repositories;

import java.util.List;
import models.Emp;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class RepositoryEmpleados {
    Session session;
    
    public RepositoryEmpleados(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Emp> getEmpleados(){
        this.session.beginTransaction();
        String hql = "from Emp as emp";
        Query query = this.session.createQuery(hql);
        return query.list();
    }
}
