package pl.kurs.java;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Napisz program, który będzie obliczał sumy liczb znajdujących się w kilku listach.

        Program otrzymuje następujące listy:
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(10, 20, 30, 40);
        List<Integer> list3 = List.of(100, 200, 300);
        List<Integer> list4 = List.of(7, 8, 9, 10);

        Każda lista ma zostać obsłużona jako osobne zadanie.
        Wymagania:
        1. Każde zadanie ma obliczyć sumę elementów swojej listy.
        2. Zadania mają być wykonywane przez ExecutorService.
        3. Pula ma posiadać 2 wątki.
        4. Program musi odebrać wynik każdego zadania.
        5. Po zakończeniu wszystkich zadań wypisz:
        - sumę każdej listy,
        - sumę wszystkich otrzymanych wyników.
        6. Klasa odpowiedzialna za obliczanie sumy nie może wypisywać wyniku na konsolę — ma go zwrócić.
        7. Po wykonaniu wszystkich zadań należy prawidłowo zamknąć ExecutorService.
        Oczekiwany wynik:
        Suma listy 1: 15
        Suma listy 2: 100
        Suma listy 3: 600
        Suma listy 4: 34

        Suma wszystkich wyników: 749

         */

//        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
//        List<Integer> list2 = List.of(10, 20, 30, 40);
//        List<Integer> list3 = List.of(100, 200, 300);
//        List<Integer> list4 = List.of(7, 8, 9, 10);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        List<List<Integer>> lists = List.of(list1, list2, list3, list4);
//
//        List<Future<Integer>> result = new ArrayList<>();
//
//        for (List<Integer> list : lists) {
//            result.add(executorService.submit(new SumThread(list)));
//        }
//
//        int totalSum = 0;
//
//        for(int i =0; i<result.size();i++){
//            int sum = result.get(i).get();
//            System.out.println("Suma listy: " + sum);
//            totalSum += sum;
//        }
//
//        System.out.println("Suma wszystkich wynikow: " + totalSum);

//        for (Future<Integer> future : result) {
//            System.out.println(future.get());
//        }


        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
//        List<Integer> list2 = List.of(10, 20, 30, 40);
        List<Integer> list2 = null;
        List<Integer> list3 = Arrays.asList(100, null, 200, 300);
        List<Integer> list4 = List.of(7, 8, 9, 10);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        SumThread s1 = new SumThread(list1);
        SumThread s2 = new SumThread(list2);
        SumThread s3 = new SumThread(list3);
        SumThread s4 = new SumThread(list4);

        int result1 = executorService.submit(s1).get();
        int result2 = executorService.submit(s2).get();
        int result3 = executorService.submit(s3).get();
        int result4 = executorService.submit(s4).get();

        System.out.println("Suma listy 1: " + result1);
        System.out.println("Suma listy 2: " + result2);
        System.out.println("Suma listy 3: " + result3);
        System.out.println("Suma listy 4: " + result4);

        System.out.println("suma wszystkich: " + (result1 + result2 + result3 + result4));

        executorService.shutdown();


        // napisz metode ktora jako argument pobiera liste licza a jako wynik zwraca tylko liczby ktore sie powtorzyly
        // [1, 1, 2, 3, 2, 5] -> [1, 2]

    }

        public static List<Integer> findDupicates(List<Integer> list) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for(Integer number: list) {
            if(!set1.add(number)) {
                duplicates.add(number);
            }
        }

        return new ArrayList<>(duplicates);



        // rozwiazanie musi byc O(n) zlozonosc czasowa oraz O(n) zlozonosc pamieciowa


     /*
     zlozonosc O(1) - stala - niezalezna od wielkosci danych
     int x = numbers[0];

     zlozonosc 0(n) - liniowa, ilosc operacji rosnie z liczba elementow
        for(int number : numbers) {
        sout(number)
        }
        10 elementow to 10 iteracji, amilion to milion operacji

        O(n^2) kwadratowa - kazdy element porownujemy z kazdym

        O(logn) logarytmiczna - w kazdym krtokku odrzucamy polowe mozliwosci
      */
        }
}