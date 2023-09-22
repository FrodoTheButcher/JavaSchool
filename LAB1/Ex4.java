import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args)
    {
        double x;
        Scanner scn = new Scanner(System.in);
        x = scn.nextInt();

        System.out.println(Math.sin(x) + " " + Math.cos(x) + " "+ Math.sqrt(x));
    }      
}
