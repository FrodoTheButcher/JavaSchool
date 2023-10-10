package LAB4;

public class Persoana {
    private String name;
    private int varsta;

    public Persoana(String name,int varsta)
    {
        this.name = name;
        this.varsta = varsta;
    }
    public Persoana()
    {
        this.name = "";
        this.varsta = 0;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setVarsta(int varsta)
    {
        this.varsta=varsta;
    }
    public int getVarsta()
    {
        return this.varsta;
    }
    public String getName()
    {
        return this.name;
    }
}
