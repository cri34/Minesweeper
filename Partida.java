import java.util.InputMismatchException;

public class Partida implements ClassesJava, Output {
    private int maxTV;
    private int maxTH;
    private int numMinas;
    private int inputPosV;
    private int inputPosH;
    private final int turnoInicial=0;
    private int turno=turnoInicial;
    Tablero t = new Tablero();
    public Partida() {

        elegirModoJuego();
        t.setMaxTV(maxTV);
        t.setMaxTH(maxTH);
        t.setNumMinas(numMinas);
    }
    private boolean continuaPartida() {
        int turnoMax=maxTV*maxTH;
        boolean dentroLimiteTurno= turno < turnoMax;
        boolean mina=t.tablero[inputPosV][inputPosH].getMina();
        boolean marcada=t.tablero[inputPosV][inputPosH].getMarcado();
        return  dentroLimiteTurno &&  (turno==turnoInicial ||(!mina||(mina && marcada)));
    }
    private void inputUsuari() {

        int minHV = 0;
        int accion;
        boolean accionValid;
        boolean cordValida;
        do {
            try {
                System.out.println(selecPosV);
                inputPosV = leerTeclado.nextInt()-1;

                System.out.println(selecPosH);
                inputPosH = leerTeclado.nextInt()-1;

                System.out.println(selecAccion);
                accion=leerTeclado.nextInt();

                cordValida = inputPosH >= minHV && inputPosH < maxTH && inputPosV >= minHV && inputPosV < maxTV;
                accionValid= accion==1|| accion==2;

                if (cordValida && accionValid) {
                    if (accion==1){
                        t.tablero[inputPosV][inputPosH].setDescubierta(true);
                    }else{
                        t.tablero[inputPosV][inputPosH].setMarcado(true);
                    }
                    break;
                }
            } catch (InputMismatchException IME) {
                leerTeclado.next();
            }
            System.out.println(ErrorInputUsuari);
        }while(true);
    }
    public void comenzarPartida() {
        t.crearTablero();
        while (continuaPartida()){
            inputUsuari();
            t.mostrarTablero();
            turno++;
            System.out.println(turno);
        }

    }
    private void elegirModoJuego() {
        int modo = conseguirInpValEditorModos();
        if (modo == 1) {
            maxTV = 8;
            maxTH = 8;
            numMinas = 10;
        } else if (modo == 2) {
            maxTV = 16;
            maxTH = 16;
            numMinas = 40;
        } else if (modo == 3) {
            maxTV = 16;
            maxTH = 30;
            numMinas = 99;
        } else if (modo == 4) {
            insertarValModoP();
        }
    }

    private void insertarValModoP() {
        int minVH = 5;
        int minNM = 1;
        boolean inpMPValidos;
        do {
            try {
                System.out.println(insertaTV);
                maxTV = leerTeclado.nextInt();

                System.out.println(insertaTH);
                maxTH = leerTeclado.nextInt();

                System.out.println(insertaNM);
                numMinas = leerTeclado.nextInt();
                inpMPValidos = maxTV >= minVH && maxTH >= minVH && numMinas >= minNM;
                if (inpMPValidos) {
                    break;
                }
            } catch (InputMismatchException IME) {
                leerTeclado.next();
            }
            System.out.println(errorModoPersonalizado);
        } while (true);
    }

    private int conseguirInpValEditorModos() {
        int input;
        int numMenuMin = 1;
        int numMenuMax = 4;
        boolean rangNumMenuValid;
        while (true) {
            try {
                System.out.print(infoSelectorModo);
                input = leerTeclado.nextInt();
                rangNumMenuValid = input <= numMenuMax && input >= numMenuMin;
                if (rangNumMenuValid) {
                    return input;
                }
            } catch (InputMismatchException IME) {
                leerTeclado.next();
            }
            System.out.println(errorConseguirInpValEditorModo);
        }
    }
}