package models;
public class Doctor  implements java.io.Serializable {


     private int doctorNo;
     private Integer hospitalCod;
     private String apellido;
     private String especialidad;
     private Integer salario;

    public Doctor() {
    }

	
    public Doctor(int doctorNo) {
        this.doctorNo = doctorNo;
    }
    public Doctor(int doctorNo, Integer hospitalCod, String apellido, String especialidad, Integer salario) {
       this.doctorNo = doctorNo;
       this.hospitalCod = hospitalCod;
       this.apellido = apellido;
       this.especialidad = especialidad;
       this.salario = salario;
    }
   
    public int getDoctorNo() {
        return this.doctorNo;
    }
    
    public void setDoctorNo(int doctorNo) {
        this.doctorNo = doctorNo;
    }
    public Integer getHospitalCod() {
        return this.hospitalCod;
    }
    
    public void setHospitalCod(Integer hospitalCod) {
        this.hospitalCod = hospitalCod;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public Integer getSalario() {
        return this.salario;
    }
    
    public void setSalario(Integer salario) {
        this.salario = salario;
    }




}

