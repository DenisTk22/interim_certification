import java.util.ArrayList;

public class Horse extends PackAnimal{

    public Horse(Integer id, String name, String datebirth, String animalType, String command) {
        super(id, name, datebirth, animalType, command);
    }

    @Override
    public String toString() {
        return "Horse {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }
}
