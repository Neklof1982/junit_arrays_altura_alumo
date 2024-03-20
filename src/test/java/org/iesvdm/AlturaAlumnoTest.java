package org.iesvdm;
// De esta forma te obliga a usar Assertions delante del código
//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
//Esta trayendo todo el código estático de la clase Assertions
import org.junit.jupiter.api.Test;

import java.util.Arrays;
//Esta trayendo todo el código estatico de la clase Test

public class AlturaAlumnoTest {

    @Test
    void  verdadero() {
        // al importar static, no hace falta escribir Assertions
         assertTrue ( 1==1);

        //Sino importarmos el código estatico es la forma:
        //Assertions.assertTrue ( 1==1);
    }
    @Test
    void aniadeNombre() {

        final String [] array = new String [10];

        array[0] ="Jose";
        array[1] ="Paco";
        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno.añadeNombre
                (array, "Maria");

        assertEquals(arrayActual[arrayActual.length - 1], nombre);
        // verifica que el nombre "Maria" esta en la posicion ultima
    }
    @Test
    void aniadeNombre2() {
        final String [] array = new String[0];

        String nombre ="Maria";
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        assertEquals(nombre, arrayActual[arrayActual.length-1]);
    }

    @Test
    void aniadeNombre3() {
        final String [] array = new String[0];
        int longInicial = array.length;
        String nombre ="Maria";
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        assertEquals(longInicial+1, arrayActual.length);
        // verifica que la longitud de la cadena es la correcta
    }

    @Test
    void aniadeNombre4() {

        final String [] array = new String [10];

        array[0] ="Jose";
        array[1] ="Paco";
        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno.añadeNombre
                (array, "Maria");

        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
        arrayExpected[arrayExpected.length-1] = nombre;
        assertArrayEquals(arrayExpected, arrayActual);
    }

    @Test
    void aniadeAltura () {

        //When (Cuando)
        double[] array = {1.70, 1.90}; // Alturas iniciales

        // Do (Hacer)
        double[] arrayActual = AlturaAlumno.añadeAltura(array);

        // Then   (Entonces)

        assertEquals(1.5, arrayActual[arrayActual.length-1]);
        //arrayActual[arrayActual.length-1].
        // verifica que altura por defecto se añade al final
        // da error con el double

    }

    @Test
    void modificaAltura() {

        // When (Cuando)

        double[] array = {1.6, 1.8, 1.7};
        double[] arrayCopia = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.9;

        // Do (Hacer)

        AlturaAlumno.modificaAltura(array, posicion, altura);

        // Then (Entonces)

        assertEquals(altura, array[posicion]);

        for (int i = 0; i < array.length; i++) {
            if (i!= posicion) {
                assertEquals(array[i], arrayCopia[i]);
            }
        }
    }

    @Test
    void modificaAltura2 () {

        //When (Cuando)
        //controla que este dentro del array
        double[] array = {1.6, 1.8, 1.7};
        double[] arrayCopia = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.9;

        // Do (Hacer)

        AlturaAlumno.modificaAltura(array, posicion, altura);

        // Then (Entonces):

        //assertArrayEquals(arrayCopia, array);
        assertEquals(1.9, array[1]);
    }

    @Test
    void buscaNombre1 () {

        //When (Cuando)

        String [] array = {"Jose", "Paco", "Maria"};
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        String nombre = "Maria";

        // Do (hacer)

       // AlturaAlumno.buscaNombre(arrayCopia, nombre);
        //Then (Entonces)

        assertEquals (2, AlturaAlumno.buscaNombre(arrayCopia,nombre));

    }

    @Test
    void buscaNombre2 () {

        //When (Cuando)

        String [] array = {"Jose", "Paco", "Maria"};
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        String nombre = "Luis";

        // Do (hacer)

        //AlturaAlumno.buscaNombre(arrayCopia, nombre);
        //Then (Entonces)

        assertEquals (-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));

    }

    @Test
    void buscaNombre3 () {

        //When (Cuando)

        String [] array = {};
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        String nombre = "Luis";

        // Do (hacer)

        //AlturaAlumno.buscaNombre(arrayCopia, nombre);
        //Then (Entonces)

        assertEquals (-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));

    }

    @Test
    void buscaNombre4 () {

        //When (Cuando)

        String [] array = {"Jose", "Paco", "Maria"};
        String [] arrayCopia = Arrays.copyOf(array, array.length);
        String nombre = "";

        // Do (hacer)

        //AlturaAlumno.buscaNombre(arrayCopia, nombre);
        //Then (Entonces)

        assertEquals(-1, AlturaAlumno.buscaNombre(arrayCopia,nombre));

    }

    @Test
    void mostrar () {

        // When (Cuando)

        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        double [] arrayAltura = {1.6, 1.9, 1.7};

        //Do (hacer)

        AlturaAlumno.mostrar(arrayNombre, arrayAltura);

        //Then (Entonces)


        assertEquals(arrayNombre[0]= "Jose",arrayAltura[1] = 1.6);
        assertEquals(arrayNombre[1]= "Paco",arrayAltura[1] = 1.9);
        assertEquals(arrayNombre[2]= "Maria",arrayAltura[1] = 1.7);
    }

    @Test
    void mostar1 () {
        // dará correcto
        // When (Cuando)

        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        double [] arrayAltura = {1.6, 1.9, 1.7};

        // Do (Hacer)
        // Then (Entonces)

        assertDoesNotThrow(() -> AlturaAlumno.mostrar(arrayNombre, arrayAltura));
    }

    @Test
    void mostrar2() {
        //va a dar fallo
        String [] arrayNombre = {"Jose", "Paco", "Maria"};
        double [] arrayAltura = {1.6, 1.9 };

        // Do (Hacer)
        // Then (Entonces)
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> AlturaAlumno.mostrar(arrayNombre,arrayAltura));
    }

    @Test
    void calulaMaximo() {

        //When (Cuando)
        double [] array = {2,4,6};
        double [] arrayCopia = Arrays.copyOf(array, array.length);

        // Do (Hacer)

        //assertEquals(6, AlturaAlumno.c
    }
}
