import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String nume,prenume,UNI;
        Scanner scn = new Scanner(System.in);
        nume = scn.next();
        prenume = scn.next();
        UNI = scn.nextLine();
        MasterStudent master = new MasterStudent(nume, prenume,UNI);
    }
}

