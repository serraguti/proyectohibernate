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
    
    public List<Emp> buscarEmpleadosOficio(String oficio){
        this.session.beginTransaction();
        String hql = "from Emp as emp where upper(emp.oficio)='" 
                + oficio.toUpperCase() + "'";
        Query query = this.session.createQuery(hql);
        if (query.list().isEmpty()){
            return null;
        }else{
            return query.list();
        }
    }
    
    public List<Emp> getEmpleadosDepartamento(int iddepartamento){
        this.session.beginTransaction();
        String hql = "from Emp as emp where emp.deptNo=" 
                + iddepartamento;
        Query query = this.session.createQuery(hql);
        if (query.list().isEmpty())
        {
            return null;
        }else{
            return query.list();
        }
    }
}
