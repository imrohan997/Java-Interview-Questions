import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Imperative style of coding
        List<Integer> list = List.of(2, 4, 6, 4, 6, 5, 3, 5, 9, 0);

        List<Integer> squareList = new ArrayList<>();
        for (Integer num : list) {
            if (num % 2 == 0) {
                squareList.add(num * num);
            }
        }
        //System.out.println(squareList);

        //Declarative Style of Coding
        list.stream().filter(x -> x % 2 == 0).map(x -> x * x).sorted().forEach((x) -> System.out.println(x));
        /*                          OR                         */
        List<Integer> sortedList = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).sorted().distinct().collect(Collectors.toList());
        System.out.println(sortedList);
    }
}