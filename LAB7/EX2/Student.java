
public class Student extends Persoana {
    public Student(String nume, String prenume, String CNP) {
        super(nume, prenume, CNP);
    }

    private ListaDiscipline listaDiscipline;

    public void adaugareDisciplina(String denumire,String cadru,int Nota)
    {
        this.listaDiscipline.adaugareDisciplina(denumire, cadru, Nota);
    }

    public Double calculMedie()
    {
        Vector<Disciplina> discipline = this.listaDiscipline.getDiscipline();
        Double sum = 0;
        for(Disciplina dis : discipline)
        {
            sum+= dis.getNota();
        }
        return sum/discipline.size();
    }

    @Override
    public String toString()
    {
        return "Acest student are media " + this.calculMedie() + " si se numeste  " + this.getNume() + this.getPrenume()+ " identificat prin "+ this.getCNP();
    }
}
