package Obligatorio1;

public class Entrenador extends Persona{
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private int edad;

    public Entrenador(int pCedula, String pNombre, String pApellido, int pEdad){
        super(pCedula, pNombre, pApellido);
        edad = pEdad;
    }
    public Entrenador(){
        super();
    }
}