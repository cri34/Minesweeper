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

    public void crearTablero() {
        tablero = new Casilla[maxTV][maxTH];
        inicializarTablero();
        generarMinas();
        mostrarTablero();
    }
    private void inicializarTablero() {
        int numC = 0;
        String obC;
        for (int posV = 0; posV < maxTV; posV++) {
            for (int posH = 0; posH < maxTH; posH++) {
                obC = "c" + numC;
                Casilla abC = new Casilla();
                tablero[posV][posH] = abC;
                numC++;
            }
        }
    }
    private void generarMinas() {
        boolean mina;
        int cM = 0;
        while (cM < numMinas) {
            posHA = rnd.nextInt(maxTH);
            posVA = rnd.nextInt(maxTV);
            mina = tablero[posVA][posHA].getMina();
            if (!mina) {
                tablero[posVA][posHA].setMina(true);
                cM++;
            }
        }
    }
    public void mostrarTablero() {
        int ultNum1chifra = 9;
        String espacios="  ";
        System.out.print( espacios );
        for (int numH = 1; numH <= maxTV; numH++ ){
            espacios=( numH > ultNum1chifra )?" ":"  ";
            System.out.print( espacios + numH );
        }
        System.out.println();
        for ( int recV = 0; recV < maxTV; recV++ ) {
            for ( int recH = 0; recH < maxTV; recH++ ) {
                if( recH==0 ){
                    espacios=( recV+1 > ultNum1chifra )? "" : " ";
                    System.out.print( espacios + (recV+1) + " " );
                }
                tablero[recV][recH].display();
            }
            System.out.println();
        }
        System.out.println("*********************************************************************");
    }

}
