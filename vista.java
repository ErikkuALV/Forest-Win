/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 vista.java (Clase vosta)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

 Con esta clase podremos acceder a los métodos de la clase archivo para 
 ejecutar las funcionalidades del programa.
 
 Con esta clase imprimiremos todo lo que sucede en consola.
 ****************************************************************************/

//importamos todas la libreria util de java
import java.util.*;

//clase vista
class vista{
	//Atributo tipo Scanner
	private Scanner scan;
	//Objeto tipo archivo
	private archivo a;
	
	//Constructor de la clase
	vista(){
		
		//Instancia de los atributos
		scan = new Scanner(System.in);
		a = new archivo();
	}
//-------------------------------------------Métodos oara los menú

	//Método para imprimir el menú principal y pedir las opciones al usuario
	public int menu(){
		System.out.println("\n            FORESTWIN");
		System.out.println("-----------------------------------");
		System.out.println("\n1- Iniciar sesion");
		System.out.println("2- Registrarse");
		System.out.println("3- Mostrar Usuarios");
		System.out.println("4- Salir");
		System.out.print("Ingrese la opcion que desea ejecutar: ");
		int opcion = scan.nextInt();
	
		
		return opcion;
		
	}
	
	//Método para imprimir el sub menú y pedirle las opciones al usuario
	public int subMenu(){
		System.out.println("\n1- Mostrar todos los arboles existentes");
		System.out.println("2- Filtros de busqueda(pendiente)");//funcionalidad pendiente
		System.out.println("3- Agregar Especie");
		System.out.println("4- Eliminar especie");
		System.out.println("5- Salir");
		
		System.out.print("Ingrese la opcion que desea ejecutar: ");
		int opcion = scan.nextInt();
		return opcion;
	}
	
	
//---------------------------------------------------Métodos para los uauarios

	//Método para iniciar sesión con usuarios registrados en la base de datos
	public boolean login(){
		//variable para verificar si el usuario existe
		boolean logeado = false;
		
		//ArrayList temporal que almacena los objetos de tipo arbol de la base de datos
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp = null;

		if(usuariosRep != null){
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.next();
		
			//Comprobaciones de usuario y contraseña al momento de hacer el login
			boolean comprobadorUsuario = false;
			boolean comprobadorContrasena = false;
			
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				//variable temporal de tipo usuario
				usuario usuarioLista = usuariosRep.get(i);
						
				if(nombre.equals(usuarioLista.getNombre())){
					usuarioTemp = usuariosRep.get(i);
				}
				
			}
			
			try{ 
				if(nombre.equals(usuarioTemp.getNombre())){
					comprobadorUsuario = true;
					
				}
			}catch(Exception e){
				
			}
			
			if(comprobadorUsuario == true){
				
				
				System.out.print("Ingrese su contrasena: ");
				String contra = scan.next();
			
				try {	
					if(contra.equals(usuarioTemp.getContrasena())){
						comprobadorContrasena = true;	
					}
				}catch(Exception e){
					
				}
				
				
				if(comprobadorContrasena == true){
					System.out.println("-------------------------------------");
					System.out.println("          INICIANDO SESION...");
					System.out.println("-------------------------------------");
					
					
					System.out.println("\n          BIENVENIDO " + usuarioTemp.getNombre() + "\n");
					logeado = true;
				}else{
					System.out.println("**************************");
					System.out.println("CONTRASENA INCORRECTA");
					System.out.println("**************************");	
					
				}
			}else{
				System.out.println("**************************");
				System.out.println("USURARIO NO ENCONTRADO");
				System.out.println("**************************");	
			}
				
		}else{
			System.out.println("-------------------------------------");
			System.out.println("NO HAY USUARIOS CREADOS, REGISTRE UNO");
			System.out.println("-------------------------------------");
		}
		
		//si el usuario existe se retornará un true para poder acceder al sub Menú
		return logeado;
		
	}
	
	
	
	//creamos cada uno de los usuarios y lo mandamos al método de nuevoU de archivos para guardarlo en el txt
	public void crear(){
		//ArrayList para almacenar objetos de tipo usuario extraídos de la base de datos 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp;
		
		System.out.print("Ingrese su nombre de usuario: ");
		String nombre = scan.next();
		
		
		//si el archivo existe lo leera y sino lo creará
		if(usuariosRep != null){
			
			int contador=0;
			//recorrer el ArrayList
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				//objeto temporal de tipo usuario
				usuarioTemp = usuariosRep.get(i);
				//se compueba si existe el nombre de usuario
				if(nombre.equals(usuarioTemp.getNombre())){
					contador = 1;
				
				}
			}
			
			//condicionales si el usuario existe o no
			if(contador != 0){
				System.out.println("**************************");
				System.out.println("USURARIO YA REGISTRADO");
				System.out.println("**************************");
			}else{
				System.out.print("Ingrese su contrasena: ");
				String contra = scan.next();
				usuario u = new usuario(nombre, contra);
				usuariosRep.add(u);
				a.nuevoU(usuariosRep);
				System.out.println("-----------------------------------");
				System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
			
		}else{
			System.out.print("Ingrese su contrasena: ");
			String contra = scan.next();
			usuariosRep = new ArrayList<usuario>();
			usuario u = new usuario(nombre, contra);
			usuariosRep.add(u);
			a.nuevoU(usuariosRep);
			System.out.println("-----------------------------------");
			System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
			System.out.println("-----------------------------------");
		}
			
		
	}
	
	//Método para imprimir los usuarios existentes
	public void mostrarUsuarios(){
		//ArrayList que almacenará objetos de tipo usuario 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		if(usuariosRep == null){
			System.out.println("************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UN USUARIO");
			System.out.println("************************************************");
		}else{
			//Variable temporal de tipo usuario para utilizar sus getters 
			usuario usuarioTemp;
			System.out.println("-----------------------------------");
			
			//Ciclo para recorrer el ArrayList y poder realizar prints de cada usuario 
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				usuarioTemp = usuariosRep.get(i);
				System.out.println("Nombre de usuario: " + usuarioTemp.getNombre());
				System.out.println("Contrasena: " +usuarioTemp.getContrasena() + "\n");
				System.out.println("-----------------------------------");
			}
		}
	}
	
	
	
