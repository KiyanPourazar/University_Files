public class Eagle extends Bird implements Hunter {

    public Eagle(int row, String name, int age, String animalSpecial, int heightFly) {
        super(row, name, age, animalSpecial, heightFly);
    }

    @Override
    public void hunt(Prey prey) {
        System.out.println(name+" hunted "+prey);
    }
    
}
