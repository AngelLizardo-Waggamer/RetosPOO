package Retos.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Maneja la entrada de datos del usuario de manera particular
 * @author AngelLizardo-Waggamer
 * @see NumericStringEvaluator
 * 
 */
public class InputHandler {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static enum Types{
        ENTERO_NO_NEGATIVO,
        NUMERO_EN_GENERAL,
        FLOTANTE_NO_NEGATIVO,
        STRING_NO_VACIO
    }

    /**
     * Realiza la validacion especificada al input {@code String} que de el usuario.
     * @param input_type Constante de la enum {@code Types} que especifique el tipo de validacion que se debe de realizar. Tipos disponibles:
     * <ul>
     *  <li>{@code ENTERO_NO_NEGATIVO}</li>
     *  <li>{@code NUMERO_EN_GENERAL}</li>
     *  <li>{@code FLOTANTE_NO_NEGATIVO}</li>
     *  <li>{@code STRING_NO_VACIO}</li>
     * </ul>
     * @param prompt {@code String} pregunta a realizar para el usuario
     * @return {@code String} con el input validada del usuario.
     * @throws IOException Por el uso de la libreria {@code BufferedReader}
     */
    public static String input(Types input_type, String prompt) throws IOException{
        String input;
        System.out.println(prompt);
        input = entrada.readLine();
        try {
            switch(input_type){

                case ENTERO_NO_NEGATIVO->{
                    while(true){
                        if(NumericStringEvaluator.isANumber(input)){
                            if(!hasFloatPart(input)){
                                if(Integer.parseInt(input) >= 0){
                                    return input;
                                }else{
                                    System.out.println("El numero no puede ser negativo. Intente de nuevo: ");
                                    input = entrada.readLine();
                                }
                            }else{
                                System.out.println("El numero no puede contener decimales, intente de nuevo: ");
                                input = entrada.readLine();
                            }
                        }else{
                            System.out.println("El input no es un numero, intente de nuevo: ");
                            input = entrada.readLine();
                        }
                    }
                }
                case NUMERO_EN_GENERAL->{
                    while(!NumericStringEvaluator.isANumber(input)){
                        System.out.println("El string no es un numero. Intente de nuevo: ");
                        input = entrada.readLine();
                    }
                    return input;
                }
                case FLOTANTE_NO_NEGATIVO->{
                    while(true){
                        if(NumericStringEvaluator.isANumber(input)){
                            if(Float.parseFloat(input) >= 0.0f){
                                return input;
                            }else{
                                System.out.println("El numero no puede ser negativo. Intente de nuevo: ");
                                input = entrada.readLine();
                            }
                        }else{
                            System.out.println("El input no es un numero, intente de nuevo: ");
                            input = entrada.readLine();
                        }
                    }
                }
                case STRING_NO_VACIO->{
                    while(input == ""){
                        System.out.println("La entrada no puede estar vacia, intente de nuevo: ");
                        input = entrada.readLine();
                    }
                    return input;
                }
                default->{
                    return "Como chingados le hiciste para llegar aqui.";
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "e.";
        }
    }

    private static boolean hasFloatPart(String input){
        if(Float.parseFloat(input) % 1 == 0){
            return false;
        }else{
            return true;
        }
    }
}