//--------------------------------------------------- Métodos para los arboles
	//Método para agregar una Especie nueva en la base de datos
	public void agregarArbol(){
		//Variable que cambiará si elusuario existe
		boolean existente = false;
		
		//ArrayList que almacenará objetos de tipo Arbol extraída de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol: ");
		String especie = scan.next();
		
		//Ciclo para comprobar si existe la especie introducida por el usuario
		for(int i = 0 ; i<arboles.size() ; i++){
			
			Arbol arbolTemporal = arboles.get(i);
			if(especie.equals(arbolTemporal.getEspecie())){
				//Si el nombre de la especie existe cambiaremos el valor de la variable existente
				existente = true;
			}
		}
		
		//Si la especie no existe se le piden los datos al usuario de la especia a agregar
		if(existente == false){
			System.out.print("\nIngrese la precipitacion maxima(mm): ");
			float premax = scan.nextFloat();
			
			System.out.print("\nIngrese la precipitacion minima(mm): ");
			float premin = scan.nextFloat();
			
			
			System.out.println("\nIngrese el tipo de iluminacion(solo un tipo): ");
			System.out.println("Alta");
			System.out.println("Media");
			System.out.println("Baja");
			System.out.print("=: ");
			String ilum = scan.next();
			scan.nextLine();
			
			
			
			System.out.print("\nIngrese la temperatura maxima(Celsius): ");
			float tempmax = scan.nextFloat();
			
			
			System.out.print("\nIngrese la temperatura minima(Celsius): ");
			float tempmin = scan.nextFloat();
			
			System.out.println("\nIngrese las utilidades del arbol, separelo por comas(una utilidad)");
			System.out.println("Maderable");
			System.out.println("Latex");
			System.out.println("Lena");
			System.out.println("Comestible");
			System.out.println("Medicinal");
			System.out.println("Forraje");
			System.out.println("Ornamental");
			System.out.print("=: ");
			String utilidades = scan.next();
			
			//Calculos para obtener la tempratura promedio y un delta de los valroes flaot
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			//Instanciar el objeto 
			Arbol nuevoArbol = new Arbol(especie, precipitacion, deltaPre, ilum, temperatura, deltaTem, utilidades);
			//gaurdar el objeto en el ArrayList
			arboles.add(nuevoArbol);
			//Sobrescribir la lista de la base de datos
			a.GuardarDatos(arboles);
			
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE AGREGADA CORRECTMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
		}else{
			System.out.println("************************************************");
			System.out.println("ESPECIE YA EXISTENTE, INGRESE UNA NO REGISTRADA");
			System.out.println("************************************************");
		}
	}
	//Método para Eliminar especies de la base de datos
	public void eliminarArbol(){
		
		//Variable que cambiará si el usuario existe o no
		boolean existente = false;
		//ArrayList que almacenará objetos de tipo Arbol estraido de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea eliminar: ");
		String especie = scan.next();
		
		for(int i = 0 ; i<arboles.size() ; i++){
			Arbol arbolTemporal = arboles.get(i);
			//comprobar si la especie agregada ya existe y si es así, la elimina
			if(especie.equals(arbolTemporal.getEspecie())){
				existente = true;
				arboles.remove(i);
			}
		}
			
		if(existente == true){
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE ELIMINADA CORRECTMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
			
		}else{
			System.out.println("*******************************************************");
			System.out.println("ESPECIE NO ENCONTRADA, NO SE ELIMINO NINGUNA ESPECIE");
			System.out.println("*******************************************************");
		}
	}
	
	//Método que simplemente imprime los Strings de un método de la clase Archivos
	public void mostrarArboles(){
		System.out.println("-----------------------------------");
		System.out.println(a.mostrarArboles());
	}
	

	
	
	//---------------salidas
	
	public boolean salirPerfil(){
		boolean cerrar = false;
		System.out.println("\n QUIERES SALIR DE TU PERFIL? ");
		
		System.out.println("1- Si");
		System.out.println("2- No");
		
		System.out.print("=: ");
		
		int salir = scan.nextInt();
		if(salir == 1){
			System.out.println("-----------------------------------");
			System.out.println("		   PERFIL CERRADO");
			System.out.println("-----------------------------------");
			cerrar = true;
		}
		
		return cerrar;
	}
	
	public boolean salirPrograma(){
		boolean cerrar = false;
		System.out.println("\n QUIERES SALIR DEL PROGRAMA? ");
		
		System.out.println("1- Si");
		System.out.println("2- No");
		
		System.out.print("=: ");
		
		int salir = scan.nextInt();
		if(salir == 1){
			System.out.println("-----------------------------------------");
			System.out.println("GRACIAS POR UTILIZAR NUESTRA PLATAFORMA");
			System.out.println("-----------------------------------------\n");
			System.out.println("              FORESTWIN.\n");
			cerrar = true;
		}
		
		return cerrar;
	}
	
	
}
