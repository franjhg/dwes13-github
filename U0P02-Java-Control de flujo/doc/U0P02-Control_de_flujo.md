###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P02 - Repaso: estructuras de control de flujo
#### Entrega de: *pon aquí tu nombre*
----
#### 1. Descripción:

Vamos a instalar el Java Develompent Kit (JDK) y el entorno de desarrollo Eclipse. A continuación crearemos un proyecto Java en el que practicaremos las estructuras de control de flujo (tanto de selección como de iteración) a través de diferentes programas.

#### 2. Formato de entrega:

Completa este documento incluyendo tras cada apartado el código necesario para resolver el problema (sin incluir el método `main`, sólo el código correspondiente a la solución) y el resultado de una ejecución.

* Para el código utiliza bloques de código Markdown
* Para el resultado puedes utilizar también bloques, o bien incluir capturas de pantalla de Eclipse

#### 3. Trabajo a realizar:

Antes de comenzar, escribe tu / vuestros nombres en la cabecera de este documento

##### Parte 1: Configuración del espacio de trabajo en la máquina virtual de Windows 

1. Desinstala la versión actual de Java. Recuerda que normalmente cuando decimos que un ordenador "tiene instalado Java" lo que en realidad tiene instalado es el Java Runtime Environment (JRE).
2. Descarga la última versión del [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java 8 Update 144. Localiza la descarga en la web oficial, pero si lo deseas puedes descargar el archivo desde el FTP del instituto. **Utilizaremos esta versión de Java durante todo el curso. Es muy importante que tengas la misma en casa y no la actualices para evitar problemas al compartir proyectos posteriormente**.
3. Desde el menú de inicio, abre el panel de configuración de Java (`Configurar Java`). Recuerda: hablamos del JRE. El JDK no tiene ninguna aplicación gráfica
4. Comprueba que la versión es la esperada haciendo clic en el botón `Acerca de` en la pestaña `General`
5. En la pestaña `Actualizar` desmarca la casilla *Comprobar actualizaciones automáticamente*. Esto garantizará que todos tengamos la misma versión de Java a lo largo del curso.
6. Descarga la última versión de Eclipse, llamada Oxygen. Como más adelante desarrollaremos aplicaciones Java EE, no queremos el paquete básico de instalación: en la [web de descargas de Eclipse](http://www.eclipse.org/downloads/) debes hacer clic en *Download Packages* y escoger la edición para desarrolladores Java EE. Tienes el archivo disponible en el servidor FTP del instituto.
7. Descomprime el archivo de forma que la carpeta llamada `eclipse` (sin la versión) quede donde desees, por ejemplo en la raíz `C:\`
8. Crea un acceso directo al ejecutable de Eclipse en el escritorio y/o en la barra de tareas
9. Ejecuta Eclipse: la primera decisión será la ubicación de la carpeta de espacio de trabajo o *workspace*: puedes dejar la que viene por defecto o escoger otra a tu gusto
10. Inicialmente aparecerá la pantalla de bienvenida: desmarca la casilla para que no vuelva a aparecer en el futuro

#####Parte 2: Creación y organización de un proyecto

1. Crea un nuevo proyecto Java: `File` → `New` → `Project` → `Java Project`. El nombre es importante, puesto que seguiremos la misma nomenclatura durante todo el curso: *Número de práctica - Lenguaje utilizado - Título o descripción*, en este caso: *U0P02-Java-Control de flujo* 
2. Crea desde Eclipse una carpeta `doc` en la raíz del proyecto (junto a la carpeta `src`) y copia en ella el archivo de este enunciado (arrastra el archivo a la carpeta de Eclipse). A lo largo del curso seguiremos este esquema para agrupar cada proyecto con su correspondiente enunciado.
3. Indica que queremos editar los archivos Markdown con Typora: *clic secundario sobre el archivo → Open with → Other → Browse → Localizar el ejecutable de Typora en la carpeta de archivos de programa*. No olvides marcar la casilla para indicar que queremos utilizar este programa para abrir todos los archivos Markdown
4. Comprueba que al hacer doble clic sobre un archivo Markdown en Eclipse, se abre con Typora
5. Crea una clase *HolaMundo* con un código sencillo para probar que tu instalación de Java es correcta y puedes compilar y ejecutar programas en Java. 
6. Recuerda que dispones de plantillas de código para escribir rápidamente sentencias o bloques. Por ejemplo si escribes "sout" y pulsas Ctrl + Espacio, se escribirá `System.out.println();`. También hay plantillas para escribir un bloque if-else, while, try-catch... Consulta las plantillas en `Window` → `Preferences` → `Java` → `Editor` → `Templates`


#####Parte 3: Repaso de Java: estructuras de control de flujo

Crea un paquete llamado `ControlDeFlujo` y codifica en una o varias clases los siguientes programas:

1) Preguntar al usuario el día de la semana e indicar si es laborable o no. Resolver utilizando la estructura `switch`.

- *Código*:

```java
		package control_de_flujo;
import java.util.Scanner;
public class diaSemana {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {

		String d;
		System.out.println("Introduzca un dia de la semana:");
		d=leer.nextLine();
		switch (d) {
		case "lunes": case "martes": case "miercoles": case "jueves": case "viernes":
			System.out.println(d+" es laborable");
			break;
		case "sabado": case "domingo":
			System.out.println(d+" no es laborable");
			break;
		default:
			System.out.println("Debe introducir un dia de la semana");
		}
	}
}
```

- *Ejecución*:

        Introduzca un dia de la semana:
        miercoles
        miercoles es laborable
        
        Introduzca un dia de la semana:
        domingo
        domingo no es laborable

2) Pedir al usuario cinco cadenas de texto y generar una sola cadena uniéndolas todas. Escribir esa cadena por pantalla.

- *Código*:
  ```java
  package control_de_flujo;
  import java.util.Scanner;
  public class control_de_flujo02 {
  static Scanner leer=new Scanner(System.in);

  public static void main(String[] args) {
  ​	
  	String cadena, resultado="";
  	System.out.println("Vamos a introducir cinco cadenas");
  	
  	for(int i=0;i<5;i++) {
  		System.out.println("Introduzca una cadena:");
  		cadena=leer.next();
  		resultado+=cadena;
  	}
  	System.out.println(resultado);
  }
  }
  ```


- *Ejecución*:
```
Vamos a introducir cinco cadenas
Introduzca una cadena:
a
Introduzca una cadena:
s
Introduzca una cadena:
d
Introduzca una cadena:
f
Introduzca una cadena:
g
asdfg
```

3) Ir pidiendo por teclado una serie de números enteros e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir por pantalla la suma de todos los números introducidos.

- *Código*:
```java
package control_de_flujo;
import java.util.Scanner;
public class control_de_flujo03 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
		int a, acum=0;
		
		do {
		System.out.println("Introduzca un numero menor de 50:");
		a=leer.nextInt();
		acum+=a;
		}while (acum<50);
		System.out.println("La suma de los numeros es "+acum);
	}

}
```

- *Ejecución*:
```
Introduzca un numero menor de 50:
4
Introduzca un numero menor de 50:
45
Introduzca un numero menor de 50:
4
La suma de los numeros es 53
```

4) Pedir al usuario un número. Si introduce un valor inválido (por ejemplo una letra), se le volverá a solicitar que introduzca el número. 

Cuando termines, añade a continuación una expansión de este problema: pedir al usuario un número entre el 1 y el 10, pidiéndolo de nuevo si lo introduce mal.

Observa que estos dos bloques de código pueden ser reutilizados en cualquier punto de tus futuros programas en el que desees leer un número.


- *Código*:
```java
package control_de_flujo;
import java.util.Scanner;

