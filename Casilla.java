public class Casilla{
    // m =mina,'-'=no tiene minas alrededor ni en la casilla, 'numero'=numero de minas alrededor
   private int numMinesProx;
    // casilla marcada por jugador(banderilla)
    private boolean marcado;
    // casilla descubierta o no por el jugador
   private boolean descubierta;

   private boolean mina;
    Casilla(){
        marcado=false;
        descubierta=false;
        mina=false;
        numMinesProx=0;
    }
    public int getNumMinesProx() { return numMinesProx;}
    public boolean getMarcado(){
        return marcado;
    }
    public boolean getDescubierta(){
        return descubierta;
    }
    public boolean getMina(){return mina;}
    public void setMarcado(boolean marcado){
        this.marcado=marcado;
    }
    public void setDescubierta(boolean descubierta){
        this.descubierta=descubierta;
    }
    public void setMina(boolean mina ){this.mina =mina;}
    public void setNumMinesProx(int numMinesProx ){this.numMinesProx=numMinesProx;}
}
