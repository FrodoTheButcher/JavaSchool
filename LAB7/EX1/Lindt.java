public class Lindt extends CandyBox {
    
    private Double length,width,height;
    public Lindt(){}
    public Lindt(Double length,Double width,Double height, String flavor,String origin){
        super(flavor, origin);
        this.length=length;
        this.height=height;
        this.width=width;
    }
    @Override 
    public Double getVolume()
    {
        return length*width*height;
    }
    @Override 
    public String toString()
    {
        return super.toString()+ " and the volume is "+ this.getVolume();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lindt)
        {
           return obj == this;
        }
        return false;
    }
}
