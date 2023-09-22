package LAB2;

public class ContBancar {
    private double _sold = 0.0;

    public ContBancar(double sold)
    {
        this._sold=sold;
    }
    public void depozitareSuma(double sum)
    {
        this._sold+=sum;
    }
    public boolean RetragereSuma(double sum)
    {
        if(sum>this._sold)
            return false;
        sum-=this._sold;
        return true;
    }
    @Override
    public String toString()
    {
        String output = "Your budget is " + this._sold + "\n" ;
        return output;
    }
}
