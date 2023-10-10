package LAB3;

import java.util.Vector;

public class Student {
    private String StudentId,StudentName;
    private Vector<Double> note=new Vector<>();

    public void SetId(String Id)
    {
        this.StudentId = Id;   
    }
    public void SetName(String Name){
        this.StudentName = Name;
    }

    public String getName()
    {
        return this.StudentName;
    }
    public String getId()
    {
        return this.StudentId;
    }

    public void AddGrade(Double grade)
    {
        if(grade>=1.0 && grade <= 10.0)
        {
            this.note.add(grade);
        }
        else
        {
            System.out.println("Grade invalid!");
        }
    }
}
