public class Parrot extends Bird implements Prey{

    public Parrot(int row, String name, int age, String animalSpecial, int heightFly) {
        super(row, name, age, animalSpecial, heightFly);
    }

    @Override
    public String getName() {
        return name;
    }
    
}
