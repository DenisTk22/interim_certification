import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CounterException, IOException {
        Processor animalRes = new Processor();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                \nChoose one of the options bellow:
                Type 1 to add a new animal.
                Type 2 to add a command.
                Type 3 to see the commands of an animals.
                Type 5 to see all animals.
                Type 4 to exit.
                >>>\s""");
            String selection = scanner.next();
            switch (selection) {
                case "1" -> animalRes.addAnimal();
                case "2" -> Processor.addCommand("dog2", "g");
                case "3" -> animalRes.fileRead();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Type correctly. See a menu!\n");
            }
        }
    }
}
