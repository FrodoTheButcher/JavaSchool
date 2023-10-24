public class Persoana {
    private String nume,prenume,CNP;

    public Persoana(String nume,String prenume,String CNP)
    {
        this.nume = nume;
        this.CNP = CNP;
        this.prenume = prenume;
    }
    public void setNume(String nume)
    {
        this.nume=nume;
    }
      public void setPrenume(String prenume)
    {
        this.prenume=prenume;
    }  public void setCNP(String cnp)
    {
        this.CNP=CNP;
    }

    public String getNume()
    {
        return this.nume;
    }
     public String getPrenume()
    {
        return this.prenume;
    }
     public String getCNP()
    {
        return this.CNP;
    }
}
