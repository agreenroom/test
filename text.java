import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =0;
        while(i<4){
            String message = sc.nextLine();
            System.out.println("hello, i'm "+message);
            i++;
        }
    }
}
