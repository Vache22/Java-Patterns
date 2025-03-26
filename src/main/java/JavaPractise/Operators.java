package JavaPractise;

import com.google.gson.stream.JsonToken;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operators {

    public static void main(String[] args) {


    }

    public static void advancedFilter(){
        class Student {
            int roll;
            int marks;
            String name;

            Student(int r, String n, int m) {
                roll = r;
                name = n;
                marks = m;
            }
            int getRoll() {
                return roll;
            }

            String getName() {
                return name;
            }

            int getMarks() {
                return marks;
            }
        }
        Student arr[] = {
                new Student(110, "abc", 70),
                new Student(101, "bcd", 80),
                new Student(120, "xyz", 60)
        };

        Map<Integer,String > m = Arrays.stream(arr)
                .collect(Collectors.toMap(Student::getRoll, Student::getName));

        for (Map.Entry<Integer,String> ent : m.entrySet()){
            System.out.println(ent.getKey() + " " + ent.getValue());
        }
    }

    public static void listIterator(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        ListIterator<Integer> it = list.listIterator();
        list.stream().forEach(System.out::println);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void filterLambda(){
        List<Integer> al = Arrays.asList(10,20,30,40,15,7,5);
        al.stream()
                .filter(x -> x > 10)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.println(x + " "));
    }

    public static void squarePattern(){
        int n = 5; // Number of rows and columns
        int i = 1;

        while(i <= n){
            int j = 1;

            while(j <= n){
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void triangularPattern(){
        int n = 3;
        int i = 1;

        while(i <= n){
            int j = 1;

            while(j <= i){
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void invertedTrianglePattern(){
        int n = 3;
        int i = 1;

        while (i <= n){
            int j = 1;

            while (j <= (n-i)){
                System.out.print("  ");
                j++;
            }

            while (j <= n){
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
    }

    public static void factorialNumber(){
        int n = 6;
        int i = 1;

        while(n > 0){
            i = i * n;
            n--;
        }
        System.out.println("Factorial of given number is " + i);
    }

    public static void allDivisorsOfNumber(){
        int num = 12;
        int i = 1;

        while(i <= num){
            if( num % i == 0){
                System.out.println(i + " ");
            }
            i++;
        }
    }

    public static void fibonacciSequence(){
        int n = 9;
        int a = 0, b = 1;

        if(n == 1){
            System.out.print(a);
        } else if (n == 2) {
            System.out.print(a + " " + b);
        }
        else {
            System.out.print(a + " " + b + " ");
            for (int i = 3; i <= n; i++) {
                int c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
        }
    }
}
