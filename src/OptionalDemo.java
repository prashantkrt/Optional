import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = getGreeting();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        optional.ifPresent(System.out::println);
        optional.orElseThrow(RuntimeException::new);
        optional.ifPresentOrElse(i -> System.out.println(i), () -> {
            throw new RuntimeException();
        });
        //better way to write
        optional.ifPresentOrElse(System.out::println, NoSuchElementException::new);
        String ans = optional.orElse("Hello your code as null value : using default or NA");
        System.out.println(ans);
        System.out.println("Hello world!");
        String getGreeting = optional.orElseGet(() -> "Hello world");//Supplier is a FI return the String
        optional.ifPresent(System.out::println);
        optional.map(i->i.toUpperCase());
        Optional<String> s = optional.map(String::toUpperCase);//simply use this way
        System.out.println(s.get());
    }

    public static Optional<String> getGreeting() {
        String name = null;
        return Optional.ofNullable(name);
    }
}
