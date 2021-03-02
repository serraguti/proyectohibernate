package models;

public class Vistaempleados implements java.io.Serializable {

    private VistaempleadosId id;

    public Vistaempleados() {
    }

    public Vistaempleados(VistaempleadosId id) {
        this.id = id;
    }

    public VistaempleadosId getId() {
        return this.id;
    }

    public void setId(VistaempleadosId id) {
        this.id = id;
    }

}
