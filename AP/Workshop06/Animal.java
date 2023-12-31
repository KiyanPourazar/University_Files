abstract class Animal {
    int row;
    String name;
    int age;
    String animalSpecial;
    public Animal(int row,String name, int age, String animalSpecial){
        this.row = row;
        this.name = name;
        this.age = age;
        this.animalSpecial = animalSpecial;
    }
    abstract void show();
}
