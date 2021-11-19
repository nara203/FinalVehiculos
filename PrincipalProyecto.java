import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class PrincipalProyecto{
    public static void main(String[] args){
        PrincipalProyecto.mostrarMenu();
    }
    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese 0 para detener el programa.");
        System.out.println("Ingrese 1 para ingresar cuatro parámetros de vehículo.");
        System.out.println("Ingrese 2 para mostrar información de los vehiculos.");
        System.out.println("Ingrese 3 para mostrar la cantidad de vehículos.");
        System.out.println("Ingrese 4 para ver la información de los vehículos con color verde.");
        System.out.println("Ingrese 5 para ingresar un id y ver la información del vehículo al que pertenece el id.");
        System.out.println("Ingrese 6 para ingresar un id y asignar un sensor del vehículo al que pertenece el id.");
        System.out.println("Ingrese 7 para ingresar un id y mostrar la información de los sensores del vehículo al que pertenece el id.");
        System.out.println("Ingrese 8 para mostrar la información de todos los sensores de tipo temperatura.");
        System.out.println("Ingrese 9 para ver la información del vehículo con más sensores.");
        System.out.println("Ingrese 10 para cargar desde un txt la información de 5 vehículos (separados por comas y líneas),.");
        System.out.println("Ingrese 666 para mostrar los sensores tipo temperatura ordenados por el valor (de menor a mayor).");
        while(true){
            int num=scan.nextInt();
            if(num==0){
                System.out.println("Finaliza.");
                break;
            }else if(num==1){
                System.out.println("Ingrese el Modelo del vehículo");
                int mo=scan.nextInt();
                System.out.println("Ingrese la Marca del vehículo");
                String ma=scan.next();
                System.out.println("Ingrese el Valor comercial del vehículo");
                double va=scan.nextDouble();
                System.out.println("Ingrese el Color del vehículo");
                String co=scan.next();
                Vehiculo vAsignar=new Vehiculo(mo,ma,va,co);
                System.out.println("Finalizó la asignación de datos.");
            }else if(num==2){
                System.out.println("La información de los vehículos es: "+Vehiculo.toStringVehiculos());
            }else if(num==3){
                System.out.println("La cantidad de vehículos es: "+Vehiculo.cantidadVehiculos());
            }else if(num==4){
                System.out.println(Vehiculo.informacionVerdes());
            }else if(num==5){
                System.out.println("Ingresar un Id.");
                int n=scan.nextInt();
                int x=Vehiculo.obtenerVehiculoPorId(n);
                if(x>-1){
                    System.out.println(Vehiculo.vehiculos.get(x).toString());
                }else{
                    System.out.println("Error. Id no valido.");
                }
            }else if(num==6){
                System.out.println("Ingresar un Id.");
                int n=scan.nextInt();
                int x=Vehiculo.obtenerVehiculoPorId(n);
                if(x>-1){
                    System.out.println("Ingrese dos parametros para un sensor.");
                    System.out.println("Ingrese el tipo de sensor.");
                    String tipo=scan.next();
                    System.out.println("Ingrese el valor del sensor.");
                    double valor=scan.nextDouble();
                    Sensor sAsignar=new Sensor(tipo,valor);
                    Vehiculo.vehiculos.get(x).anadirSensor(sAsignar);
                    System.out.println("Finalización de asignación de datos.");
                }else{
                    System.out.println("Error. Id no valido.");
                }
            }else if(num==7){
                System.out.println("Ingresar un Id.");
                int n=scan.nextInt();
                int x=Vehiculo.obtenerVehiculoPorId(n);
                if(x>-1){
                    ArrayList<Sensor>sensorId=Vehiculo.vehiculos.get(x).getSensores();
                    for(int i=0;i<sensorId.size();i++){
                        System.out.println(sensorId.get(i).toString());
                    }
                }else{
                    System.out.println("Error. Id no valido.");
                }
            }else if(num==8){
                System.out.println(Vehiculo.informacionTemperatura());
            }else if(num==9){
                System.out.println(Vehiculo.vehiculoConMasSensores());
            }else if(num==10){
                File file=new File("VehiculosDelProyecto.txt");
                try{
                    Scanner input=new Scanner(file);
                    String lineas;
                    while(input.hasNextLine()){
                        lineas=input.nextLine();
                        String[] infoVehiculos=lineas.split(",");
                        Vehiculo vAsignar=new Vehiculo(Integer.parseInt(infoVehiculos[0]),infoVehiculos[1],Double.parseDouble(infoVehiculos[2]),infoVehiculos[3]);
                    }
                }catch (Exception e){
                }
            }else if(num==666){
                System.out.println(Vehiculo.ordenarArray());
            }else{
                System.out.println("Ingrese un número permitido.");
            }
            System.out.println("Ingrese 0 para detener el programa.");
            System.out.println("Ingrese 1 para ingresar cuatro parámetros de vehículo.");
            System.out.println("Ingrese 2 para mostrar información de los vehiculos.");
            System.out.println("Ingrese 3 para mostrar la cantidad de vehículos.");
            System.out.println("Ingrese 4 para ver la información de los vehículos con color verde.");
            System.out.println("Ingrese 5 para ingresar un id y ver la información del vehículo al que pertenece el id.");
            System.out.println("Ingrese 6 para ingresar un id y asignar un sensor del vehículo al que pertenece el id.");
            System.out.println("Ingrese 7 para ingresar un id y mostrar la información de los sensores del vehículo al que pertenece el id.");
            System.out.println("Ingrese 8 para mostrar la información de todos los sensores de tipo temperatura.");
            System.out.println("Ingrese 9 para ver la información del vehículo con más sensores.");
            System.out.println("Ingrese 10 para cargar desde un txt la información de 5 vehículos (separados por comas y líneas),.");
            System.out.println("Ingrese 666 para mostrar los sensores tipo temperatura ordenados por el valor (de menos a mayor).");
        }
    }
}