import java.util.ArrayList;

public class Camel extends PackAnimal{

    public Camel(Integer id, String name, String datebirth, String animalType, String command) {
        super(id, name, datebirth, animalType, command);
    }

    @Override
    public String toString() {
        return "Camel {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }
}
