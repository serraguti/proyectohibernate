package models;

public class Hospital  implements java.io.Serializable {


     private int hospitalCod;
     private String nombre;
     private String direccion;
     private String telefono;
     private Integer numCama;

    public Hospital() {
    }

	
    public Hospital(int hospitalCod) {
        this.hospitalCod = hospitalCod;
    }
    public Hospital(int hospitalCod, String nombre, String direccion, String telefono, Integer numCama) {
       this.hospitalCod = hospitalCod;
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.numCama = numCama;
    }
   
    public int getHospitalCod() {
        return this.hospitalCod;
    }
    
    public void setHospitalCod(int hospitalCod) {
        this.hospitalCod = hospitalCod;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Integer getNumCama() {
        return this.numCama;
    }
    
    public void setNumCama(Integer numCama) {
        this.numCama = numCama;
    }




}


