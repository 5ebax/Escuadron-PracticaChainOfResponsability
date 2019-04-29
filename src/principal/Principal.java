package principal;


/**
 * Created by Sebas on 13/03/2019.
 *
 * Clase Principal que realizará el proceso de ejecutar.
 */

/**
 * El patrón se utiliza en los casos siguientes:
 * En una cadena de objetos que gestiona una solicitud según un orden que se define dinámicamente.
 * La forma en que una cadena de objetos gestiona una solicitud no tiene por qué conocerse en sus clientes.
 */
public class Principal {
    public static void main(String[] args) {
        ApEscuadron app = new ApEscuadron();
        app.ejecutar();
    }
}
