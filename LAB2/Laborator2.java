package LAB2;

import java.util.Scanner;

public class Laborator2{

    public static void main(String[] args)
    {
        //ex1
        /*ContBancar contBancar = new ContBancar(10.5);
        Scanner scn = new Scanner(System.in);
        contBancar.depozitareSuma(scn.nextDouble());
        contBancar.depozitareSuma(scn.nextDouble());*/

        //ex2
        ContBancar contBancar2 = new ContBancar(500);
        contBancar2.depozitareSuma(300);
        System.out.println(contBancar2.toString());
        int n =(int)Math.round(Math.random()*10);
        int i=0;
        for(;i<n/2;i++)
        {
            double operation =Math.floor(Math.random() * 100);
            contBancar2.depozitareSuma(operation);
        }
        for(;i<n;i++)
        {
            double operation =Math.floor(Math.random() * 100);
           boolean canRetrieve = contBancar2.RetragereSuma(operation);
           if(canRetrieve == false)
            break;
        }
    }

}