package repositories;

/*
create or replace procedure updateespecialidaddoctor
(p_iddoctor doctor.doctor_no%type
, p_espe doctor.especialidad%type)
as
begin
  update doctor set especialidad=p_espe
  where doctor_no=p_iddoctor;
  commit;
end;
 */
import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepositoryProcedimiento {

    Session session;
    Transaction transaction;

    public RepositoryProcedimiento() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void iniciarTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }

    public List<Doctor> getDoctores() {
        this.iniciarTransaccion();
        String hql = "from Doctor as doc";
        Query query = this.session.createQuery(hql);
        return query.list();
    }

    public void modificarEspecialidadDoctor(int iddoctor, String especialidad) {
        this.iniciarTransaccion();
        //PARA LOS PROCEDIMIENTOS, SE UTILIZA session CON UN METODO
        //createSQLQuery(PETICION)
        //LA PETICION ES EXACTAMENTE IGUAL A COMO LO HEMOS HECHO EN
        //JDBC, PERO SIN LLAVES, CON LA DIFERENCIA DE QUE EN HIBERNATE, LOS PARAMETROS
        //COMIENZAN EN 0
        String sql = "CALL UPDATEESPECIALIDADDOCTOR(?,?)";
        Query query = this.session.createSQLQuery(sql);
        //DEBEMOS PASAR LOS PARAMETROS
        query.setParameter(0, iddoctor);
        query.setParameter(1, especialidad);
        //AL SER UNA CONSULTA DE ACCION EN UN PROCEDURE, SE EJECUTA
        //MEDIANTE EL METODO executeUpdate()
        query.executeUpdate();
        this.transaction.commit();
    }
}
