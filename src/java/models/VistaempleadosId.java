package models;

import java.math.BigDecimal;

public class VistaempleadosId implements java.io.Serializable {

    private String apellido;
    private Integer salario;
    private BigDecimal anual;
    private String oficio;
    private String fechaalta;
    private String departamento;
    private String localidad;

    public VistaempleadosId() {
    }

    public VistaempleadosId(String apellido, Integer salario, BigDecimal anual, String oficio, String fechaalta, String departamento, String localidad) {
        this.apellido = apellido;
        this.salario = salario;
        this.anual = anual;
        this.oficio = oficio;
        this.fechaalta = fechaalta;
        this.departamento = departamento;
        this.localidad = localidad;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSalario() {
        return this.salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public BigDecimal getAnual() {
        return this.anual;
    }

    public void setAnual(BigDecimal anual) {
        this.anual = anual;
    }

    public String getOficio() {
        return this.oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getFechaalta() {
        return this.fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof VistaempleadosId)) {
            return false;
        }
        VistaempleadosId castOther = (VistaempleadosId) other;

        return ((this.getApellido() == castOther.getApellido()) || (this.getApellido() != null && castOther.getApellido() != null && this.getApellido().equals(castOther.getApellido())))
                && ((this.getSalario() == castOther.getSalario()) || (this.getSalario() != null && castOther.getSalario() != null && this.getSalario().equals(castOther.getSalario())))
                && ((this.getAnual() == castOther.getAnual()) || (this.getAnual() != null && castOther.getAnual() != null && this.getAnual().equals(castOther.getAnual())))
                && ((this.getOficio() == castOther.getOficio()) || (this.getOficio() != null && castOther.getOficio() != null && this.getOficio().equals(castOther.getOficio())))
                && ((this.getFechaalta() == castOther.getFechaalta()) || (this.getFechaalta() != null && castOther.getFechaalta() != null && this.getFechaalta().equals(castOther.getFechaalta())))
                && ((this.getDepartamento() == castOther.getDepartamento()) || (this.getDepartamento() != null && castOther.getDepartamento() != null && this.getDepartamento().equals(castOther.getDepartamento())))
                && ((this.getLocalidad() == castOther.getLocalidad()) || (this.getLocalidad() != null && castOther.getLocalidad() != null && this.getLocalidad().equals(castOther.getLocalidad())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getApellido() == null ? 0 : this.getApellido().hashCode());
        result = 37 * result + (getSalario() == null ? 0 : this.getSalario().hashCode());
        result = 37 * result + (getAnual() == null ? 0 : this.getAnual().hashCode());
        result = 37 * result + (getOficio() == null ? 0 : this.getOficio().hashCode());
        result = 37 * result + (getFechaalta() == null ? 0 : this.getFechaalta().hashCode());
        result = 37 * result + (getDepartamento() == null ? 0 : this.getDepartamento().hashCode());
        result = 37 * result + (getLocalidad() == null ? 0 : this.getLocalidad().hashCode());
        return result;
    }

}
