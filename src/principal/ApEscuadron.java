package principal;

import escuadron.*;
import utilidades.NumAleatorio;
import utilidades.UtilidadesES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Sebas on 13/03/2019.
 */
public class ApEscuadron {
    Unidad coronel;
    Unidad artillero;
    Unidad medico;
    Unidad soldado;
    UtilidadesES utilidadES;
    ArrayList<Unidad> escuadron = null;
    ArrayList<Enemigos> acciones = null;
    NumAleatorio aleatorio;
    int avanzadas=0;
    int opc;
    String situacion;
    String evento;

    public ApEscuadron() {
        this.utilidadES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)),System.out);
        this.aleatorio = new NumAleatorio();
    }

    /**
     * Ejecuta los procesos.
     */
    public void ejecutar(){
        generarEscuadron();
        utilidadES.mostrarln("El escuadron debe avanzar "+avanzadas+" veces hasta llegar al fuerte!\n");
        generarProblemas();
        try{
        avanzarEscuadron();
        } catch (IOException ioe) {
            utilidadES.mostrarln("Se ha producido un error al procesar la toma de datos.");
        }catch (NumberFormatException nfe) {
            utilidadES.mostrarln("No debe insertar caracteres que no sean numeros.");
        }
    }

    /**
     * Crea las unidades, las mete en el Array e inicia las avanzadas.
     */
    private void generarEscuadron() {
        String nombre;
            escuadron = new ArrayList<Unidad>();
        try {
            nombre = utilidadES.pideCadena("Nombre del coronel al mando del escuadron: ");
            this.coronel = new Coronel(nombre);
            escuadron.add(coronel);
            nombre = utilidadES.pideCadena("Nombre del artillero: ");
            this.artillero = new Artillero(coronel,nombre);
            escuadron.add(artillero);
            nombre = utilidadES.pideCadena("Nombre del medico: ");
            this.medico = new Medico(artillero,nombre);
            escuadron.add(medico);
            nombre = utilidadES.pideCadena("Nombre del soldado: ");
            this.soldado = new Soldado(medico,nombre);
            escuadron.add(soldado);
            soldado.setOrden(soldado);
        } catch (IOException ioe) {
            utilidadES.mostrarln("Se ha producido un error al procesar la toma de datos.");
        }
        avanzadas= coronel.getAvanzadas();
    }

    /**
     * Mete en el Array las situaciones generadas por los enemigos.
     */
    private void generarProblemas() {
            acciones = new ArrayList<Enemigos>();
            acciones.add(new Enemigos("ataque","Los enemigos estan atacandonos!"));
            acciones.add(new Enemigos("herido","Los enemigos han disparado y han herido a alguien!"));
            acciones.add(new Enemigos("municion","Por la batalla nos estamos quedando sin municion!"));
            acciones.add(new Enemigos("rodeo","Los enemigos empiezan a moverse para rodearnos!"));
    }

    /**
     * El escuadrón avanza mientras las avanzadas sean mayor de 0.
     * Genera un aleatorio del índice del Array de problemas para elegir situación y evento.
     * @throws IOException
     * @throws NumberFormatException
     */
    private void avanzarEscuadron() throws IOException, NumberFormatException {
        while(avanzadas > 0){
                int alea = aleatorio.numAleatorio(acciones.size());
                situacion = acciones.get(alea).getSituacion();
                evento = acciones.get(alea).getProblema();
                utilidadES.mostrarln(evento);
            accionOpcion();
        }
    }

    /**
     * Switch con las opciones de la persona a elegir del escuadrón.
     * Lo repite mientras la opción no sea mayor que la opc y la devuelve.
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    private int opcionUnidad() throws IOException, NumberFormatException {
        do{
            opc = utilidadES.pideEntero("Elige quien se encargara de la situacion: \n"+
                    "1. "+soldado.getNombre()+ "\n" +
                    "2. "+medico.getNombre()+ "\n" +
                    "3. "+artillero.getNombre()+ "\n" +
                    "4. Abandonar el avance!");
            switch ( opc ) {
                case 1: ordenSoldado(); break;
                case 2: ordenMedico();break;
                case 3: ordenArtillero();break;
                case 4: salir();break;
            }
        }while (opc>4);

        return opc;
    }

    /**
     * Recibe la opción, si es 4 la de salir, eliminará las avanzadas restantes y acabará.
     * Irá restando las avanzadas hasta acabar, recibiendo los avances desde la Unidad coronel.
     * @throws IOException
     * @throws NumberFormatException
     */
    private void accionOpcion() throws IOException, NumberFormatException {
        opcionUnidad();
        avanzadas=coronel.setAvanzadas(coronel.getAvanzadas()-1);
        if(opc==4) {
            avanzadas-=(avanzadas+1);
        }
        if (avanzadas > 0) {
            utilidadES.mostrarln("Aun tienen que avanzar " + avanzadas + " veces!\n");
            }else if (avanzadas==-1) {
                utilidadES.mostrarln("Fin del programa.");
            }else{
                utilidadES.mostrarln("\nYa llegaron al fuerte y ganaron!");
            }
    }
    /**
     * Se devuelven las acciones de cada opción del menú.
     * @return
     */
    private String ordenSoldado() {
        soldado.setOrden(soldado);
        return soldado.getOrden().evaluar(situacion,evento);
    }
    private String ordenMedico() {
        medico.setOrden(medico);
        return medico.getOrden().evaluar(situacion,evento);
    }
    private String ordenArtillero() {
        artillero.setOrden(artillero);
        return artillero.getOrden().evaluar(situacion,evento);
    }
    private void salir(){
        utilidadES.mostrarln("Has abandonado al escuadron a su suerte!");
    }

}
