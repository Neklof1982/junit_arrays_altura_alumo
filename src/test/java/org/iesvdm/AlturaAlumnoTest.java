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

        assertTrue( arrayActual[arrayActual.length-1].equals(nombre));
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
        final double [] array = new double [10];

        array[0] = 1.70;
        array[1] = 1.90;
        double altura = 1.5;
        double [] arrayActual = AlturaAlumno.añadeAltura( array, 1.5);

        //assertAEquals(array, arrayActual);
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

        assertTrue(altura == array[posicion]);

        for (int i = 0; i < array.length; i++) {
            if (i!= posicion) {
                assertEquals(array[i], arrayCopia[i]);
            }
        }
    }

    @Test
    void modificaAltura2 () {
        //controla que este dentro del array
        double[] array = {1.6, 1.8, 1.7};
        double[] arrayCopia = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.9;

        // Do (Hacer)

        AlturaAlumno.modificaAltura(array, posicion, altura);

        // Then (Entonces):

        assertArrayEquals(arrayCopia, array);
    }
}
