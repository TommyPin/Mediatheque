package mediatheque.metier;

public class Carte
{
    private Personne proprietaire;
    private String identifiant;
    private static int compteur;

    public Carte(String identifiant)
    {
        this.identifiant = identifiant;
    }

    //Une carte doit obligatoirement disposer d'un propriétaire
    public Carte (Personne proprietaire)
    {
        setProprietaire(proprietaire);
        // La carte en cours de création est mise automatiquement et immédiatement dans la poche de son propriétaire
        proprietaire.setCarte(this);

        // Autogénération de l'identifiant de la carte
        compteur++;
        setIdentifiant("CART" + compteur);
    }

    public String getIdentifiant()
    {
        return identifiant;
    }

    public Personne getProprietaire()
    {
        return proprietaire;
    }

    private void setIdentifiant(String identifiant)
    {
        this.identifiant = identifiant;
    }

    public void setProprietaire(Personne proprietaire)
    {
        this.proprietaire = proprietaire;
    }
}
