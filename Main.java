import java.io.IOException;
import java.util.Scanner;

import Retos.*;
public class Main{
    public static void main(String[] args) throws IOException{
        Scanner entrada = new Scanner(System.in);
        int nTarea;
            System.out.println("Ingresa el numero de reto que quieres ejecutar: ");
                nTarea = entrada.nextInt();
                switch(nTarea){
                    case 1->{
                        RetoUno.exec();
                    }
                    case 2->{
                        RetoDos.exec();
                    }
                    default->{
                        System.out.println("Intenta un numero valido");
                    }
                }
        entrada.close();
    }
}
