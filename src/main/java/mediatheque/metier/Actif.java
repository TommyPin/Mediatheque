package mediatheque.metier;

public class Actif extends Adherent
{
    private Entreprise employeur;

    public Actif(String nom, String prenom, String dateNaissance, Entreprise employeur)
    {
        super(nom, prenom, dateNaissance);
        setEmployeur(employeur);
    }

    public Entreprise getEmployeur()
    {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur)
    {
        this.employeur = employeur;
    }

    @Override
    public Location louer (Ressource ressource)
    {
        System.out.println("Location demi tarif de " + ressource.getTitre() + " par " + this.getNom());
        return null;
    }
}
