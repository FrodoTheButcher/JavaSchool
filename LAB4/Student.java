package LAB4;


//sa se contorizeze numarul de instante
public class Student {
    private static int numberOfInstances=0;

    public Student()
    {
        this.numberOfInstances+=1;
    }
    public static int getNumberOfInst()
    {
        return numberOfInstances;
    }
    public static void increaseNumberOfInstance()
    {
        numberOfInstances+=1;
    }
}
