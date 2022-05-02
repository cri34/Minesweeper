public class Casilla{
    // m =mina,'-'=no tiene minas alrededor ni en la casilla, 'numero'=numero de minas alrededor
   private final char estado;
    // casilla marcada por jugador(banderilla)
    private boolean marcado;
    // casilla descubierta o no por el jugador
   private boolean descubierta;
    Casilla(char estado){
        this.estado=estado;
        marcado=false;
        descubierta=false;
    }
    public char getEstado() {
        return estado;
    }
    public boolean getMarcado(){
        return marcado;
    }
    public boolean getDescubierta(){
        return descubierta;
    }
    public void setMarcado(boolean marcado){
        this.marcado=marcado;
    }
    public void setDescubierta(boolean descubierta){
        this.descubierta=descubierta;
    }
}
