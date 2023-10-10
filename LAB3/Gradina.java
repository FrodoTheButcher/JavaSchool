package LAB3;

import java.util.Vector;

public class Gradina {
    private int AniVechime;//ani;
    private Double VenitTotalAnual;

    public int NumarMaximFlori;
    public int NumarTotalAngajati;

    public Vector<Planta> plante = new Vector<>();

    public Gradina(int AniVechime,Double VenitTotalAnual,int NumarMaximFlori,int NumarTotalAngajati)
    {
        this.AniVechime = AniVechime;
        this.VenitTotalAnual = VenitTotalAnual;
        this.NumarMaximFlori = NumarMaximFlori;
        this.NumarTotalAngajati = NumarTotalAngajati;
    }
     public Gradina(int AniVechime,int NumarTotalAngajati)
    {
        this.AniVechime = AniVechime;
        this.NumarTotalAngajati = NumarTotalAngajati;
    }

    public void SetAniVechime(int AniVechime)
    {
        this.AniVechime=AniVechime;
    }
    public void SetVenitPrePlantaVanduta(Double VenitTotalAnual)
    {
        this.VenitTotalAnual = VenitTotalAnual;
    }
    public int GetAniVechime(){
        return this.AniVechime;
    }
    public Double GetVenitTotalAnual()
    {
        return this.VenitTotalAnual;
    }

    public void DisplayPrivateContepts()
    {
        System.out.println("Ani Vechime reprezinta vechimea gradinii. Venit Total Anual reprezinta cat castiga gradina din vandut flori");
    }
     public void DisplayPublicContepts()
    {
        System.out.println("NumarMaximFlori  reprezinta numarul/capacitatea  totala de flori din gradina.Angajati reprezinta numarul de oameni ce au grija de flori");
    }

    public void IncreaseCostForSpecificTypeofPlant(String Name,Double CostToAdd)
    {
        for(int i=0;i<plante.size();i++)
        {
            
            Planta plantaObj=plante.elementAt(i);
            if(plantaObj.Nume == Name)
            {
               plantaObj.Cost+=CostToAdd;
            }
        }
    }
    public void MakeDiscountForSpecificPlants(String Name,int discount)
    {
        for(int i=0;i<plante.size();i++)
        {
            Planta plantaObj=plante.elementAt(i);
            if(plantaObj.Nume == Name)
            {
                Double discountAmount = discount/100 * plantaObj.Cost;
               plantaObj.Cost-=discountAmount;
            }
        }
    }

    public void AddPlant(Planta planta)
    {
        this.plante.add(planta);
    }
    @Override
    public String toString() {
        String response ="Our garden is having "+ this.NumarTotalAngajati + " workers taking care of "+ this.plante.size() + " plants \n"; 
        return response;
    }

    public static void main(String[] args)
    {
        Gradina gradina = new Gradina(5, 20);
        Planta planta = new Planta("Lalea", 25.0, "Romania",5);
        gradina.AddPlant(planta);
      System.out.print(gradina.toString());
    }
}


