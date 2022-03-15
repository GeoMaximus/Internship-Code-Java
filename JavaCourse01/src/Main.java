import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int Sum = 0;
        while(true) {
            int x = scanner.nextInt();
            Sum += x;
            System.out.println(Sum);
        }

    }
}
