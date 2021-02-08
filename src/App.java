public class App {
    public static void main (String args[]) {
        // fibonacci();
        gridTraveler();
    }

    private static void fibonacci() {
        Fibonacci f = new Fibonacci();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "th fibonacci number is " +f.fib(i) );
        }
        System.out.println("50th fibonacci number is " +f.fib(50) );
        System.out.println("100th th fibonacci number is " +f.fib(100) );
    }

    private static void gridTraveler() {
        GridTraveler gt = new GridTraveler();

        System.out.println("Naive traveling solution:");
        System.out.println(gt.naiveTravel(2, 2));
        System.out.println(gt.naiveTravel(2, 3));
        System.out.println(gt.naiveTravel(3, 3));
        // System.out.println(gt.naiveTravel(16, 16));
        
        System.out.println("\nDynamic traveling solution:");
        System.out.println(gt.dinamicTravel(2, 2));
        System.out.println(gt.dinamicTravel(2, 3));
        System.out.println(gt.dinamicTravel(3, 3));
        System.out.println(gt.dinamicTravel(16, 16));
    }

}