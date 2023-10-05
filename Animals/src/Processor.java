import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Processor {
    String animalRegistryFile = "registry.csv";


static ArrayList<Animal> animals = new ArrayList<>();
//    private static int idCount = 1;


    public void addAnimal() throws CounterException {
        Scanner scan = new Scanner(System.in);
        try (Counter counter = new Counter()) {
        while (true) {
        System.out.println("\nКакое животное вы хотите добавить: " +
                "1 - Cat " +
                "2 - Dog " +
                "3 - Hamster " +
                "4 - Donkey " +
                "5 - Horse " +
                "6 - Camel " +
                "7 - Exit" +
                ">>\s");
        String answer = scan.next();
        switch (answer) {
            case "1" -> {
                Scanner scanCat = new Scanner(System.in);
                System.out.println("Введите имя кота:");
                String catName = scanCat.next();
                System.out.println("Кот не выполняет команды!");
                String commands = "кот не выполняет команды";
                System.out.println("Введите дату рождения:");
                String datebirth = scanCat.next();
                Pet cat = new Cat(Counter.getCount(), catName, datebirth, Pet.getAnimalType(), commands);
                if (!animals.contains(cat)) {
                    animals.add(cat);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(cat.getInfo());

            }
            case "2" -> {
                Scanner scanDog = new Scanner(System.in);
                System.out.println("Введите имя собаки:");
                String dogName = scanDog.next();
                System.out.println("Введите команду для собаки:");
                String commands = scanDog.next();
                System.out.println("Введите дату рождения:");
                String datebirth = scanDog.next();
                Pet dog = new Dog(Counter.getCount(), dogName, datebirth, Pet.getAnimalType(), commands);
                if (!animals.contains(dog)) {
                    animals.add(dog);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(dog.getInfo());
            }
            case "3" -> {
                Scanner scanHamster = new Scanner(System.in);
                System.out.println("Введите имя хомяка:");
                String hamsterName = scanHamster.next();
                System.out.println("хомяк не выполняет команды!");
                String commands = "хомяк не выполняет команды";
                System.out.println("Введите дату рождения:");
                String datebirth = scanHamster.next();
                Pet hamster = new Hamster(Counter.getCount(), hamsterName, datebirth, Pet.getAnimalType(), commands);
                if (!animals.contains(hamster)) {
                    animals.add(hamster);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(hamster.getInfo());
            }
            case "4" -> {
                Scanner scanDonkey = new Scanner(System.in);
                System.out.println("Введите имя осла:");
                String donkeyName = scanDonkey.next();
                System.out.println("Введите команду для осла:");
                String commands = scanDonkey.next();
                System.out.println("Введите дату рождения:");
                String datebirth = scanDonkey.next();
                PackAnimal donkey = new Donkey(Counter.getCount(), donkeyName, datebirth, PackAnimal.getAnimalType(), commands);
                if (!animals.contains(donkey)) {
                    animals.add(donkey);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(donkey.getInfo());
            }
            case "5" -> {
                Scanner scanHorse = new Scanner(System.in);
                System.out.println("Введите имя лошади:");
                String horseName = scanHorse.next();
                System.out.println("Введите команду для лошади:");
                String commands = scanHorse.next();
                System.out.println("Введите дату рождения:");
                String datebirth = scanHorse.next();
                PackAnimal horse = new Horse(Counter.getCount(), horseName, datebirth, PackAnimal.getAnimalType(), commands);
                if (!animals.contains(horse)) {
                    animals.add(horse);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(horse.getInfo());
            }
            case "6" -> {
                Scanner scanCamel = new Scanner(System.in);
                System.out.println("Введите имя верблюда:");
                String camelName = scanCamel.next();
                System.out.println("Введите команду для верблюда:");
                String commands = scanCamel.next();
                System.out.println("Введите дату рождения:");
                String datebirth = scanCamel.next();
                PackAnimal camel = new Camel(Counter.getCount(), camelName, datebirth, PackAnimal.getAnimalType(), commands);
                if (!animals.contains(camel)) {
                    animals.add(camel);
                    System.out.println("The animal is added\n");
                    counter.add();
                } else {
                    System.out.println("The animal already exist.\n");
                }
                saveResult(camel.getInfo());
            }
            case "7" -> {return;}
            default -> System.out.println("Type correctly. See a menu!\n");
        }
    }}catch (Exception e) {
                // Ловим исключение, если что-то пошло не так
                throw new CounterException("Ошибка при работе с счетчиком.");
            }
}



    private void saveResult(String text) {
        File file = new File(animalRegistryFile);
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter(animalRegistryFile, true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void fileRead() throws IOException {

            String filePath = animalRegistryFile;
            byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
            String decodedString = new String(encodedBytes);
            System.out.println(decodedString);
    }

    static void addCommand(String name, String command) {
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
//                System.out.println(animal.getCommands());
                String newCommand = animal.getCommands() + " " +command;
                animal.setCommands(newCommand);
            } else System.out.println("нет такого животного!");
        }
    }

    static void seeCommand(String name) {
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                System.out.println(animal.getCommands());
            } else System.out.println("нет такого животного!");
        }
    }
}
