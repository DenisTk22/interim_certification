import java.util.ArrayList;

public class Dog extends Pet{
//    public Dog(Integer id, String name, String animalType, String commands) {
//        super(id, name, animalType, commands);
//    }
    public Dog(Integer id, String name, String datebirth, String animalType, String command) {
        super(id, name, datebirth, animalType,  command);
    }


    @Override
    public String toString() {
        return "Dog {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }
}
