/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 archivo.java (Clase archivo)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

Con esta clase podremos leer y sobrescribir Arrays en archivos serializados
datos y así poder retornarlos a la clase vista
 ****************************************************************************/
//importamos las librerias que necesitaremos
import java.io.*;
import java.util.*;


//clase archivo
class archivo{
	
	//método para ir guardando usuarios al sobrescribir la base de datos
	public void nuevoU(ArrayList<usuario> usuarios){
		
		
		 try{
            //Instanciar el guardador de base de datos
            ObjectOutputStream GuardarDatos = new ObjectOutputStream(new FileOutputStream("Usuarios.forestwin"));

            // Escribir la Base de datos de Usuarios
            GuardarDatos.writeObject(usuarios);
            GuardarDatos.close();

        }catch (Exception e){}
		
    }
	
	
	//método para ir guardando Arboles al sobrescribir la base de datos
	public void GuardarDatos(ArrayList<Arbol> ListaArboles){

        try{
            //Instanciar el guardador de base de datos
            ObjectOutputStream GuardarDatos = new ObjectOutputStream(new FileOutputStream("DatosArboles.forestwin"));

            // Escribir la Base de datos de Arboles
            GuardarDatos.writeObject(ListaArboles);
            GuardarDatos.close();

        }catch (Exception e){}
    }
	
	
	
	//Método que retorna un ArrayList con objetos de tipo Usuario
	public ArrayList<usuario> leerUsuarios(){
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("Usuarios.forestwin"));

            //Leer la Base de datos de usuarios
            ArrayList<usuario> UsuariosTemp= (ArrayList<usuario>) AbrirDatos.readObject();
            AbrirDatos.close();
			//retornar la lista si existe
            return UsuariosTemp;

        }catch (Exception e){
            return null;
        }
	}
	
	//Método que retorna un ArrayList con objetos de tipo Arbol
	public ArrayList<Arbol> leerArboles(){
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("DatosArboles.forestwin"));

            //Leer la Base de datos de Arboles
            ArrayList<Arbol> UsuariosTemp= (ArrayList<Arbol>) AbrirDatos.readObject();
            AbrirDatos.close();
			//Retornar la lista si existe
            return UsuariosTemp;

        }catch (Exception e){
            return null;
        }
	}
	
	//Método ToString para retornar los atributos de los objetos de tipo Arbol
	public String mostrarArboles(){
		String Retornar = "";
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("DatosArboles.forestwin"));

            //Leer la Base de datos de Arboles
            ArrayList<Arbol> ListaArboles_recuperada = (ArrayList<Arbol>) AbrirDatos.readObject();
            AbrirDatos.close();
			
			
			Arbol temp;
			//ciclo para armar los String y retornarlo a la clase vista
			for (int i = 0; i < ListaArboles_recuperada.size(); i++) {
				temp = ListaArboles_recuperada.get(i);
				Retornar = Retornar + "Especie: " + temp.getEspecie() + "\n";
				Retornar = Retornar + "Precipitacion Maxima: " + temp.getPrecipitacion() + "\n";
				Retornar = Retornar + "Precipitacion Minima: " + temp.getDeltaPre() + "\n";
				Retornar = Retornar + "Tipo de Iluminacion: " + temp.getIluminacion() + "\n";
				Retornar = Retornar + "Temperatura Maxima: " + temp.getTemperatura() + "\n";
				Retornar = Retornar + "Temperatura Minima: " + temp.getDeltaTem() + "\n";
				Retornar = Retornar + "Utilidades: " + temp.getUtilidades() + "\n";
				Retornar = Retornar + "----------------------------------------------\n";
			}
			//retornar el String armado
            return Retornar;

        }catch (Exception e){
        
            return "Base de datos no encontrada";
        }
		
	}

}
