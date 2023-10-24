public class Baraveli extends CandyBox {
    public Double radius, height;
    public Baraveli(){}
    public Baraveli(String flavor,String origin,Double radius,Double height){
        super(flavor, origin);
        this.radius=radius;
        this.height=height;
    }
    @Override
    public Double getVolume()
    {
        return  Math.PI * Math.pow(radius, 2) * height;
    }

    @Override 
    public String toString()
    {
        return super.toString()+ " and the volume is "+ this.getVolume();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Baraveli)
        {
           return obj == this;
        }
        return false;
    }
}
