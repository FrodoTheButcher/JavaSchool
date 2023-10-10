package LAB4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.sound.sampled.Line;

public class Persoane {
    
    private static final String List = null;

    public static void main(String[] args)
    {
        Vector<Persoana> vector = new Vector<Persoana>(0);
        vector.add(new Persoana("Ionel",15));
        vector.add(new Persoana("Marcel",15));
        vector.add(new Persoana("Doja",12));
        vector.add(new Persoana("GHOEHRGE",80));

        int sum = 0;
        for(Persoana pers:vector)
        {
            sum+=pers.getVarsta();
        }
        //varsta medie
        System.out.println(sum/vector.size());


        //stocare de n siruri de caractere
        String sir;
        int n;
        Scanner scn = new Scanner(System.in);
        Vector<String>list = new Vector<>();
        n=scn.nextInt();
        for(int i=0;i<=n;i++)//<= pt ca se citeste enter dupa ce citesti n-ul ca string
        {
            sir=scn.nextLine();
            list.add(sir);
        }
        for(String str:list)
        {
            System.out.println(str);
        }

        
    }

}
