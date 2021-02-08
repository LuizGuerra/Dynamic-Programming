public class App {
    public static void main (String args[]) {
        fibonacci();
    }

    private static void fibonacci() {
        Fibonacci f = new Fibonacci();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Fibonacci of " + i + " is " +f.fib(i) );
        }
        System.out.println("Fibonacci of 50 is " +f.fib(50) );
        System.out.println("Fibonacci of 100 is " +f.fib(100) );
    }
}