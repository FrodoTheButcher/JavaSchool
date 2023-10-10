package LAB3;

public class Planta {

    private String SursaProvenienta;
    private int ZileTimpDeLaCulegere;//zile

    public String Nume;
    public Double Cost;
    public Planta(String Nume)
    {
        this.Nume=Nume;
        this.Cost=0.0;
    }
    public Planta(Double Cost)
    {
        this.Nume="Not Selected";
        this.Cost=Cost;
    }

    public Planta(String Nume,Double Cost,String SursaProvenienta,int ZileTimpDeLaCulegere)
    {
        this.Nume=Nume;
        this.Cost=Cost;
        this.SursaProvenienta=SursaProvenienta;
        this.ZileTimpDeLaCulegere=ZileTimpDeLaCulegere;
    }
    public void SetSursaProvenienta(String SursaProvenienta)
    {
        this.SursaProvenienta=SursaProvenienta;
    }
    public void SetZileTimpDeLaCulegere(int ZileTimpDeLaCulegere)
    {
        this.ZileTimpDeLaCulegere=ZileTimpDeLaCulegere;
    }
    public String GetSursaProvenienta()
    {
        return this.SursaProvenienta;
    }
    public int GetZileTimpDeLaCulegere()
    {
        return this.ZileTimpDeLaCulegere;
    }
    
    public void DisplayPrivateContepts()
    {
        System.out.println("Sursa provenienta reprezinta tara din care este culeasa planta.Zile timp de la culegere,timpul decurs de la culegere");
    }
     public void DisplayPublicContepts()
    {
        System.out.println("Nume reprezinta denumirea plantei si cost va fi costul ei");
    }

    @Override
    public String toString() 
    {
        String resp = "Our plant named "+this.Nume + " costs " + this.Cost + "$";
        return resp;
    }

}
