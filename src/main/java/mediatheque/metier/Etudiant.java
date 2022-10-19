package mediatheque.metier;

public class Etudiant extends Adherent
{
    private Universite campus;

    public Universite getCampus()
    {
        return campus;
    }

    public void setCampus(Universite campus)
    {
        this.campus = campus;
    }

    public Etudiant(String nom, String prenom, String dateNaissance, Universite campus)
    {
        super(nom, prenom, dateNaissance);
        setCampus(campus);
    }

    public Location louer (Ressource ressource)
    {
        System.out.println("Location gratuit de " + ressource + " par " + this);
        return null;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + getAge() + " " + getCampus();
    }
}
