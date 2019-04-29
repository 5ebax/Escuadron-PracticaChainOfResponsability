package principal;

import java.util.ArrayList;

/**
 * Created by Sebas on 14/03/2019.
 */
public class Enemigos {
    private String situacion;
    private String problema;
    private ArrayList<Enemigos> acciones;

    /**
     * Constructor de los enemigos.
     * @param situacion
     * @param problema
     */
    public Enemigos(String situacion, String problema){
        this.situacion=situacion;
        this.problema=problema;
    }

    public String getSituacion() {
        return situacion;
    }

    public String getProblema() {
        return problema;
    }
}
