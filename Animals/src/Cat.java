public class Cat extends Pet{

    public Cat(Integer id, String name, String datebirth, String animalType, String command) {
        super(id, name, datebirth, animalType, command);
    }


    @Override
    public String toString() {
        return "Cat {" +
                "name = " + getName() + '\'' +
                "datebirth = " + getDatebirth() + '\'' +
                ", commands = " + getCommands() +
                '}';
    }
}
