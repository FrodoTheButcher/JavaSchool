package LAB3;

import java.util.Scanner;

public class Cerc {
    private Double raza;
    public void SetRaza(Double Raza)
    {
        this.raza=Raza;

    }

    public Double GetRaza()
    {
        return this.raza;
    }

    public Double CalcArie()
    {
        return Math.PI*(this.raza*this.raza);
    }
    public Double CalcPer()
    {
        return 2*Math.PI*this.raza;
    }

    public static void main(String[] args)
    {
        Cerc cerc = new Cerc();
        Scanner scn = new Scanner(System.in);
        Double raza = scn.nextDouble();
        cerc.SetRaza(raza);
        System.out.println(cerc.CalcArie() + " " + cerc.CalcPer());
    }
}
