package utilidades;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import sun.audio.*;

/**
 * Proporciona soporte para entrada y salida
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class UtilidadesES {
	/**
	 * Flujo de entrada
	 */
	private BufferedReader flujoEntrada = null;
	/**
	 * Flujo de salida
	 */
	private PrintStream flujoSalida = null;

	public UtilidadesES(BufferedReader flujoEntrada, PrintStream flujoSalida) {
		this.flujoEntrada = flujoEntrada;
		this.flujoSalida = flujoSalida;
	}
        
        public UtilidadesES() {
            this.flujoEntrada = new BufferedReader(new InputStreamReader (System.in));
            this.flujoSalida = System.out;
        }
	/**
	 * Muestra un mensaje por el flujo de salida
	 * @param cadena Mensaje que se mostrar�
	 */
	public void mostrar(String cadena) {
			flujoSalida.print(cadena);
	}
	/**
	 * Muestra un mensaje por el flujo de salida
	 * con salto de l�nea
	 * @param cadena Mensaje que se mostrar�
	 */
	public void mostrarln(String cadena) {
		mostrar(cadena+"\n");
	}
	/**
	 * Muestra un objeto por el flujo de salida
	 * con salto de l�nea
	 * @param cadena Mensaje que se mostrar�
	 */
	public void mostrarln(Object objeto) {
		mostrar(objeto+"\n");
	}	
	/**
	 * Pide una cadena desde el flujo de entrada mostrando previamente
	 * un mensaje.
	 * @param mensaje Mensaje que se muestra
	 * @return Cadena leida
	 * @throws IOException Error en lectura de datos desde flujo entrada.
	 */
	public String pideCadena(String mensaje) throws IOException{
		String respuesta = null;
		mostrar(mensaje);
		try {
			respuesta = flujoEntrada.readLine();
		}
		catch(IOException ioe) {
			throw new IOException("Error al leer de teclado en pideCadena()",ioe);
		}
		return respuesta;
	}
    /**
     * Lee una cadena desde el flujo de entrada.
     * @return Cadena leida
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    public String pideCadena() throws IOException{
            String respuesta = null;
            try {
                    respuesta = flujoEntrada.readLine();
            }
            catch(IOException ioe) {
                    throw new IOException("Error al leer de teclado en pideCadena()",ioe);
            }
            return respuesta;
    }
    /**
     * REPRODUCCION DE AUDIOS.
     * @param path
     * @throws FileNotFoundException
     */
    public static void reproducir(String path) throws FileNotFoundException {
        FileInputStream audio;    
        audio= new FileInputStream (path);
        BufferedInputStream sonido=new BufferedInputStream(audio);
        AudioPlayer.player.start(sonido);
    }
    
    /**
     * Versión para leer enteros.
     * Poner también el número de intentos.
     * @param mensaje
     * @param numeroIntentos
     * @return
     * @throws IOException
     * @throws NumberFormatException
     * @throws Exception
     */
    public int leeEntero(String mensaje, int numeroIntentos) throws IOException, NumberFormatException, Exception {
        int numero = 0;
        boolean datoOk = false;
        Exception exception=null;
        do {
            try{
                numero = Integer.parseInt(pideCadena(mensaje));
                datoOk = true;
            }   
            catch (NumberFormatException nfe){
                numeroIntentos--;
                System.out.println("Ha ocurrido un error en el formato de los datos. El numero introducido no es valido");
                System.out.println("Le quedan "+numeroIntentos+" intentos");
                exception=nfe;
            }   
            catch (IOException ioe){
                numeroIntentos--;
                System.out.println("Error de entrada o salida.");
                System.out.println("Le quedan "+numeroIntentos+" intentos.");         
                exception=ioe;
            }
            catch (Exception e){
                numeroIntentos--;
                System.out.println("Error no esperado.");
                exception=e;
            }
        } while (numeroIntentos>0 && !datoOk);
        if (numeroIntentos == 0){
            System.out.println("Agotados todos los intentos.");
            throw exception;
        }
        return numero;
        }
    
    public int pideEntero(String mensaje) throws IOException {
        int numero=0;
        mostrarln(mensaje);
        numero = Integer.parseInt(flujoEntrada.readLine());
        return numero;
    }
}