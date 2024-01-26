# Java cheatsheet curso de POO:

## Conversion de tipo de dato para asignaciones
Para realizar cambios en el tipo de dato de un input que querramos almacenar debemos de utilizar las funciones estáticas que vienen por defecto con las clases de los tipos de datos. 

| Convertir hacia | Funcion a ocupar|
| :---: |:---|
|Int| `Integer.parseInt(x)`|
| Float | `Float.parseFloat(x)`|
| Bool | `Boolean.parseBoolean(x)` |
| Double | `Double.parseDouble(x)` |
| Long | `Long.parseLong(x)`|
| Short | `Short.parseShort(x)` |


## Funciones para input de datos
* BufferedReader: Para usar el método de BufferedReader debemos de declararlo de la siguiente manera: 
```java

    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in))

```
Al usarlo tenemos la opción de usar solo una función, la cual es `entrada.readLine()`, esta leerá todos los datos que insertemos y los guardará como String, por lo que debemos de convertirlos a el tipo de dato que requiramos.


* Scanner: Para usar el método de Scanner debemos de declararlo de la siguiente manera: 
```java

    Scanner entrada = new Scanner(System.in)

```
Al usarlo tenemos la opción de usar estas funciones para leer distintos tipos de datos: 
|Función | Tipo de dato |
| :--- | :---: |
| .nextInt() | Entero  |
| .nextLine() | String |
| .nextBoolean() | Booleano |
| .nextByte() | Byte |
| .nextDouble() | Double |
| .nextFloat() | Float |
| .nextLong() | Long |
| .nextShort() | Short |

*NOTA*: Al momento de querer capturar datos tipo `char` varias veces es recomendable ocupar la función `.next()` en vez de la función `.nextLine()` para evitar errores.

## Cómo importar/crear un paquete con archivos locales
1. Crear una carpeta donde se vaya a guardar la clase que quieras crear como paquete
1. En el archivo .java se debe de escribir `package <nombre_de_la_carpeta>`
1. En el archivo al que quieras importar esa clase se debe de declarar una variable llamada `<nombre de la carpeta>.<nombre de la clase> clase_importada = new <nombre de la carpeta>.<nombre de la clase>`

Veamos un ejemplo: 
Suponiendo que se tiene un directorio `./HolaMundo` en el que su estructura tiene la siguiente forma: 
```
HolaMundo/
        |
        |---/FuncionHolaMundo/
                            FuncHolaMundo.class
                            FuncHolaMundo.java
        |
        | main.class
        | main.java
```
En el archivo `FuncHolaMundo.java` se debe de poner esta línea de código antes de la clase del mismo nombre: 
```java
package FuncionHolaMundo;
public class FuncHolaMundo {...}
```
Y en el archivo `main.java` se debe de poner la siguiente línea de código para poder usar las funciones públicas y/o estáticas de `FuncHolaMundo.java`:
```java
public class Main{
    public static void main(String[] args){
        FuncionHolaMundo.FuncHolaMundo HolaMundo = new FuncionHolaMundo.FuncHolaMundo();
    }
}
```