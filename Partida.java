import java.util.InputMismatchException;

public class Partida implements ClassesJava, Output {
    private int maxTV;
    private int maxTH;
    private int numMinas;
    Tablero t = new Tablero();

    public Partida() {
        elegirModoJuego();
        t.setMaxTV(maxTV);
        t.setMaxTH(maxTH);
        t.setNumMinas(numMinas);
    }
    public void comenzarPartida() {
        t.crearTablero();

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