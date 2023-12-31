public class Mammall extends Animal {

    int speed;
    public Mammall(int row, String name, int age, String animalSpecial,int speed) {
        super(row, name, age, animalSpecial);
        this.speed = speed;
    }
    @Override
    void show() {
        System.out.println(row+".name: "+name+", age: "+age+", speed: "+speed+", animal special: "+animalSpecial);
    }
    
}
