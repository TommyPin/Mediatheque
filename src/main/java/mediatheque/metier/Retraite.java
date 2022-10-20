package mediatheque.metier;

public class Retraite extends Adherent
{
    public Retraite(String nom, String prenom, String dateNaissance) throws Exception
    {
        super(nom, prenom, dateNaissance);
    }

    @Override
    public Location louer (Ressource ressource)
    {
        System.out.println("Location plein tarif de " + ressource + " par " + this);
        return null;
    }
}
