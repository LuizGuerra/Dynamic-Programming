import java.util.Arrays;
public class App {
    
    static Fibonacci f = new Fibonacci();
    static GridTraveler gt = new GridTraveler();
    static Sum s = new Sum();
    static Construct c = new Construct();

    public static void main (String args[]) {
        // fibonacci();
        gridTraveler();
        // canSum();
        // howSum();
        // bestSum();
        // canConstruct();
        // countConstruct();
        // allConstruct();
    }

    private static void fibonacci() {
        System.out.println("Naive fibonacci solution:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "th fibonacci number is " + f.naiveFib(i) );
        }

        System.out.println("\nDynamic fibonacci memoization solution:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "th fibonacci number is " +f.dynamicFibMemo(i) );
        }
        System.out.println("50th fibonacci number is " +f.dynamicFibMemo(50) );
        System.out.println("100th th fibonacci number is " +f.dynamicFibMemo(100) );

        System.out.println("\nDynamic fibonacci tabular solution:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "th fibonacci number is " +f.dynamicFibTabular(i) );
        }
        System.out.println("50th fibonacci number is " +f.dynamicFibTabular(50) );
        System.out.println("100th th fibonacci number is " +f.dynamicFibTabular(100) );
    }

    private static void gridTraveler() {
        System.out.println("Naive traveling solution:");
        System.out.println(gt.naiveTravel(2, 2));
        System.out.println(gt.naiveTravel(2, 3));
        System.out.println(gt.naiveTravel(3, 3));
        
        System.out.println("\nDynamic traveling with memoization solution:");
        System.out.println(gt.dinamicTravelMemo(2, 2));
        System.out.println(gt.dinamicTravelMemo(2, 3));
        System.out.println(gt.dinamicTravelMemo(3, 3));
        System.out.println(gt.dinamicTravelMemo(18, 18));
        
        System.out.println("\nDynamic traveling with tabulation solution:");
        System.out.println(gt.dynamicTravelTabular(2, 2));
        System.out.println(gt.dynamicTravelTabular(2, 3));
        System.out.println(gt.dynamicTravelTabular(3, 3));
        System.out.println(gt.dynamicTravelTabular(18, 18));
    }

