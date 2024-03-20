package org.iesvdm;
// De esta forma te obliga a usar Assertions delante del código
//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
//Esta trayendo todo el codigo estatico de la clase Assertions
import org.junit.jupiter.api.Test;
//Esta trayendo todo el codigo estatico de la clase Test
import java.util.Arrays;
import org.junit.jupiter.api.Disabled;
// no ejecutar

public class AlturaAlumnoTest {

    @Test
    void  verdadero() {
        // al importar static, no hace falta escribir Assertions
         assertTrue ( 1==1);

        //Sino importarmos el código estatico es la forma:
        //Assertions.assertTrue ( 1==1);
    }
    @Disabled
    void pruebas() {
        //creacion de copias de Array por defecto de eclipse
        //creacion de variables comunes repitiendo codigo
        //mofificar los test - sin añadir Test al final
        //intentar hacer los nombre mas descriptivos
        // en clase -> /.jdks/openjdk-19/
        // VM en casa -> /.jdks/openjdk-22/

    }

    @Test
    void aniadeNombreUltimaPosicion() {

        //When (Cuando)
        //crear un Array con dimension 10
        final String [] array = new String [10];
        //se asigna los dos primeros elementos
        array[0] ="Jose";
        array[1] ="Paco";
        //se crea la variable nombre
        String nombre = "Maria";

        //Do (Hacer)
        String[] arrayActual = AlturaAlumno.añadeNombre
                (array, "Maria");

        //Then (Entonces)
        assertEquals(arrayActual[arrayActual.length - 1], nombre);
        // verifica que el nombre "Maria" esta en la ultima posicion
    }
    @Test
    void aniadeNombreArrayVacio() {

        //When (Cuando)
        //crear un Array con dimension 0
        final String [] array = new String[0];
        //se crea la variable nombre
        String nombre ="Maria";

        //Do (Hacer)
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        //Then (Entonces)
        assertEquals(nombre, arrayActual[arrayActual.length-1]);
        // verifica que el nombre "Maria" es el ultimo elemento del Array
    }

    @Test
    void aniadeNombreComprobarLongitud() {

        //When (Cuando)
        //crear un Array con dimension 0
        final String [] array = new String[0];
        //se crea la variable longInicial con el valor de longitud del array
        int longInicial = array.length;
        //se crea la variable nombre
        String nombre ="Maria";

        //Do (Hacer)
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        //Then (Entonces)
        assertEquals(longInicial+1, arrayActual.length);
        // verifica que la longitud de la cadena es la inicial + 1.
    }

    @Test
    void aniadeNombreArrayCopiaComparado() {

        //When (Cuando)
        //crear un Array con dimension 10
        final String [] array = new String [10];
        //se asigna los dos primeros elementos
        array[0] ="Jose";
        array[1] ="Paco";
        //se crea la variable nombre
        String nombre = "Maria";

        //Do (Hacer)
        String[] arrayActual = AlturaAlumno.añadeNombre
                (array, "Maria");

        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
        // se crea una copia del array, aumentando la longitud en uno
        arrayExpected[arrayExpected.length-1] = nombre;
        // se asigna la variable nombre a la ultima posicion

        //Then (Entonces)
        assertArrayEquals(arrayExpected, arrayActual);
        // se verifica que ambos arrays son iguales
    }

    @Test
    void aniadeAlturaPorDefecto () {

        //When (Cuando)
        //se crea un array con alturas inciales
        double[] array = {1.70, 1.90};

        // Do (Hacer)
        double[] arrayActual = AlturaAlumno.añadeAltura(array);

        // Then   (Entonces)

        assertEquals(1.5, arrayActual[arrayActual.length-1]);
        // se verifica que la altura por defecto en la ultima posicion es 1.5

    }

    @Test
    void modificaAlturaPorPosicionConFor() {

        // When (Cuando)
        // se crea un array con los valores siguientes
        double[] array = {1.6, 1.8, 1.7};
        // se crea una copia del array
        double[] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable posicion que queremos modificar
        int posicion = 1;
        // se crea la variable altura con el valor a modificar
        double altura = 1.9;

        // Do (Hacer)

        AlturaAlumno.modificaAltura(arrayCopia, posicion, altura);

        // Then (Entonces)

        assertEquals(altura, arrayCopia[posicion]);
        // se verfica que el valor de la altura corresponde a la posicion

        for (int i = 0; i < arrayCopia.length; i++) {
            if (i!= posicion) {
                assertEquals(array[i], arrayCopia[i]);
            }
        }
        // con este bucle For, se comprueba que todos aquellos elementos diferntes a
        // posicion, son iguales en ambos arrays
    }

