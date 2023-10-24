public class Disciplina {
    private String denumire;
    private String cadruDidactic;
    private int nota;

    public Disciplina(){}

    public Disciplina(String denumire,String cadru,int nota)
    {
        this.nota=nota;
        this.denumire=denumire;
        this.cadruDidactic=cadru;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCadruDidactic() {
        return cadruDidactic;
    }

    public void setCadruDidactic(String cadruDidactic) {
        this.cadruDidactic = cadruDidactic;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
