import java.util.ArrayList;

public class Donkey extends PackAnimal{

//    public Donkey(Integer id, String name, String commands) {
//        super(id, name, commands);
//    }

    public Donkey(Integer id, String name, String datebirth, String animalType, String command) {
        super(id, name, datebirth, animalType, command);
    }


    @Override
    public String toString() {
        return "Donkey {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }
}
