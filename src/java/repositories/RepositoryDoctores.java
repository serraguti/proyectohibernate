package repositories;

import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class RepositoryDoctores {
    Session session;
    
    public RepositoryDoctores(){
        this.session = 
                HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Doctor> getDoctoresHospital(int id){
        this.session.beginTransaction();
        String hql = "from Doctor as doc where doc.hospitalCod=" + id;
        Query query = this.session.createQuery(hql);
        if (query.list().isEmpty()){
            return null;
        }else{
            return query.list();
        }
    }
}
