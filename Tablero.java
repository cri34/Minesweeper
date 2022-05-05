public class Tablero implements ClassesJava {
    private int maxTV;
    private int maxTH;
    private int numMinas;
    Casilla[][] tablero;
    int posHA;
    int posVA;
    public Tablero() {
    }

    public void setMaxTH(int maxTH) {
        this.maxTH = maxTH;
    }

    public void setMaxTV(int maxTV) {
        this.maxTV = maxTV;
    }

    public void setNumMinas(int numMinas) {
        this.numMinas = numMinas;
    }

}

