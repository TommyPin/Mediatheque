package mediatheque.metier;

import java.time.LocalDate;

public class Adherent extends Personne
{
    private LocalDate dateAdhesion;

    public LocalDate getDateAdhesion()
    {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion)
    {
        this.dateAdhesion = dateAdhesion;
    }

    public Adherent(String nom, String prenom, String dateNaissance)
    {
        // Appel du constructeur parent
        // On lui passe les informations reçues. Il sait comment les traiter.
        super(nom, prenom, dateNaissance);
    }

    public Location louer (Ressource ressource)
    {
        System.out.println("Location plein tarif de " + ressource.getTitre() + " par " + this.getNom());
        return null;
    }

}
