package LAB4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SingleTonLogging {
    
    private static SingleTonLogging singletonInstance;
    private int numberOfErrors = 0;
    private final static String ServerError = "ServerError";
    private final static String InvalidData = "InvalidData";
    private final static String Success = "Success";
    private FileWriter writer;

    private SingleTonLogging() {
    }

    public static SingleTonLogging getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingleTonLogging();
        }
        return singletonInstance;
    }


    public void startLogging(String filepath)
    {
        try{
        writer =  new FileWriter(filepath);
        }
        catch(IOException e)
        {
           e.printStackTrace();
        }
        numberOfErrors++;
    }
    public void stopLogging(String filepath)
    {
        try{
        writer.close();
        }
        catch(IOException e)
        {
           e.printStackTrace();
        }
        numberOfErrors++;
    }
    public void writeErrorToFile(String typeOfError) {
        try {
            if ("200".equals(typeOfError)) {

                writer.write("Type 200 Error: " + Success +  "\n");
            } 
            else if ("400".equals(typeOfError)) {
                writer.write("Type 400 Error: " +  InvalidData + "\n");
            } 
            else if ("500".equals(typeOfError)) {
                writer.write("Type 500 Error: " + ServerError + "\n");
            } 
            else {
                writer.write("Unknown Error Type: " + ServerError + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        numberOfErrors++;
    }

    public void writeErrorToFile(String typeOfError, Exception e) {
        try {
            if ("200".equals(typeOfError)) {

                writer.write("Type 200 Error: " + e.toString() + "\n");
            } 
            else if ("400".equals(typeOfError)) {
                writer.write("Type 400 Error: " + e.toString() + "\n");
            } 
            else if ("500".equals(typeOfError)) {
                writer.write("Type 500 Error: " + e.toString() + "\n");
            } 
            else {
                writer.write("Unknown Error Type: " + e.toString() + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         numberOfErrors++;
    }
    public int getCountErrors(){
        return this.numberOfErrors;
    }
}
