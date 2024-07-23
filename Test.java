import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int arr[] = {5,2,3,5,3,4};
        Set<Integer> aSet = new HashSet<>();
        Map<Integer, Long> aMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(aMap);

    }
}
