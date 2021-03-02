package models;
// Generated 02-mar-2021 20:28:41 by Hibernate Tools 4.3.1



/**
 * VistaplantillaId generated by hbm2java
 */
public class VistaplantillaId  implements java.io.Serializable {


     private String apellido;
     private String funcion;
     private Integer salario;
     private String hospital;
     private String telefono;

    public VistaplantillaId() {
    }

    public VistaplantillaId(String apellido, String funcion, Integer salario, String hospital, String telefono) {
       this.apellido = apellido;
       this.funcion = funcion;
       this.salario = salario;
       this.hospital = hospital;
       this.telefono = telefono;
    }
   
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getFuncion() {
        return this.funcion;
    }
    
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public Integer getSalario() {
        return this.salario;
    }
    
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public String getHospital() {
        return this.hospital;
    }
    
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VistaplantillaId) ) return false;
		 VistaplantillaId castOther = ( VistaplantillaId ) other; 
         
		 return ( (this.getApellido()==castOther.getApellido()) || ( this.getApellido()!=null && castOther.getApellido()!=null && this.getApellido().equals(castOther.getApellido()) ) )
 && ( (this.getFuncion()==castOther.getFuncion()) || ( this.getFuncion()!=null && castOther.getFuncion()!=null && this.getFuncion().equals(castOther.getFuncion()) ) )
 && ( (this.getSalario()==castOther.getSalario()) || ( this.getSalario()!=null && castOther.getSalario()!=null && this.getSalario().equals(castOther.getSalario()) ) )
 && ( (this.getHospital()==castOther.getHospital()) || ( this.getHospital()!=null && castOther.getHospital()!=null && this.getHospital().equals(castOther.getHospital()) ) )
 && ( (this.getTelefono()==castOther.getTelefono()) || ( this.getTelefono()!=null && castOther.getTelefono()!=null && this.getTelefono().equals(castOther.getTelefono()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApellido() == null ? 0 : this.getApellido().hashCode() );
         result = 37 * result + ( getFuncion() == null ? 0 : this.getFuncion().hashCode() );
         result = 37 * result + ( getSalario() == null ? 0 : this.getSalario().hashCode() );
         result = 37 * result + ( getHospital() == null ? 0 : this.getHospital().hashCode() );
         result = 37 * result + ( getTelefono() == null ? 0 : this.getTelefono().hashCode() );
         return result;
   }   


}


