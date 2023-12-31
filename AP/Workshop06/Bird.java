public class Bird extends Animal{
    int heightFly;
    public Bird(int row, String name, int age, String animalSpecial,int heightFly) {
        super(row, name, age, animalSpecial);
        this.heightFly = heightFly;
    }
    @Override
    void show() {
        System.out.println(row+".name: "+name+", age: "+age+", height of fly: "+heightFly+", animal special: "+animalSpecial);
    }
    
}
