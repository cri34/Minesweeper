public interface Output {
    /*classe Partida*/
    String infoSelectorModo="selecciona un modo de juego:\n'1':principiante [tamaño:8x8 10minas] \n'2':intermedio [tamaño:16x16 40minas] \n'3':experto [tamaño:16x30 99minas] \n'4':personalizado \n";
    String insertaTV="inserta el tamaño vertical del tablero [min 5]";
    String insertaTH="inserta el tamaño Horizontal del tablero [min 5]";
    String insertaNM="inserta el numero de minas del tablero [min 1]";
    String ErrorModoPersonalizado="ERROR!!,VALORES INVALIDOS, minimo valores tablero [5x5] minimo valor para numeros de minas [1]";
    String ErrorConseguirInpValEditorModo="ERROR!!,VALOR INVALIDO INSERTA VALORES ENTRE 1-4";
}
