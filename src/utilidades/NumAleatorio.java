package utilidades;

import java.util.Random;

public class NumAleatorio {
    
    public static int numAleatorio(int numMin, int numMax){
        Random nAleatorio = new Random();
        int numAleatorio = nAleatorio.nextInt(numMax+1-numMin) + numMin;
        return numAleatorio;    
    }
    
    public static int numAleatorio(int numero) {
        Random rand = new Random();
        return rand.nextInt(numero);
    
    }
    
}
