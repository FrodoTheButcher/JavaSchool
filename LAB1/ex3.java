import java.util.Scanner;

public class ex3 {

    public static int getFirst(int x)
    {
        while(x>10)
            x=x/10;
        return x;
    }
    public static int Sum(int x)
    {
        int s=0;
        while(x!=0)
        {
            s=s+x%10;
            x=x/10;
        }
        return s;
    }
    public static void main(String[] args)
    {
        int x;
        Scanner scn = new Scanner(System.in);
        x=scn.nextInt();

        while(true)
        {
            String question = scn.next();
            if(question.compareTo("a")==0){
                System.out.print(x%2 == 0 ? "par" : "impar") ;
            }
            if(question.compareTo("b")==0){
                System.out.print(getFirst(x)%2 == 0 ? "par" : "impar");
            }
            if(question.compareTo("c")==0){
                System.out.print(Sum(x));
            }            
        }
    }
}
