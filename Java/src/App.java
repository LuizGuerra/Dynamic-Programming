import java.util.Arrays;
public class App {
    public static void main (String args[]) {
        // fibonacci();
        // gridTraveler();
        // canSum();
        // howSum();
        // bestSum();
        // canConstruct();
        countConstruct();
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
        System.out.println(gt.dinamicTravel(18, 18));
    }

    private static void canSum() {
        Sum s = new Sum();
        System.out.println("Naive can sum:");
        System.out.println(s.naiveCanSum(7, Arrays.asList(2, 3)));
        System.out.println(s.naiveCanSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.naiveCanSum(7, Arrays.asList(2,4)));
        System.out.println(s.naiveCanSum(8, Arrays.asList(2,3,5)));
        // System.out.println(s.naiveCanSum(300, Arrays.asList(7,14)));
        
        System.out.println("\nNaive can sum:");
        System.out.println(s.dynamicCanSum(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicCanSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicCanSum(7, Arrays.asList(2,4)));
        System.out.println(s.dynamicCanSum(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicCanSum(300, Arrays.asList(7,14)));
    }

    private static void howSum() {
        Sum s = new Sum();
        System.out.println("Naive how sum:");
        System.out.println(s.naiveHowSum(7, Arrays.asList(2, 3)));
        System.out.println(s.naiveHowSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.naiveHowSum(7, Arrays.asList(2, 4)));
        System.out.println(s.naiveHowSum(8, Arrays.asList(2,3,5)));
        // System.out.println(s.naiveHowSum(300, Arrays.asList(7,14)));
        
        System.out.println("\nDynamic how sum:");
        System.out.println(s.dynamicHowSum(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicHowSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicHowSum(7, Arrays.asList(2, 4)));
        System.out.println(s.dynamicHowSum(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicHowSum(300, Arrays.asList(7,14)));
    }

    private static void bestSum() {
        Sum s = new Sum();
        System.out.println("Naive can sum:");
        System.out.println(s.naiveBestSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.naiveBestSum(8, Arrays.asList(3,5)));
        System.out.println(s.naiveBestSum(8, Arrays.asList(1,4,5)));
        // System.out.println(s.naiveBestSum(100, Arrays.asList(1,2,5,25)));
        
        System.out.println("\nDynamic best sum:");
        System.out.println(s.dynamicBestSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicBestSum(8, Arrays.asList(3,5)));
        System.out.println(s.dynamicBestSum(8, Arrays.asList(1,4,5)));
        System.out.println(s.dynamicBestSum(100, Arrays.asList(1,2,5,25)));
    }

    private static void canConstruct() {
        Construct cc = new Construct();
        System.out.println("Naive construct:");
        System.out.println(cc.naiveCanConstruct("skate", Arrays.asList("sk", "ate")));
        System.out.println(cc.naiveCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","de","ef")));
        System.out.println(cc.naiveCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","f")));
        // System.out.println(cc.naiveConstruct(
        //     "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
        //      Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
        
        System.out.println("\nDynamic construct:");
        System.out.println(cc.dynamicCanConstruct("skate", Arrays.asList("sk", "ate")));
        System.out.println(cc.dynamicCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","de","ef")));
        System.out.println(cc.dynamicCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","f")));
        System.out.println(cc.dynamicCanConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
             Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
    }

    private static void countConstruct() {
        Construct c = new Construct();
        System.out.println("Naive construct:");
        System.out.println(c.naiveCountConstruct("purple", Arrays.asList("purp","p","ur","le","purpl")));
        System.out.println(c.naiveCountConstruct("abcdef", Arrays.asList("ab","abc","cd","def","abcd")));
        System.out.println(c.naiveCountConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(c.naiveCountConstruct("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t")));
        // System.out.println(c.naiveCountConstruct(
        //     "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
        //      Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));dynamicCountConstruct
        
        System.out.println("\nDynamic construct:");
        System.out.println(c.dynamicCountConstruct("purple", Arrays.asList("purp","p","ur","le","purpl")));
        System.out.println(c.dynamicCountConstruct("abcdef", Arrays.asList("ab","abc","cd","def","abcd")));
        System.out.println(c.dynamicCountConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(c.dynamicCountConstruct("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t")));
        System.out.println(c.dynamicCountConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
             Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
    }
}