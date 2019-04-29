package escuadron;

/**
 * Created by Sebas on 13/03/2019.
 *
 * Clase abstracta de Unidad.
 */
public abstract class Unidad {

    protected String nombre;
    protected String suceso;
    private Unidad orden;
    private int avanzadas=3;

    /**
     * Constructor de Unidad.
     * @param nombre
     */
    public Unidad(String nombre){
        this.nombre=nombre;
    }

    /**
     * Getters y Setters de Nombre, Orden y Avanzadas.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public Unidad getOrden() {
        return orden;
    }
    
    public void setOrden(Unidad orden) {
        this.orden = orden;
    }

    public int getAvanzadas() {
        return avanzadas;
    }

    public int setAvanzadas(int avanzadas) {
        this.avanzadas = avanzadas;
        return avanzadas;
    }

    /**
     * Método abstracto de evaluar.
     * Método de orden sumando la avanzada.
     * @param situacion
     * @param evento
     * @return
     */
    public abstract String evaluar(String situacion, String evento);

    public String orden() {
        avanzadas = (avanzadas + 1);
        return "";
    }
}
