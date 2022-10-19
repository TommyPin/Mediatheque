package mediatheque.metier;

public class Universite
{
    private String campus;

    public Universite(String campus)
    {
        this.campus = campus;
    }

    public String getCampus()
    {
        return campus;
    }

    public void setCampus(String campus)
    {
        this.campus = campus;
    }

    @Override
    public String toString()
    {
        return getCampus();
    }
}
