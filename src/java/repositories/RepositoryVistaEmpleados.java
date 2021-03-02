package repositories;

/*
create or replace view vistaempleados
as
       select emp.apellido, emp.salario, emp.salario * 12 as anual
       , emp.oficio,
       to_char(fecha_alt, 'dd " de " month " de " yyyy') as fechaalta
       , dept.dnombre as departamento, dept.loc as localidad
       from emp
       inner join dept
       on emp.dept_no = dept.dept_no;
 */
import java.util.ArrayList;
import java.util.List;
import models.HibernateUtil;
import models.Vistaempleados;
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
        //HACEMOS LA CONSULTA SOBRE EL OBJETO MAPEADO
        String hql = "from Vistaempleados as vista";
        Query query = this.session.createQuery(hql);
        //RECUPERAMOS LOS DATOS DE LA CONSULTA
        //QUE NO SON LOS DATOS QUE NECESITAMOS
        List<Vistaempleados> lista = query.list();
        //LOS DATOS QUE NECESITAMOS ESTAN EN id
        //POR LO QUE CREAMOS UNA COLECCION MANUAL DE id
        ArrayList<VistaempleadosId> empleados = new ArrayList<>();
        //RECORREMOS LA lista Y RECUPERAMOS LOS id
        for (Vistaempleados v : lista) {
            //COGEMOS CADA UNO DE LOS DATOS DE EMPLEADO ID
            VistaempleadosId emp = v.getId();
            //AÑADIMOS CADA EMPLEADO A LA LISTA CORRECTA
            empleados.add(emp);
        }
        return empleados;
    }

    public List<VistaempleadosId> getEmpleadosLocalidad(String localidad) {
        this.iniciarTransaccion();
        String hql = "from Vistaempleados as vista where lower(vista.id.localidad)='"
                + localidad.toLowerCase() + "'";
        Query query = this.session.createQuery(hql);
        List<Vistaempleados> lista = query.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            ArrayList<VistaempleadosId> empleados = new ArrayList<>();
            for (Vistaempleados v : lista) {
                empleados.add(v.getId());
            }
            return empleados;
        }
    }
}
