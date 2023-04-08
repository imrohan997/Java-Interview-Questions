import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //1.Consumer Functional Interface
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * integer);
            }
        };
        //Calling accept method
        consumer.accept(5);

        //Lambda expression for Consumer Functional Interface
        Consumer<Integer> consumer1 = (var) -> {
            System.out.println(var * var);
        };
        consumer1.accept(5);


        //2.Supplier Functional Interface
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };
        //Calling get method
        System.out.println(supplier.get());

        //Lambda expression for Supplier Functional Interface
        Supplier<Integer> supplier1 = () -> {
            return new Random().nextInt();
        };
        System.out.println(supplier1.get());


        //3.Function Functional Interface
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "Rohan " + integer;
            }
        };

        //Calling apply method
        System.out.println(function.apply(54));

        //Lambda expression for Function Functional Interface
        Function<Integer, String> function1 = (integer) -> {
            return "" + "Rohan" + integer;
        };

        System.out.println(function1.apply(45));


        //4.Predicate Functional Interface
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("a");
            }
        };
        //Calling test method
        System.out.println(predicate.test("Rohan"));

        //Lambda expression for Predicate Functional Interface.
        Predicate<String> predicate1 = (name) -> {
            return name.equals("a");
        };

        System.out.println(predicate1.test("Rohan"));


        //5.Runnable Functional Interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am Runnable interface");
            }
        };
        //Calling run method
        runnable.run();

        //Lambda expression for Runnable Functional Interface.
        Runnable runnable1 = () -> {
            System.out.println("Hello! I am in runnable interface");
        };

        runnable1.run();


        //6.BiConsumer Functional Interface
        BiConsumer<Integer, Boolean> booleanBiConsumer = new BiConsumer<Integer, Boolean>() {
            @Override
            public void accept(Integer integer, Boolean aBoolean) {
                if (aBoolean == false) {
                    System.out.println(integer + " is valid.");
                } else {
                    System.out.println(integer + " is not valid.");
                }
            }
        };
        //Calling accept method
        booleanBiConsumer.accept(45, false);

        //Lambda expression for BiConsumer Functional Interface.
        BiConsumer<Integer, Boolean> booleanBiConsumer1 = (integer, aBoolean) -> {
            if (aBoolean == false) {
                System.out.println(integer + " is valid.");
            } else {
                System.out.println(integer + " is not valid.");
            }
        };
        booleanBiConsumer1.accept(45, false);
    }
}