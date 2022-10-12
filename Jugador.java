package Obligatorio1;

public class Jugador extends Persona {
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Jugador(int pCedula, String pNombre, String pApellido, int pEdad, String puesto, int numero) {
        super(pCedula, pNombre, pApellido);
        this.puesto = puesto;
        this.numero = numero;
        this.edad = pEdad;
    }
    public Jugador() {
        super();
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Cédula='" + super.getCedula() + '\'' +
                ", Nombre=" + super.getNombre() +
                ", Apellido=" +super.getApellido() +
                ", Edad=" +edad +
                ", Puesto=" +puesto+
                ", Número=" +numero+
                '}';
    }

    private String puesto;
    private int numero;



    private int edad;

}