    private static void canSum() {
        System.out.println("Naive can sum:");
        // System.out.println(s.naiveCanSum(7, Arrays.asList(2, 3)));
        // System.out.println(s.naiveCanSum(7, Arrays.asList(5,3,4,7)));
        // System.out.println(s.naiveCanSum(7, Arrays.asList(2,4)));
        // System.out.println(s.naiveCanSum(8, Arrays.asList(2,3,5)));
        // System.out.println(s.naiveCanSum(300, Arrays.asList(7,14)));
        
        System.out.println("\nDynamic can sum with memoization:");
        System.out.println(s.dynamicCanSum(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicCanSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicCanSum(7, Arrays.asList(2,4)));
        System.out.println(s.dynamicCanSum(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicCanSum(300, Arrays.asList(7,14)));
        
        System.out.println("\nDynamic can sum with tabulation:");
        System.out.println(s.dynamicCanSumTabular(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicCanSumTabular(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicCanSumTabular(7, Arrays.asList(2,4)));
        System.out.println(s.dynamicCanSumTabular(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicCanSumTabular(300, Arrays.asList(7,14)));
    }

    private static void howSum() {
        Sum s = new Sum();
        System.out.println("Naive how sum:");
        System.out.println(s.naiveHowSum(7, Arrays.asList(2, 3)));
        System.out.println(s.naiveHowSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.naiveHowSum(7, Arrays.asList(2, 4)));
        System.out.println(s.naiveHowSum(8, Arrays.asList(2,3,5)));
        System.out.println(s.naiveHowSum(300, Arrays.asList(7,14)));
        
        System.out.println("\nDynamic how sum with memoization:");
        System.out.println(s.dynamicHowSumMemo(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicHowSumMemo(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicHowSumMemo(7, Arrays.asList(2, 4)));
        System.out.println(s.dynamicHowSumMemo(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicHowSumMemo(300, Arrays.asList(7,14)));
        
        System.out.println("\nDynamic how sum with tabulation:");
        System.out.println(s.dynamicHowSumTabular(7, Arrays.asList(2, 3)));
        System.out.println(s.dynamicHowSumTabular(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicHowSumTabular(7, Arrays.asList(2, 4)));
        System.out.println(s.dynamicHowSumTabular(8, Arrays.asList(2,3,5)));
        System.out.println(s.dynamicHowSumTabular(300, Arrays.asList(7,14)));
    }

    private static void bestSum() {
        Sum s = new Sum();
        System.out.println("Naive can sum:");
        System.out.println(s.naiveBestSum(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.naiveBestSum(8, Arrays.asList(3,5)));
        System.out.println(s.naiveBestSum(8, Arrays.asList(1,4,5)));
        // System.out.println(s.naiveBestSum(100, Arrays.asList(1,2,5,25)));
        
        System.out.println("\nDynamic best sum with memoization:");
        System.out.println(s.dynamicBestMemo(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicBestMemo(8, Arrays.asList(3,5)));
        System.out.println(s.dynamicBestMemo(8, Arrays.asList(1,4,5)));
        System.out.println(s.dynamicBestMemo(100, Arrays.asList(1,2,5,25)));
        
        System.out.println("\nDynamic best sum with tabulation:");
        System.out.println(s.dynamicBestSumTabular(7, Arrays.asList(5,3,4,7)));
        System.out.println(s.dynamicBestSumTabular(8, Arrays.asList(3,5)));
        System.out.println(s.dynamicBestSumTabular(8, Arrays.asList(1,4,5)));
        System.out.println(s.dynamicBestSumTabular(100, Arrays.asList(1,2,5,25)));
    }

    private static void canConstruct() {
        System.out.println("Naive construct:");
        System.out.println(c.naiveCanConstruct("skate", Arrays.asList("sk", "ate")));
        System.out.println(c.naiveCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","de","ef")));
        System.out.println(c.naiveCanConstruct("abcdef", Arrays.asList("ab","cd","abc","bc","f")));
        
        System.out.println("\nDynamic construct with memoization:");
        System.out.println(c.dynamicCanConstructMemo("skate", Arrays.asList("sk", "ate")));
        System.out.println(c.dynamicCanConstructMemo("abcdef", Arrays.asList("ab","cd","abc","bc","de","ef")));
        System.out.println(c.dynamicCanConstructMemo("abcdef", Arrays.asList("ab","cd","abc","bc","f")));
        System.out.println(c.dynamicCanConstructMemo(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
             Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
        
        System.out.println("\nDynamic construct with tabulation:");
        System.out.println(c.dynamicCanConstructTabular("skate", Arrays.asList("sk", "ate")));
        System.out.println(c.dynamicCanConstructTabular("abcdef", Arrays.asList("ab","cd","abc","bc","de","ef")));
        System.out.println(c.dynamicCanConstructTabular("abcdef", Arrays.asList("ab","cd","abc","bc","f")));
        System.out.println(c.dynamicCanConstructTabular(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
    }

    private static void countConstruct() {
        System.out.println("Naive construct:");
        System.out.println(c.naiveCountConstruct("purple", Arrays.asList("purp","p","ur","le","purpl")));
        System.out.println(c.naiveCountConstruct("abcdef", Arrays.asList("ab","abc","cd","def","abcd")));
        System.out.println(c.naiveCountConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(c.naiveCountConstruct("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t")));
        
        System.out.println("\nDynamic construct with memoization:");
        System.out.println(c.dynamicCountConstructMemo("purple", Arrays.asList("purp","p","ur","le","purpl")));
        System.out.println(c.dynamicCountConstructMemo("abcdef", Arrays.asList("ab","abc","cd","def","abcd")));
        System.out.println(c.dynamicCountConstructMemo("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(c.dynamicCountConstructMemo("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t")));
        System.out.println(c.dynamicCountConstructMemo(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
             Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
        
        System.out.println("\nDynamic construct with tabulation:");
        System.out.println(c.dynamicCountConstructTabular("purple", Arrays.asList("purp","p","ur","le","purpl")));
        System.out.println(c.dynamicCountConstructTabular("abcdef", Arrays.asList("ab","abc","cd","def","abcd")));
        System.out.println(c.dynamicCountConstructTabular("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar")));
        System.out.println(c.dynamicCountConstructTabular("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t")));
        System.out.println(c.dynamicCountConstructTabular(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("e","ee","eee","eeee","eeeeee","eeeeeee","eeeeeeee")));
    }

    private static void allConstruct() {
        Construct c = new Construct();
        System.out.println("Naive construct:");
        System.out.println(c.naiveAllConstruct("purple", Arrays.asList("purp","p","ur","le","purpl"))); //2
        System.out.println(c.naiveAllConstruct("abcdef", Arrays.asList("ab","abc","cd","def","abcd"))); //1
        System.out.println(c.naiveAllConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar"))); //0
        System.out.println(c.naiveAllConstruct("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t"))); //4
        
        System.out.println("\nDynamic construct with memoization:");
        System.out.println(c.dynamicAllConstructMemo("purple", Arrays.asList("purp","p","ur","le","purpl"))); //2
        System.out.println(c.dynamicAllConstructMemo("abcdef", Arrays.asList("ab","abc","cd","def","abcd"))); //1
        System.out.println(c.dynamicAllConstructMemo("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar"))); //0
        System.out.println(c.dynamicAllConstructMemo("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t"))); //4
        System.out.println(c.dynamicAllConstructMemo(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
             Arrays.asList("e","ee","eee","eeee","eeeeee"))); //0
        
        System.out.println("\nDynamic construct with tabulation:");
        System.out.println(c.dynamicAllConstructTabular("purple", Arrays.asList("purp","p","ur","le","purpl"))); //2
        System.out.println(c.dynamicAllConstructTabular("abcdef", Arrays.asList("ab","abc","cd","def","abcd"))); //1
        System.out.println(c.dynamicAllConstructTabular("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar"))); //0
        System.out.println(c.dynamicAllConstructTabular("enterapotentpot", Arrays.asList("a","p","ent","enter","ot","o","t"))); //4
        // System.out.println(c.dynamicAllConstructTabular("eeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e","ee","eee","eeee","eeeeee"))); //0
    }
}