    @Test
    void modificaAlturaPorPosicionSinFor () {

        // When (Cuando)
        // se crea un array con los valores siguientes
        double[] array = {1.6, 1.8, 1.7};
        // se crea una copia del array
        double[] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable posicion que queremos modificar
        int posicion = 1;
        // se crea la variable altura con el valor a modificar
        double altura = 1.9;

        // Do (Hacer)

        AlturaAlumno.modificaAltura(array, posicion, altura);

        // Then (Entonces):

        assertEquals(1.9, array[1]);
        //se verfica que el valor de la altura corresponde a la posicion
    }

    @Test
    void buscaNombre () {

        //When (Cuando)
        // se crea un array con los valores siguientes
        String [] array = {"Jose", "Paco", "Maria"};
        // se crea una copia del array
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable nombre
        String nombre = "Maria";

        // Do (hacer)
        // AlturaAlumno.buscaNombre(arrayCopia, nombre); - Do y Then a la vez:
        //Then (Entonces)

        assertEquals (2, AlturaAlumno.buscaNombre(arrayCopia,nombre));
        //se verifcia que el metodo devuelve la posicion 2
        //por lo que la variable nombre esta en esa posicion
    }

    @Test
    void buscaNombreNoExiste () {

        //When (Cuando)
        //se crea un array con los valores siguientes
        String [] array = {"Jose", "Paco", "Maria"};
        // se crea una copia del array
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable nombre, con un elemento no contenido en el array
        String nombre = "Luis";

        // Do (hacer)
        //AlturaAlumno.buscaNombre(arrayCopia, nombre); - Do y Then a la vez:
        //Then (Entonces)

        assertEquals (-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));
        //se verfuca que el metodo devuleve -1, al no encontrarse en el Array
    }

    @Test
    void buscaNombreArrayVacio () {

        //When (Cuando)
        //se crea un array vacio
        String [] array = {};
        // se crea una copia del array
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable nombre, con un elemento no contenido en el array
        String nombre = "Luis";

        // Do (hacer)
        //AlturaAlumno.buscaNombre(arrayCopia, nombre); - Do y Then a la vez:
        //Then (Entonces)

        assertEquals (-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));
        //se verfuca que el metodo devuleve -1, al no encontrarse en el Array
    }

    @Test
    void buscaNombreBusquedaVacia () {

        //When (Cuando)
        //se crea un array con los valores siguientes
        String [] array = {"Jose", "Paco", "Maria"};
        // se crea una copia del array
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        // se crea la variable nombre vacia
        String nombre = "";

        // Do (hacer)
        //AlturaAlumno.buscaNombre(arrayCopia, nombre);- Do y Then a la vez:
        //Then (Entonces)

        assertEquals(-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));
        //se verfuca que el metodo devuleve -1, al no encontrarse en el Array
    }

    @Test
    void mostrarResultado () {

        //When (Cuando)
        //se crea un array con los valores siguientes
        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        //se crea un array con los valores siguientes
        double [] arrayAltura = {1.6, 1.9, 1.7};

        //Do (hacer)

        AlturaAlumno.mostrar(arrayNombre, arrayAltura);

        //Then (Entonces)

        assertEquals("Jose", arrayNombre[0]);
        assertEquals(1.6, arrayAltura[0]);
        assertEquals("Paco", arrayNombre[1]);
        assertEquals(1.9, arrayAltura[1]);
        assertEquals("Maria", arrayNombre[2]);
        assertEquals(1.7, arrayAltura[2]);

        // se verifica que por pantalla deberia aparecer los datos que se muestran
    }

    @Test
    void mostarSinMostrar () {
        //Ejemplo de Antonio
        //When (Cuando)
        //se crea un array con los valores siguientes
        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        //se crea un array con los valores siguientes
        double [] arrayAltura = {1.6, 1.9, 1.7};

        // Do (Hacer)
        // Then (Entonces) - Do y Then a la vez:

        assertDoesNotThrow(() -> AlturaAlumno.mostrar(arrayNombre, arrayAltura));
        //se verifica que no se lance ninguna excepcion durante la ejecucion del metodo

        // funciones lambda en Java nos permiten escribir codigo más conciso y
        // expresivo al trabajar con interfaces funcionales.
        // Son especialmente útiles en situaciones como la manipulación de listas
        // o flujos de datos.
        // funcionaes lambda ayudan a hacer las cosas mas sencillas sin complicaciones
    }

    @Test
    void mostrarConExcepcionAlturaMenor() {

        //Ejemplo explicado en clase
        //When (Cuando)
        //se crea un array con los valores siguientes
        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        //se crea un array con los valores siguientes, con una longitud menor
        double [] arrayAltura = {1.6, 1.9 };

        // Do (Hacer)
        // Then (Entonces) - Do y Then a la vez:
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                AlturaAlumno.mostrar(arrayNombre,arrayAltura));
        //se esta verificando que lanza una excepcion y la que va a lanzar
    }

    @Disabled
    // a la inversa da error
    void mostrarConExcepcionNombreMenor() {

        //When (Cuando)
        //se crea un array con los valores siguientes, con una longitud menor
        String [] arrayNombre = {"Jose", "Paco"};
        //se crea un array con los valores siguientes
        double [] arrayAltura = {1.6, 1.9, 1.7 };

        // Do (Hacer)
        // Then (Entonces) - Do y Then a la vez:

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                AlturaAlumno.mostrar(arrayNombre,arrayAltura));
        // da error por ser una excepcion de datos
    }

    @Test
    void calulaMaximoUno() {

        //When (Cuando)
        //se crea un array con los valores siguientes
        double [] array = {2,4,6};
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double[] arrayMaximo = AlturaAlumno.calculaMaximo(arrayCopia);

        // Then (Entonces)
        assertEquals(2, arrayMaximo[0]);
        assertEquals(6, arrayMaximo[1]);
        //se verfica que el primer elemento del arrayCopia es la posicion del maximo
        // y luego se verfica que el segundo elemento es el valor maximo
    }

    @Test
    void calculaMaximoDos() {

        //When (Cuando)
        //se crea un array con los valores siguientes
        double[] array = {2, 6, 4, 6};
        // se crea una copia del array
        double[] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double[] arrayMaximo = AlturaAlumno.calculaMaximo(arrayCopia);

        // Then (Entonces)
        assertEquals(1, arrayMaximo[0]);
        assertEquals(6, arrayMaximo[1]);
        // se verfica que el primer elemento del arrayCopia es la posicion del maximo
        // y luego se verfica que el segundo elemento es el valor maximo.
        // Verifica el primero de los dos repetidos
    }

    @Test
    void calulaMaximoConNegativo() {

        //When (Cuando)
        //se crea un array con los valores siguientes (incluyendo negativos)
        double [] array = {-2,-4,0};
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double[] arrayMaximo = AlturaAlumno.calculaMaximo(arrayCopia);

        // Then (Entonces)
        assertEquals(2, arrayMaximo[0]);
        assertEquals(0, arrayMaximo[1]);

        //se verfica que el primer elemento del arrayCopia es la posicion del maximo
        //y luego se verfica que el segundo elemento es el valor maximo
    }

    @Test
    void calulaMaximoConArrayVacio() {

        //When (Cuando)
        //se crea un array vacio
        double [] array = new double [0];
        //se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double[] arrayMaximo = AlturaAlumno.calculaMaximo(arrayCopia);

        // Then (Entonces)
        assertEquals(0, arrayMaximo[0]);
        assertEquals(0, arrayMaximo[1]);
        //se verfica que el primer elemento del arrayCopia es la posicion del maximo
        //y luego se verfica que el segundo elemento es el valor maximo
    }

    @Test
    void calculaMaximoLongitudArrayMaximo() {

        //When (Cuando)
        //se crea un array con los valores siguientes
        double [] array = {2,4,6};
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        //Do (Hacer )
        double[] arrayMaximo = AlturaAlumno.calculaMaximo(arrayCopia);

        //Then (Entonces)

        assertEquals(2, arrayMaximo.length);
        //se verfica que el arrayMaximo tiene que tener longitud 2
    }

    @Test
    void calculaMedia () {

        //When (Cuando)
        //se crea un array con los valores siguientes
        double [] array = {100,4,100};
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)

        double arrayMedia = AlturaAlumno.calculaMedia(arrayCopia);

        // Then (Entonces)
        assertEquals(68, arrayMedia);
        //se verifica el resultado de la media
    }

    @Test
    void calculaMediaConNegativo () {

        //When (Cuando)
        //se crea un array con los valores siguientes
        double [] array = {-4,-5,10};
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double arrayMedia = AlturaAlumno.calculaMedia(arrayCopia);

        // Then (Entonces)
        assertEquals(0.3333333333333333, arrayMedia);
        //se verifica el resultado de la media
    }

    @Test
    void calculaMediaConArrayVacio () {

        //When (Cuando)
        //se crea un array vacio
        double [] array = new double [0];
        // se crea una copia del array
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)
        double arrayMedia = AlturaAlumno.calculaMedia(arrayCopia);

        // Then (Entonces)
        assertEquals(0, arrayMedia);
        //se verifica el resultado de la media al ser vacio, es cero.
    }
}
