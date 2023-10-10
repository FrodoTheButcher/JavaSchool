package LAB6;

public class Manager {
    private CititorTastatura cititor;
    private String cool_message;

    public Manager(CititorTastatura cititor)
    {
        this.cititor = cititor;
    }

    public String afiseazaMesaj()
    {
        return this.cititor.getMessage();
    }

    public String citesteMesag()
    {
        this.cititor.citesteTastatura();
        return this.cititor.getMessage();
    }
}

