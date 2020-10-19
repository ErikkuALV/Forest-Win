/***************************************************************************
ForestWin
Proyecto Programación Orientada a Objetos
*Arbol.java (Clase Arbol)
*Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

Con esta clase se implemento la clase Serializable para poder guardar los 
objetos creados en un documento y poder crear así una base de datos
 ****************************************************************************/

//importamos la clase serializable
import java.io.Serializable;
//Clase Arbol
public class Arbol implements Serializable {
  //Atributos
    private String Especie;
    private float Precipitacion;
    private float DeltaPre;
    private String Iluminacion;
    private float Temperatura;
    private float DeltaTem;
    private String Utilidades;
    //**********************************************************************

    //Constructor Arbol
    public Arbol(String especie, float precipitacion, float deltaPre, String iluminacion, float temperatura, float deltaTem, String utilidades){
        this.Especie = especie;
        this.Precipitacion = precipitacion;
        this.DeltaPre = deltaPre;
        this.Iluminacion = iluminacion;
        this.Temperatura = temperatura;
        this.DeltaTem = deltaTem;
        this.Utilidades = utilidades;
    }


    //Getters de los atributos de un Arbol
    public String getEspecie() {
        return Especie;
    }
    public float getPrecipitacion() {
        return Precipitacion;
    }
    public float getDeltaPre() {
        return DeltaPre;
    }
    public String getIluminacion() {
        return Iluminacion;
    }
    public float getTemperatura() {
        return Temperatura;
    }
    public float getDeltaTem() {
        return DeltaTem;
    }
    public String getUtilidades() {
        return Utilidades;
    }


    //Setters de los atributos de un Arbol
    public void setEspecie(String especie) {
        Especie = especie;
    }
    public void setPrecipitacion(float precipitacion) {
        Precipitacion = precipitacion;
    }
    public void setDeltaPre(float deltaPre) {
        DeltaPre = deltaPre;
    }
    public void setIluminacion(String iluminacion) {
        Iluminacion = iluminacion;
    }
    public void setTemperatura(float temperatura) {
        Temperatura = temperatura;
    }
    public void setDeltaTem(float deltaTem) {
        DeltaTem = deltaTem;
    }
    public void setUtilidades(String utilidades) {
        Utilidades = utilidades;
    }


}
