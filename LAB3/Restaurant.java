package LAB3;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    public HashMap<String,Double> CostOfElementFromMenu;
    public HashMap<String,Double> EvaluationOfElementFromMenu;

    public void DeleteFromMenu(String Element){
        CostOfElementFromMenu.remove(Element);
    }

    public void AddToMenu(String Element , Double Cost)
    {
        this.CostOfElementFromMenu.put(Element, Cost);
    }

    public void AddReview(String Element,Double Review){
        this.EvaluationOfElementFromMenu.put(Element, Review);
    }

    public Double CalculateTotal()
    {
        Double total = 0.0;
         for (Map.Entry<String, Double> set :EvaluationOfElementFromMenu.entrySet()) 
             {
                total += set.getValue();
             }
        return total/EvaluationOfElementFromMenu.size();
    }
}
