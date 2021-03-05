package models;

public class Empleado {

    private String apellido;
    private String oficio;
    private int salario;
    private int salarioAnual;
    private int salarioTotal;

    public Empleado() {
    }

    public Empleado(String apellido, String oficio, int salario, int anual, int total) {
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.salarioAnual = anual;
        this.salarioTotal = total;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(int salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public int getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(int salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
}
