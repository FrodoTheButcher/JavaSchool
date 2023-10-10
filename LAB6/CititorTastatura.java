package LAB6;

import java.util.Scanner;

public class CititorTastatura {
    private String Message;
    private String Source;

    public CititorTastatura(String Message,String Source)
    {
        this.Message = Message;
        this.Source =Source;
    }

    public void citesteTastatura()
    {
        Scanner scn = new Scanner(System.in);
        this.Message = scn.nextLine();
        this.Source = scn.nextLine();
        scn.close();
    }

    public String getMessage()
    {
        return this.Message;
    }
}
