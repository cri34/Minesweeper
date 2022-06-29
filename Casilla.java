public class Casilla{
   private int numMinesProx;
    private boolean marcado;
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
    public void display(){
        char tCasilla='-';
        if(!getDescubierta()){
            tCasilla=(getMina()) ? '*' : Character.forDigit(getNumMinesProx(),10);
        }
        if (getMarcado()){
            tCasilla='^';
        }
        System.out.print( "|"+ tCasilla+"|" );
    }
}
