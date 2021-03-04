package models;

public class ResumenDepartamento {

    private int maximoSalario;
    private int minimoSalario;
    private int personas;

    public int getMaximoSalario() {
        return maximoSalario;
    }

    public void setMaximoSalario(int maximoSalario) {
        this.maximoSalario = maximoSalario;
    }

    public int getMinimoSalario() {
        return minimoSalario;
    }

    public void setMinimoSalario(int minimoSalario) {
        this.minimoSalario = minimoSalario;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }
}
