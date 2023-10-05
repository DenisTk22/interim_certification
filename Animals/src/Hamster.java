import java.util.ArrayList;

public class Hamster extends Pet{

    public Hamster(Integer id, String name, String datebirth, String animalType,String command) {
        super(id, name, datebirth, animalType, command);
    }

    @Override
    public String toString() {
        return "Hamster {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }

}
