package Retos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * EvidenceOne.
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
     * Class to execute the program.
     */
    private class programa{
        private ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
        /**
         * Main method to start the program.
         */
        public void start() throws IOException{
            iniciarSesion("admin", "admin");
            do{
                nuevoRegistro();
                if(!menu()){
                    break;
                }
            }while(menu());
            mostrarLista();
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
                    System.out.println("--------- REGISTRO DE MEDICAMENTOS ---------");
                }else{
                    System.err.println("Intente de nuevo con las credenciales correctas.");
                }
            }
        }
        /**
         * Prompts the user if they want to repeat the process of generating a new registry.
         * @return True if the user inputs {@code S}, False if the user inputs {@code N}
         * @throws IOException Because of the use of BufferedReader
         */
        private boolean menu() throws IOException{
            System.out.println("¿Desea agregar un nuevo medicamento? (S/N)");
            if(entrada.readLine().charAt(0) == 'S'){
                return true;
            }else{
                return false;
            }
        }
        /**
         * Generates a new register.
         * @throws IOException Because of the use of BufferedReader
         */
        private void nuevoRegistro() throws IOException{
            String nQ, nG, nR;
            float pP;
            char tP;
            // Start the prompt
            System.out.println("Ingrese el nombre químico del medicamento: ");
            nQ = entrada.readLine();
            System.out.println("Ingrese el nombre genérico del medicamento: ");
            nG = entrada.readLine();
            System.out.println("Ingrese el nombre registrado del medicamento: ");
            nR = entrada.readLine();
            System.out.println("Ingrese el precio al publico del medicamento: ");
            pP = Float.parseFloat(entrada.readLine());
            System.out.println("Ingrese el tipo de presentacion.\nA. Sólido\nB.Semisólido\nC.Líquido\nNota: De no darse un valor válido se tomará como No definido");
            tP = entrada.readLine().charAt(0);
            Medicamento nMEd = new Medicamento(nQ, nG, nR, pP, tP); // Create medicament object
            listaMedicamentos.add(nMEd); // Add the object to the list
        }
        /**
         * Shows the medicament list with the details of each one.
         */
        private void mostrarLista(){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("Reporte generado en " + dtf.format(LocalDateTime.now()));
            System.out.println("Medicamentos registrados: " + listaMedicamentos.size());
            for(int i = 0; i < listaMedicamentos.size(); i++){
                System.out.println("--------- MEDICAMENTO " + (i + 1) + " ---------");
                System.out.println("Registrado por: Admin");
                listaMedicamentos.get(i).datos();
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
         * @param nQ {@code String} Nombre Químico
         * @param nG {@code String} Nombre Genérico
         * @param nR {@code String} Nombre Registrado
         * @param pP {@code Float} Precio al público
         * @param t_presentacion {@code Char} tipo de presentación
         */
        public Medicamento(String nQ, String nG, String nR, float pP, char t_presentacion){
            this.nombreQuimico = nQ;
            this.nombreGenerico = nG;
            this.nombreRegistrado = nR;
            this.precioPublico = pP;
            switch(t_presentacion){
                case 'A'->{
                    this.presentacion = Presentaciones.SOLIDO;
                    this.precioVenta = precioPublico + (precioPublico * 0.09f);
                }
                case 'B'->{
                    this.presentacion = Presentaciones.SEMISOLIDO;
                    this.precioVenta = precioPublico + (precioPublico * 0.12f);
                }
                case 'C'->{
                    this.presentacion = Presentaciones.LIQUIDO;
                    this.precioVenta = precioPublico + (precioPublico * 0.13f);
                }
                default->{
                    this.presentacion = Presentaciones.NODEF;
                    this.precioVenta = precioPublico + (precioPublico * 0.1f);
                }
            }
        }
        /**
         * Prints all the data from the object.
         */
        public void datos(){
            String pres;
            System.out.println("Nombre Químico: " + nombreQuimico);
            System.out.println("Nombre Genérico: " + nombreGenerico);
            System.out.println("Nombre Registrado: " + nombreRegistrado);
            System.out.println("Precio al público: $" + precioPublico);
            System.out.println("Precio de venta: $" + precioVenta);
            pres = switch(presentacion){
                case Presentaciones.SOLIDO->"Sólido";
                case Presentaciones.LIQUIDO->"Líquido";
                case Presentaciones.SEMISOLIDO->"Semi Sólido";
                default->"No definido";
            };
            System.out.println("Presentación: " + pres);
        }
    }
}