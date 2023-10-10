package LAB4;

public class LoggerMain {
    
    public static void main(String[] args)
    {
        SingleTonLogging instance = SingleTonLogging.getInstance();
        instance.startLogging("Errors.txt");        

        try{
            int x = 5/0;
            instance.writeErrorToFile("200");
        }
        catch(Exception e)
        {
            instance.writeErrorToFile("500",e);
        }

        try{    
            int[] array = new int[5];
            int value = array[10];
            instance.writeErrorToFile("200");
        }
        catch(Exception e)
        {
            instance.writeErrorToFile("500",e);
        }

        instance.stopLogging("Errors.txt");
    }

}
