public class Tablero implements ClassesJava {
    private final int minTVH = 0;
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
        contarMinasAlrededorDeCasillas();
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
    //falta input jugador casilla a comprobar
    private void contarMinasAlrededorDeCasillas() {
        int posH;
        for (int posV = minTVH; posV < maxTV; posV++) {
            for (posH = minTVH; posH < maxTH; posH++) {
                comprobarMinasAlrededor(posV, posH);
            }
        }
    }

    private void comprobarMinasAlrededor(int posV, int posH) {
        int[] aPosV = {-1, -1, -1, 0, 0, 0, +1, +1, +1};
        int[] aPosH = {-1, 0, +1, -1, 0, +1, -1, 0, +1};
        boolean rango;
        boolean mina;
        int contMinProx = 0;
        int indDMax = 9;
        int indD;
        for (indD = 0; indD < indDMax; indD++) {
            rango = posH + aPosH[indD] >= minTVH && posH + aPosH[indD] < maxTH && posV + aPosV[indD] >= minTVH && posV + aPosV[indD] < maxTV;
            if (rango) {
                mina = tablero[posV + aPosV[indD]][posH + aPosH[indD]].getMina();
                if (mina) {
                    contMinProx++;
                }
            }
        }
        tablero[posV][posH].setNumMinesProx(contMinProx);
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
