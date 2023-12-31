import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*get inputs from user*/

        Scanner scanner = new Scanner(System.in);
        int situestion = scanner.nextInt();
        int number = scanner.nextInt();

        if (situestion == 1){
            int num = number;
            int dec_value = 0;
            int base = 1;
            int temp = num;
            while (temp > 0) {
                int last_digit = temp % 10;
                temp = temp / 10;
                dec_value += last_digit * base;
                base = base * 2;
            }
            System.out.println(dec_value);
        }
        else if(situestion==2){
            int[] binaryNum = new int[1000];
            int i = 0;
            while (number > 0) {
                binaryNum[i] = number % 2;
                number = number / 2;
                i++;
            }
            for (int j = i - 1; j >= 0; j--)
                System.out.print(binaryNum[j]);
        }
        else{
            System.out.print("DON'T HAVE THIS ORDER IN MY PROGRAM :)");
        }
    }
}