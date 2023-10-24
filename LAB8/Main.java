import java.util.Vector;

public class Main {
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        try{
      //  calculator.Add(5.0, null);
       // calculator.Add(10.0, Double.POSITIVE_INFINITY);
        calculator.Add(5.0, Double.NEGATIVE_INFINITY);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("idk");
        }
        
    }
}
