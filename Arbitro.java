package Obligatorio1;

public class Arbitro extends Persona{
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Arbitro(int cedula, String nombre, String apellido, String puesto) {
        super(cedula, nombre, apellido);
        this.puesto = puesto;
    }
    public Arbitro(){

    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "cedula=" + super.getCedula() +
                ", nombre='" + super.getNombre() + '\'' +
                ", apellido='" + super.getApellido() + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }

    private String puesto;

    public Arbitro(int pCedula, String pNombre, String pApellido){
        super(pCedula, pNombre, pApellido);
    }
}
