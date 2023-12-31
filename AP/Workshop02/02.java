import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*get inputs from user*/

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = num1;
        int num4 = num2;
        int temp;
        while(num2 != 0){
           temp = num1 % num2;
           num1 = num2;
           num2 = temp;
        }

        int lcc = (num3*num4)/num1;
        System.out.println("GCD= " + num1);
        System.out.println("LCM= " + lcc);
    }
}