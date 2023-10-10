import java.util.Scanner;

public class ex1si2{

    public static void main(String[] args)
    {
        int x,y;
        Scanner scn = new Scanner(System.in);
        x=scn.nextInt();
        y=scn.nextInt();
        
        //int x = Integer.parseInt(args[0]);
        //int y = Integer.parseInt(args[1]) ;

        System.out.println(x+y + " "+ x*y + " "+ Math.random()*x+" "+Math.random()*y);
        
    }

};