package escuadron;

/**
 * Created by Sebas on 13/03/2019.
 */
public class Soldado extends Unidad {

    private final Unidad orden;

    /**
     * Constructor de Soldado recibiendo Unidad orden
     * para realizar la cadena de responsabilidad.
     * @param orden
     * @param nombre
     */
    public Soldado(Unidad orden, String nombre) {
        super(nombre);
        this.orden = orden;
    }

    /**
     * Método heredado de Unidad, devolviendo acción o pasando la situación al superior.
     * @param situacion
     * @param evento
     * @return
     */
    @Override
    public String evaluar(String situacion, String evento) {
        if (situacion.equals("municion")){
            System.out.println("El soldado "+ this.nombre + " ofrece municion al escuadron!");
        } else {
            System.out.println(this.nombre+" no sabe que hacer! preguntara a su superior el medico!");
            return orden.evaluar(situacion,evento);
        }
        return suceso;
    }
}
