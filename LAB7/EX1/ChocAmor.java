public class ChocAmor  extends CandyBox{
    private Double length;
    public ChocAmor(){}
    public ChocAmor(Double Length,String flavor,String origin)
    {
        super(flavor, origin);
        this.length=length;
    }
    @Override
    public Double getVolume()
    {
        return Math.pow(this.length, 3);
    }
    @Override 
    public String toString()
    {
        return super.toString()+ " and the volume is "+ this.getVolume();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChocAmor)
        {
            return obj == this;
        }
        return false;
    }
}
