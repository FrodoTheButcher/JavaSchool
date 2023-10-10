package LAB3;

import java.util.HashMap;
import java.util.Vector;

public class Semafor {
    public HashMap<String,Double> CuloareSiDurata;
    public String CurrentColor;

    public Semafor()
    {
        this.CurrentColor = "Rosu";
        this.CuloareSiDurata.put("Rosu",50.5);
        this.CuloareSiDurata.put("Galben",30.5);
        this.CuloareSiDurata.put("Verde",50.5);
    }

    public  boolean ValidateIfContaintsColor(String color){
        
        if(this.CuloareSiDurata.containsKey(color))
            return true;
        return false;
    }

    public void SetTheColor(String color)
    {
      this.CurrentColor = this.CurrentColor == "Rosu" ?  "Galben" :  this.CurrentColor == "Galben" ? "Verde" : "Rosu";
    }

    public Double getTimeOfColor(String Color)
    {
        return this.CuloareSiDurata.get(Color);
    }
}
