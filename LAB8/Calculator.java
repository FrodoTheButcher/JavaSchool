import java.util.Vector;

public class Calculator implements ICalculator {

    private void validateInput(Double x) throws Exception
    {
        if(x==null)
            throw new Exception(ICalculator.NullParameterException);
        if(x<=Double.NEGATIVE_INFINITY)
            throw new Exception(ICalculator.UnderflowException);
        if(x>=Double.POSITIVE_INFINITY)
            throw new Exception(ICalculator.OverflowException);
    }

    @Override
    public Double Add(Double x, Double y) throws Exception {
        this.validateInput(x);
        this.validateInput(y);
        return x+y;
    }

    @Override
    public Double Divide(Double x, Double y) throws Exception {
       this.validateInput(x);
    this.validateInput(y);
        return x/y;
    }

    @Override
    public Double Average(Vector<Double> elements){
        try{
            Double sum=0.0;
            for(int i=0;i<elements.size();i+=2)
            {
                sum+=this.Add(elements.elementAt(i),elements.elementAt(i-1));
            }
            if(elements.size()%2==1)
            {
                sum=this.Add(sum, elements.elementAt(elements.size()-1));
            }
            return this.Divide(sum,(double)elements.size());
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;           
        }
    }

    
}
