package mediatheque.metier;

public class Entreprise
{
    private String employeur;

    public Entreprise(String employeur)
    {
        this.employeur = employeur;
    }

    public String getEmployeur()
    {
        return employeur;
    }

    public void setEmployeur(String employeur)
    {
        this.employeur = employeur;
    }
}
