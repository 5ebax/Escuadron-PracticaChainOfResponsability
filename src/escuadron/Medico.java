package escuadron;

/**
 * Created by Sebas on 13/03/2019.
 */
public class Medico extends Unidad {

    private final Unidad orden;

    /**
     * Constructor de Médico recibiendo Unidad orden
     * para realizar la cadena de responsabilidad.
     * @param orden
     * @param nombre
     */
    public Medico(Unidad orden,String nombre) {
        super(nombre);
        this.orden=orden;
    }

    /**
     * Método heredado de Unidad, devolviendo acción o pasando la situación al superior.
     * @param situacion
     * @param evento
     * @return
     */
    @Override
    public String evaluar(String situacion, String evento) {
        if (situacion.equals("herido")){
            System.out.println("El medico "+ this.nombre + " cura a los heridos!");
        } else {
            System.out.println(this.nombre+" no sabe que hacer! preguntara a su superior el artillero!");
            return orden.evaluar(situacion,evento);
        }
        return suceso;
    }

}
