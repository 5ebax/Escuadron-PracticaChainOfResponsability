package escuadron;

/**
 * Created by Sebas on 13/03/2019.
 */
public class Coronel extends Unidad {

    public Coronel(String nombre) {
        super(nombre);
    }

    /**
     * Método heredado de Unidad devolviendo acción o lanzando la orden a unidad para que sume la avanzada.
     * @param situacion
     * @param evento
     * @return
     */
    @Override
    public String evaluar(String situacion, String evento) {
        if (situacion.equals("rodeo")) {
            System.out.println("El coronel " + this.nombre + " planea una estrategia y escapa de ahi!");
            return suceso;
        } else {
            System.out.println(this.nombre + " evaluara la situacion y permaneceran en el sitio para solucionarlo!");
            return super.orden();
        }
    }
}
