public class Cheetah extends Mammall implements Hunter{

    public Cheetah(int row, String name, int age, String animalSpecial, int speed) {
        super(row, name, age, animalSpecial, speed);
    }

    @Override
    public void hunt(Prey prey) {
        System.out.println(name+" hunted "+prey);
    }
}
