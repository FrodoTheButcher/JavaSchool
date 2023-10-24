import java.util.Vector;

public class Magazin implements IMagazin {

    public Vector<Double> Sells=new Vector<Double>();
    public String locatie;
    public Double rating;
    
    public Magazin(String locatie,Double rating)
    {
        this.oras=oras;
        this.rating=rating;
    }
    
        @Override
     public Double calcuareProfit(){
        Double amount = 0.0;
        for(Double sel : Sells)
        {
            amount+=sel;
        }
        return amount/Sells.size();
     }
     @Override
    public void inserareVanzareNoua(String money){
        Sells.add(money);
    }
}
