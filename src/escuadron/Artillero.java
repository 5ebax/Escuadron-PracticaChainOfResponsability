package escuadron;

/**
 * Created by Sebas on 13/03/2019.
 */
public class Artillero extends Unidad {

    private final Unidad orden;

    /**
     * Constructor de Médico recibiendo Unidad orden
     * para realizar la cadena de responsabilidad.
     * @param orden
     * @param nombre
     */
    public Artillero(Unidad orden,String nombre) {
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
        if (situacion.equals("ataque")){
            System.out.println("El artillero "+ this.nombre + " acribilla a todos los enemigos!");
        } else {
            System.out.println(this.nombre+" no sabe que hacer! preguntara a su superior el coronel!");
            return orden.evaluar(situacion,evento);
        } return suceso;
    }
}
