package Retos;

public class RetoSiete {

    public static void exec(){
        
        RetoSiete r = new RetoSiete();
        MaquinaDeCafe maquina = r.new MaquinaDeCafe();
        maquina.setMaximaCantidadAgua(3000);
        maquina.setMaximaCantidadAzucar(2000);
        maquina.setMaximaCantidadCafe(2000);
    }

    protected class MaquinaDeCafe{
        
        private int MaximaCantidadAgua, MaximaCantidadCafe, MaximaCantidadAzucar;

        public MaquinaDeCafe() {
        }

        
        // Getters & setters

        public int getMaximaCantidadAzucar() {
            return MaximaCantidadAzucar;
        }

        public void setMaximaCantidadAzucar(int maximaCantidadAzucar) {
            MaximaCantidadAzucar = maximaCantidadAzucar;
        }

        public int getMaximaCantidadCafe() {
            return MaximaCantidadCafe;
        }

        public void setMaximaCantidadCafe(int maximaCantidadCafe) {
            MaximaCantidadCafe = maximaCantidadCafe;
        }

        public int getMaximaCantidadAgua() {
            return MaximaCantidadAgua;
        }

        public void setMaximaCantidadAgua(int maximaCantidadAgua) {
            MaximaCantidadAgua = maximaCantidadAgua;
        }
        
    }
}
