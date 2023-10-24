public class Student implements IStudent {
    private Vector<Double> note=new Vector<Double>();
    private String nume,prenume;

    public Student(String nume,String prenume)
    {
        this.nume=nume;
        this.prenume=prenume;
    }

    public Double calculareMedie(){
        Double amount = 0.0;
        for(Double not:note)
        {
            amount+=not;
        }
        return amount/this.note;
    }
    public void InsertGrade(Double grade){
        this.note.add(grade);
    }
}
