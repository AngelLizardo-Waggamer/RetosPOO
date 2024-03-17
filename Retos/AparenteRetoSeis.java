package Retos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Retos.Utils.GroseriaDetectadaException;

public class AparenteRetoSeis {
    
    public static void exec() throws IOException{
        try{
            File archivo = new File("Retos\\textoSample.txt");
            Scanner scan = new Scanner(archivo);
            while(scan.hasNextLine()){

                    String line = scan.nextLine();
                    String[] datos = line.split(",");
                    if(datos[0].equals("groseria")){
                        scan.close();
                        throw new GroseriaDetectadaException("El texto contiene una palabra no debida: " + datos[0]);
                    }
                    System.out.println(datos[0]);
            }
            scan.close();
        } catch (IndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
            System.err.println("IndexOutOfBoundsException");
        } catch (GroseriaDetectadaException ex) {
            System.err.println(ex.getMessage());
            System.err.println("GroseriaDetectadaException");
        } catch (FileNotFoundException ex){
            System.out.println("FileNotFoundException");
            System.out.println(ex.getMessage());
        } catch (NumberFormatException ex){
            System.out.println("NumberFormatException");
            System.out.println(ex.getMessage());
        }
    }
}
