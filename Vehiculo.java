import java.util.ArrayList;
public class Vehiculo{
    public static ArrayList<Vehiculo>vehiculos=new ArrayList<Vehiculo>();
    public static int idActual=1;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public Vehiculo(){
        this.id=Vehiculo.idActual;
        Vehiculo.idActual=Vehiculo.idActual+1;
        Vehiculo.vehiculos.add(this);
    }
    public Vehiculo(int mo,String ma,double va){
        this(mo,ma,va,"verde");
    }
    public Vehiculo(int mo,String ma,double va,String co){
        this.modelo=mo;
        this.marca=ma;
        this.valorComercial=va;
        this.color=co;
        this.id=Vehiculo.idActual;
        Vehiculo.idActual=Vehiculo.idActual+1;
        Vehiculo.vehiculos.add(this);
    }
    public void setSensores(ArrayList<Sensor> sen){
        this.sensores=sen;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setModelo(int mo){
        this.modelo=mo;
    }
    public void setMarca(String ma){
        this.marca=ma;
    }
    public void setValorComercial(double va){
        this.valorComercial=va;
    }
    public void setColor(String co){
        this.color=co;
    }
    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }
    public int getId(){
        return this.id;
    }
    public int getModelo(){
        return this.modelo;
    }
    public String getMarca(){
        return this.marca;
    }
    public double getValorComercial(){
        return this.valorComercial;
    }
    public String getColor(){
        return this.color;
    }
    public String toString(){
        String infoSensores="";
        String toString="";
        for(int i=0;i<this.sensores.size();i++){
            infoSensores=infoSensores+" / "+this.sensores.get(i).toString();
        }
        toString=toString+"/ "+this.getId()+", "+this.getModelo()+", "+this.getMarca()+", "+this.getValorComercial()+", "+this.getColor()+" Sensores: "+infoSensores;
        return toString;
    }
    public static String toStringVehiculos(){
        String infoVehiculos="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
            infoVehiculos=infoVehiculos+" / "+Vehiculo.vehiculos.get(i).toString();
        }
        return infoVehiculos;
    }
    public static int cantidadVehiculos(){
        int cantidadV=Vehiculo.vehiculos.size();
        return cantidadV;
    }
    public int cantidadSensores(){
        int cantidadS=this.sensores.size();
        return cantidadS;
    }
    public void anadirSensor(Sensor s){
        sensores.add(s);
    }
    public static String informacionVerdes(){
        String infoVerdes="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
            if(Vehiculo.vehiculos.get(i).getColor().equals("verde")){
                infoVerdes=infoVerdes+"/ "+Vehiculo.vehiculos.get(i).toString();
            }
        }
        return infoVerdes;
    }
    public static int obtenerVehiculoPorId(int id){
        int posicionArray=-1;
        try{
            for(int i=0;i<Vehiculo.vehiculos.size();i++){
                if(Vehiculo.vehiculos.get(i).getId()==id){
                    posicionArray=i;
                    break;
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            posicionArray=-1;
        }
        return posicionArray;
    }
    public static String informacionTemperatura(){
        String infoTemperatura="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
            ArrayList<Sensor>sTemperatura=Vehiculo.vehiculos.get(i).getSensores();
            for(int j=0;j<sTemperatura.size();j++){
                if(sTemperatura.get(j).getTipo().equals("temperatura")){
                    infoTemperatura=infoTemperatura+"/ "+sTemperatura.get(j).toString();
                }
            }
        }
        return infoTemperatura;
    }
    public static String vehiculoConMasSensores(){
        String infoVehiculo="";
        int mayor=Vehiculo.vehiculos.get(0).cantidadSensores();
        int posicionMayor=0;
        for(int i=1;i<Vehiculo.vehiculos.size();i++){
            if(Vehiculo.vehiculos.get(i).cantidadSensores()>mayor){
                mayor=Vehiculo.vehiculos.get(i).cantidadSensores();
                posicionMayor=i;
            }
        }
        infoVehiculo=Vehiculo.vehiculos.get(posicionMayor).toString();
        return infoVehiculo;
    }
    public static String ordenarArray(){
        ArrayList<Double>acumulador=new ArrayList<Double>();
        int posM;
        double temp;
        String concatenadoOrdenado="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
            ArrayList<Sensor>sTemperatura=Vehiculo.vehiculos.get(i).getSensores();
            for(int j=0;j<sTemperatura.size();j++){
                if(sTemperatura.get(j).getTipo().equals("temperatura")){
                    acumulador.add(sTemperatura.get(j).getValor());
                }
            }
        }
        for(int i=0;i<acumulador.size()-1;i++){
            posM=i;
            for(int j=i+1;j<acumulador.size();j++){
                if(acumulador.get(j)<acumulador.get(posM)){
                    posM=j;
                }
            }
            temp=acumulador.get(i);
            acumulador.set(i,acumulador.get(posM));
            acumulador.set(posM,temp);
        }
        for(int i=0;i<acumulador.size();i++){
            concatenadoOrdenado=concatenadoOrdenado+" / "+acumulador.get(i);
        }
        return concatenadoOrdenado;
    }
}