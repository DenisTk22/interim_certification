import java.util.ArrayList;

public class Animal {
    private static int id;
    private static String name;
    private static String datebirth;
    private static String commands;


    public Animal(Integer id, String name, String datebirth, String commands) {
        this.id = Counter.getCount();
        this.name = name;
        this.commands = commands;
        this.datebirth = datebirth;
    }

    public int getId() {
        return Counter.getCount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDatebirth() {
        return datebirth;
    }

    public void setCommands(String commands) {
        Animal.commands = commands;
    }

    public String getCommands() {
        return commands;
    }

//    private void setCommands(String commands) {
//        this.commands.add(commands);
//    }

    @Override
    public String toString() {
        return "Animal {" +
                "name = '" + name + '\'' +
                ", commands = " + commands.toString() +
                '}';
    }
}
