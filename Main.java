import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Avaj Launcher");


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(30);
        numbers.add(13);

        //System.out.println(numbers);

        //for (Integer n : numbers)
         //   System.out.println(n);

        //float a = numbers.get(1);

        //numbers.forEach(f -> System.out.println(f));

        numbers.forEach((val) -> {
            System.out.println("valor: " + val);
        });

        Tower t = new Tower();
        t.register();

    }
}