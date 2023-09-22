package LAB2;

import java.util.Scanner;

public class MasinaMain {
    public static void Main(String[] args)
    {
        Masina masina = new Masina();
        masina.setCuloare("rosu");
        masina.setTip("curse");
        masina.setViteza(300.0);

        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();

        Masina[] masini = new Masina[n];
    }
}
