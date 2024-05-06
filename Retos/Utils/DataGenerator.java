package Retos.Utils;

public class DataGenerator {

    private static String[] nombresSample = new String[]{"Alan" , "Raul" , "Luis Eduardo" , "Maria", "Antonio", "Carlos", "Armando", "Daniel", "Rodolfo", "Galia", "Joaquin", "Roberto",
    "Manuel", "Duilio", "Octavio", "Fernando", "Alejandro", "Andres", "Angel", "Barbara", "Karla"};

    private static String[] apellidosSample = new String[]{"Bauza", "Cornelio", "Zamudio", "Casas", "Hernandez", "Sanchez", "Casasus", "Martinez", "Perez", "Lizardo", "Alejandro", "Peregrino",
    "Clemente", "Heisler", "Alfonso", "Frias", "Bocanegra", "Granados", "Salcedo", "Franco"};

    private static String[] emailSample = new String[]{"@gmail.com", "@hotmail.com", "@outlook.es", "@yahoo.com"};
    
    public static String GenerateName(){
        int indNom, indApp;
        indNom = (int)(Math.random() * nombresSample.length);
        indApp = (int)(Math.random() * apellidosSample.length);
        return nombresSample[indNom] + " " + apellidosSample[indApp];
    }

    public static String[] NameAndEmail(){
        int indNom, indApp, indEmail;
        String[] data = new String[2];
        indNom = (int)(Math.random() * nombresSample.length);
        indApp = (int)(Math.random() * apellidosSample.length);
        indEmail = (int)(Math.random() * emailSample.length);
        data[0] = nombresSample[indNom] + " " + apellidosSample[indApp];
        data[1] = nombresSample[indNom].substring(0,3).toLowerCase() + "." + apellidosSample[indApp].substring(0,3).toLowerCase() + emailSample[indEmail];
        return data;
    }

    public static String GeneratePhone(String lada){
        int numero = (int)(Math.random()*10000000);
        return lada + numero;
    }
}
