package mediatheque.metier;

public class Ressource
{
    // Propriétés
    private String titre;

    // Constructeurs
    public Ressource(String titre)
    {
        this.titre = titre;
    }

    // Accesseurs en lecture
    public String getTitre()
    {
        return titre;
    }

    // Accesseurs en écriture
    public void setTitre(String titre)
    {
        this.titre = titre;
    }

    @Override
    public String toString()
    {
        return getTitre();
    }
}
