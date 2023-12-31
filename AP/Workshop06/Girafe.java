public class Girafe extends Mammall implements Prey{

    public Girafe(int row, String name, int age, String animalSpecial, int speed) {
        super(row, name, age, animalSpecial, speed);
    }

    @Override
    public String getName() {
        return name;
    }
    
}
