package repositories;

import java.util.List;
import models.Dept;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryDepartamentos {

    Session session;
    //LA TRANSACCION DEBE SER UNICA AL IGUAL QUE LA SESSION
    Transaction transaction;

    public RepositoryDepartamentos() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        //CADA VEZ QUE EJECUTAMOS UNA CONSULTA DE ACCION
        //LA session ES CERRADA.
        //DEBEMOS PREGUNTAR SI ESTA CERRADA PARA PODER RECUPERAR OTRA
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<Dept> getDepartamentos() {
        this.iniciarTransaccion();
        String hql = "from Dept as dept";
        Query query = this.session.createQuery(hql);
        return query.list();
    }

    //INSERTAR DEPARTAMENTO
    public void insertarDepartamento(int num, String nom, String loc) {
        //PARA REALIZAR CONSULTAS DE ACCION ES NECESARIO
        //TENER UNA TRANSACCION ACTIVA
        this.iniciarTransaccion();
        //EN HIBERNATE TODO SON CLASES, PUES SI QUEREMOS UN
        //NUEVO DEPARTAMENTO, TENDREMOS QUE CREAR UNA NUEVA CLASE
        //DEL POJO Dept
        Dept dept = new Dept(num, nom, loc);
        //PARA LA CONSULTA DE ACCION INSERT, SE UTILIZA
        //EL METODO save DE session
        this.session.save(dept);
        //AL FINALIZAR LA CONSULTA DE ACCION, DEBEMOS TERMINAR
        //LA TRANSACCION (commit, rollback)
        transaction.commit();
    }

    //ELIMINAR DEPARTAMENTO
    public void eliminarDepartamento(int num) {
        //AQUI TENDRIAMOS QUE BUSCAR LOS ELEMENTOS A ELIMINAR
        //YA SEA CON UN METODO O UNA CONSULTA from Pojo as p where p.campo=valor
        //EN ESTE EJEMPLO, QUEREMOS ELIMINAR POR LA PK
        //NO ES NECESARIO BUSCAR EL POJO MEDIANTE WHERE
        //PODEMOS RECUPERAR EL POJO CON EL METODO load DE session
        //ESTE METODO SOLO SIRVE PARA PRIMARY KEY
        //session.load(Pojo.Class, ID)
        this.iniciarTransaccion();
        Dept dept = (Dept) this.session.load(Dept.class, num);
        this.session.delete(dept);
        this.transaction.commit();
    }

    public void modificarDepartamento(int num, String nom, String loc) {
        this.iniciarTransaccion();
        //BUSCAMOS EL DEPARTAMENTO POR SU PRIMARY KEY
        Dept dept = (Dept) this.session.load(Dept.class, num);
        dept.setDnombre(nom);
        dept.setLoc(loc);
        this.session.update(dept);
        this.transaction.commit();
    }
}
