package practicas;


import java.util.Scanner;

public class CuadradoMagico {

    private static Scanner sc=new Scanner(System.in);

    public static void main (String[]args){
        char continua;
        do {
            int[][] matriz = solicitarLados();
            crearCuadro(matriz);
            imprimirCuadrado(matriz);
            continua = continuarPrograma();
        }while(continua=='s'||continua=='S');
        System.out.println("Gracias por participar.");
    }

    private static char continuarPrograma() {
        char continua=0;
        String entrada;
        char [] valores = {'S','s','N','n'};
        boolean contenido = false;
        System.out.println("Desea intentarlo de nuevo: \nPresione S para continuar o Presione N para salir.");
        do {
            entrada = sc.next();
            continua=entrada.charAt(0);
            for(int i=0; i< valores.length;i++){
                if (valores[i]==continua){
                contenido=true;
                }
            }
           if (contenido==false){
               System.out.println("Respuesta incorrecta. Intentelo de nuevo.");
           }
        }while(contenido==false);
        return continua;
    }

    private static void imprimirCuadrado(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    private static void crearCuadro(int[][] matriz) {
        int fila =0, columna= matriz.length/2, contador=1;
        boolean multiplo=false;

        matriz[fila][columna]=contador;

        for (contador=2 ; contador<= matriz.length* matriz.length ; contador++){
            if (!multiplo){
                fila--;
                if(fila<0){
                    fila= matriz.length-1;
                }
                columna++;
                if(columna>= matriz.length){
                    columna=0;
                }
            }else{
                fila++;
                if(fila>= matriz.length){
                    fila=0;
                }
            }
            matriz[fila][columna]=contador;
            if (contador % matriz.length==0){
                multiplo=true;
            }else{
                multiplo=false;
            }
        }
        System.out.println();
    }

    private static int[][] solicitarLados() {
        int lados =0;

        System.out.println("Indica un numero impar mayor a 2 para crear el cuadrado magico.");
        do{
        lados = sc.nextInt();
        if (lados<3 || lados %2==0){
            System.out.println("Numero de lados incorrecto, \nIntente nuevamente.");
        }
        }while(lados<3 || lados%2==0);

        int[][] matriz = new int[lados][lados];

        return matriz;
    }
}
