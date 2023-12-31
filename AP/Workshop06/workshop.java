public class workshop{
    public static void main(String[] args){
        Parrot parrot = new Parrot(1, "parrot", 2, "speak", 20);
        Cheetah cheetah = new Cheetah(2, "cheetah", 3, "fastest", 120);
        Girafe girafe = new Girafe(3, "girafe", 10, "tallest", 20);
        Eagle eagle = new Eagle(4, "eagle", 4, "powerful sight", 120);
        parrot.show();
        cheetah.show();
        girafe.show();
        eagle.show();
        eagle.hunt(parrot);
        cheetah.hunt(girafe);
    }

}