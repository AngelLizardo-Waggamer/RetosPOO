package Retos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EvidenceOne
 */
public class EvidenceOne {
    private static EvidenceOne obC = new EvidenceOne();
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    // ! Main method
    public static void exec() throws IOException{
        programa program = obC.new programa();
        program.start();
        entrada.close();
    }
    /**
     * Class to execute the program
     */
    private class programa{
        /**
         * Main method to start the program.
         */
        public void start() throws IOException{
            iniciarSesion("admin", "admin");
        }
        /**
         * Inputs the user and password from the user, if they are correct the program continues. If not, the program will ask again until the correct credentials are proportioned.
         * @param user {@code String} username
         * @param pass {@code String} password
         * @throws IOException Because of the use of BufferedReader
         */
        private void iniciarSesion(String user, String pass) throws IOException{
            String tempUs = "", tempPs = "";
            while(!tempUs.equals(user) && !tempPs.equals(pass)){
                System.out.println("USUARIO: ");
                tempUs = entrada.readLine();
                System.out.println("CONTRASEÑA: ");
                tempPs = entrada.readLine();
                if(tempUs.equals(user) && tempPs.equals(pass)){
                    System.err.println("Ha iniciado sesión correctamente.");
                }else{
                    System.err.println("Intente de nuevo con las credenciales correctas.");
                }
            }
            
        }
    }
    /**
     * Class to create objects named Medicamento
     */
    private class Medicamento{
        private String nombreQuimico, nombreGenerico, nombreRegistrado;
        private float precioPublico, precioVenta;
        Presentaciones presentacion;
        private enum Presentaciones {
            SOLIDO,
            SEMISOLIDO,
            LIQUIDO,
            NODEF
        }
        /**
         * Constructor for the class Medicamento.
         * @param nQ
         * @param nG
         * @param nR
         * @param pP
         * @param pV
         * @param t_presentacion
         */
        public Medicamento(String nQ, String nG, String nR, float pP, float pV, char t_presentacion){
            this.nombreQuimico = nQ;
            this.nombreGenerico = nG;
            this.nombreRegistrado = nR;
            this.precioPublico = pP;
            this.precioVenta = pV;
            this.presentacion = switch(t_presentacion){
                case 'A'->Presentaciones.SOLIDO;
                case 'B'->Presentaciones.SEMISOLIDO;
                case 'C'->Presentaciones.LIQUIDO;
                default->Presentaciones.NODEF;
            };
        }
    }
}