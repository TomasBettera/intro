import java.util.ArrayList; 

/**
 * Registros de temperaturas diarios de una estacion meteorológica
 */
public class MedicionesTemperaturas
{
    /**
     * Contiene las mediciones de temperaturas.
     */
    private ArrayList<Integer> registros;
    
    /**
     * Dia del registro
     */
    private int dia;
    
    /**
     * Mes del registro
     */
    private int mes;
    
    /**
     * Constructor de la clase. Inicializa dia y mes con los parámetros respectivos,
     * y la lista de registros se inicializa vacía (sin mediciones).
     * Precondición: 
     *  - dia debe ser un día válido (entre 1 y 31)
     *  - mes debe ser un mes válido (entre 1 y 12)
     */
    public MedicionesTemperaturas(int dia, int mes) {
        assert dia >= 1 && dia <= 31;
        assert mes >= 1 && mes <= 12;
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
    }
    
    /**
     * Agrega una temperatura al registro de temperaturas
     */
    public void agregarRegistro(int nuevaTemperatura) {
        registros.add(new Integer(nuevaTemperatura));
    }
    
    public int cantTempExtremas(){
        int cantExtrema = 0;
        int counter = 0;
        while(counter < registros.size()){
            int tempTemp = registros.get(counter);
            if(tempTemp <= -15 || tempTemp >= 35){
                cantExtrema++;
            }
            counter++;
        }
        return cantExtrema;
    }
    
    public int promedio(){
        int promedio = 0;
        int contador = 0;
        while(contador < registros.size()){
            promedio = promedio + registros.get(contador);
            contador++;
        }
        return promedio / registros.size();
    }
    
    public int maxTemp(){
        int maxima = registros.get(0);
        int contador = 0;
        while(contador < registros.size()){
            if(maxima < registros.get(contador)){
                maxima = registros.get(contador);
            }
            contador++;
        }
        return maxima;
    }
    
    public int minTemp(){
        int minima = registros.get(0);
        int contador = 0;
        while(contador < registros.size()){
            if(minima > registros.get(contador)){
                minima = registros.get(contador);
            }
            contador++;
        }
        return minima;
    }
    
    public int difTemp(){
        int maxima = maxTemp();
        int minima = minTemp();
        return maxima - minima;
    }
    
    /**
     * Muestra todas las temperaturas registradas en 
     * la pantalla. 
     */
    public void imprimirTemperaturas() {
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura: registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
    }
    
}
