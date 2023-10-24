public class CandyBox {
    private String flavor,origin;

    public CandyBox()
    {
        this.flavor="";
        this.origin="";
    }
    public CandyBox(String flavor, String origin)
    {
        this.flavor=flavor;
        this.origin=origin;
    }
    public Double getVolume()
    {
        return 0.0;
    }
    @Override
    public String toString()
    {
        String rezult = "This candyBox is from "+ this.origin +" and is having the flavour : "+ this.flavor;
        return rezult;
    }
    public String getFlavor()
    {
        return this.flavor;
    }
    public String getOrigin()
    {
        return this.origin;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CandyBox)
        {
            return obj == this;
        }
        return false;
    }
    
}
