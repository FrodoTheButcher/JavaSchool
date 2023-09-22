package LAB2;

public class Masina {
    private String tip;
    private String culoare;
    private double viteza;
    
    
    public void setTip(String tip)
    {
        this.tip=tip;
    }
     public void setCuloare(String culoare)
    {
        this.culoare=culoare;
    }
     public void setViteza(Double viteza)
    {
        this.viteza=viteza;
    }

    public String getTip()
    {
        return this.tip;
    }
    public String getCuloare()
    {
        return this.culoare;
    }
    public Double getViteza()
    {
        return this.viteza;
    }

    public String ToString()
    {
        String output = "Color :" + this.culoare + " Speed "+ this.viteza + " Type" + this.tip + " \n";
        return output;
    }
}


