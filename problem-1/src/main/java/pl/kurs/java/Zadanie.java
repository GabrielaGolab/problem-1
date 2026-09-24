package pl.kurs.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Zadanie {
    public static void main(String[] args) {

        /*
        Zadanie 03:
        Stworz klase PrinterThread (letter, amount, interval)
        ktorego zadaniem bedzie wypisywanie litery LETTER co INTERNAL ms czasu AMOUNT razy
        np: A, 10, 100, ma wypisac literke A co 10 razy co 100 milisekund.

                Stworz 4 instancje printerthread'a

        niech trzy pierwsze uruchomią się od razu, a czwarta w momencie gdy chociaz jedna z trzech uruchomionych sie skonczy.
                UWAGA: nie wolno pisac logiki sterowania przeplywem w klasie PrinterThread!

         */

        PrintThread p1 = new PrintThread("A",4,1000);
        PrintThread p2 = new PrintThread("B",4,500);
        PrintThread p3 = new PrintThread("C",4,1000);
        PrintThread p4 = new PrintThread("D",4,1000);
        PrintThread p5 = new PrintThread("E",4,1000);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(p1);
        executor.submit(p2);
        executor.submit(p3);
        executor.submit(p4);
        executor.submit(p5);


        executor.shutdown();
    }
}
