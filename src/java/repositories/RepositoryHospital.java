package repositories;

import java.util.List;
import models.HibernateUtil;
import models.Hospital;
import org.hibernate.Query;
import org.hibernate.Session;

public class RepositoryHospital {
    Session session;
    
    public RepositoryHospital(){
        this.session =
                HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Hospital> getHospitales(){
        this.session.beginTransaction();
        String hql = "from Hospital as h";
        Query query = this.session.createQuery(hql);
        return query.list();
    }
}