public class control_de_flujo04 {
static Scanner leer=new Scanner(System.in);
	public static void main(String[] args) {
	
		int a;
		boolean b=true;
		System.out.println("Introduzca un numero 1..10");
		while (b==true){
		try {
			a=leer.nextInt();
			if((a>=1)&&(a<=10)) {
				System.out.println("OK");
				b=false;
			}else {
				System.out.println("de 1..10");
			
			}
			}
			catch(Exception e) {
				System.out.println("Debe ser un numero");
				System.out.println("Introduzca un numero 1..10");
				leer=new Scanner(System.in);
			}
		}
	}
}
```

- *Ejecución*:
```
Introduzca un numero 1..10
55
de 1..10
j
Debe ser un numero
Introduzca un numero 1..10
5
OK
```

5) Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es bisiesto (sí o no). Escribir su número de días. Si los datos no están bien introducidos se volverán a pedir. Utilizar estructura `switch`.

- *Código*:

- *Ejecución*:

6) Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e incrementar en una unidad el número menor.

- *Código*:

- *Ejecución*:

7) Pedir al usuario un número entero y calcular el factorial de dicho número usando la estructura “do-while”. Repetir el ejercicio usando la estructura “while”, y repetirlo una vez más usando la estructura “for”.

- *Código (las tres versiones seguidas)*:

- *Ejecución*:

8) Basándote en la estructura `do-while`, diseña un menú de dos niveles, es decir: en un primer momento se pedirá escoger entre varias opciones, y en cada una de ellas se pedirá de nuevo escoger entre un nuevo conjunto. La temática es libre (cálculo de áreas, enciclopedia, etc). Es importante que tu programa reaccione correctamente ante entradas erróneas del usuario, y que en todos los menús haya una opción para volver.

  Ten en cuenta que codificar un menú correctamente no es trivial, conviene que pienses lo que vas a hacer antes de empezar a codificar.

9) (opcional) Inventa un problema sencillo sobre estructuras de control de flujo. Resuélvelo para comprobar que el nivel de dificultad es adecuado y comparte el enunciado con tu compañer@ de al lado. Incluye aquí tanto tu enunciado como la solución.

- *Enunciado*:

- *Código de la solución*

- *Ejecución*:

10) (opcional) Resuelve el problema que tu compañer@ plantee.

- *Enunciado de tu compañer@:*

- *Código de la solución*

- *Ejecución*:
```

```