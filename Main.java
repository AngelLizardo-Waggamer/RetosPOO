/*
 * Author: @angl.liz
 * Github: AngelHernandez-Waggamer
 * 
 * This is the main file of the projects, to execute everyone of them you need this file.
 ! This is the only file with a main function
 */

import java.io.IOException;
import java.util.Scanner;

import Retos.*;
public class Main{
    public static void main(String[] args) throws IOException{
        Scanner entrada = new Scanner(System.in);
        String nTarea;
            System.out.println("Nomenclatura: r + numero de reto o e + numero de evidencia");
                nTarea = entrada.next();
                switch(nTarea){
                    case "r1"->{
                        RetoUno.exec();
                    }
                    case "r2"->{
                        RetoDos.exec();
                    }
                    case "r3"->{
                        RetoTres.exec();
                    }
                    case "r4"->{
                        RetoCuatro.exec();
                    }
                    case "r5"->{
                        RetoCinco.exec();
                    }
                    case "e1"->{
                        EvidenceOne.exec();
                    }
                    case "ar6"->{
                        AparenteRetoSeis.exec();
                    }
                    default->{
                        System.out.println("Intenta una opcion valida");
                    }
                }
        entrada.close();
    }
}
