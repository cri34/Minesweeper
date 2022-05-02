public class Tablero {
    private int maxTV;
    private int maxTH;
     private  int numMinas;
    Casilla [][] tablero;
    public Tablero() {
    }

    public void setMaxTH(int maxTH) {
        this.maxTH = maxTH;
    }
    public void setMaxTV(int maxTV) {
        this.maxTV = maxTV;
    }
    public void setNumMinas (int numMinas){
        this.numMinas=numMinas;
    }
}

