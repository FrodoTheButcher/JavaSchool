package LAB4;

public class StudentsExercise {
 
    public static void main (String[] args)
    {
        Student std = new Student();
        Student std2 = new Student();
        Student std3 = new Student();
        Student std4 = new Student();
        //constructorul va creste nr de instante la fiecare 
        //noua instanta

        System.out.println(Student.getNumberOfInst());
    }
}
