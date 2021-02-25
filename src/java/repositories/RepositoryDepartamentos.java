package repositories;

import java.util.List;
import models.Dept;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class RepositoryDepartamentos {
    Session session;
    
    public RepositoryDepartamentos(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Dept> getDepartamentos(){
        this.session.beginTransaction();
        String hql = "from Dept as dept";
        Query query = this.session.createQuery(hql);
        return query.list();
    }
}
