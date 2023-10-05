public class Pet extends Animal{


    static String animalType = "Pet";



//    public Pet(String name) {
//        super(name);
//    }


    public Pet(Integer id, String name, String datebirth, String animalType, String commands) {
        super(id, name, datebirth, commands);
        this.animalType = animalType;
    }

    public static String getAnimalType() {
        return animalType;
    }



    public String getInfo() {
        return String.format("Id: %d, Name: %s, datebirth: %s, animalType: %s, commands: %s", super.getId(), super.getName(), super.getDatebirth(), getAnimalType(), super.getCommands());
    }
}
