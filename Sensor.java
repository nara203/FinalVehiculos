public class Sensor{
    private String tipo;
    private double valor;
    public Sensor(){}
    public Sensor(String t,double v){
        this.tipo=t;
        this.valor=v;
    }
    public void setTipo(String t){
        this.tipo=t;
    }
    public void setValor(double v){
        this.valor=v;
    }
    public String getTipo(){
        return this.tipo;
    }
    public double getValor(){
        return this.valor;
    }
    public String toString(){
        String toString=this.getTipo()+", "+this.getValor();
        return toString;
    }
}