package JavaPractise;

public class Operators {
    public static void main(String[] args) {

        fibonacciSequence();

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
