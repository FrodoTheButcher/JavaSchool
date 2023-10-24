public class ListaDiscipline{

    public Vector<Disciplina> discipline;
    private Vector<Teme> teme;

    

    public ListaDiscipline(){}

    public Vector<Disciplina> getDiscipline()
    {
        return this.discipline;
    }

    public void adaugareDisciplina(String denumire,String cadru,int Nota)
    {
        this.discipline.add(new Disciplina(denumire, cadru, Nota));
    }

    public void adaugareTema(String name,int Punctaj)
    {
        this.teme.add(new Teme(name, Punctaj));
    }
}