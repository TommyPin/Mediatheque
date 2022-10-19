package mediatheque.test;
import mediatheque.metier.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class ScenarioAdherent
{
    public static void main(String[] args)
    {
        // Création d'un adhérent
        Adherent adh1 = new Adherent("DECHAUD", "Nicolas", "1993-01-01");

        // Lui demander la numéro de sa carte
        if (adh1.getCarte() != null)
        {
            System.out.println(adh1.getCarte().getIdentifiant());
        }

        // Lui demander le nom du jour de sa naissance
        System.out.println(adh1.getDateNaissance().getDayOfWeek());
        System.out.println(adh1.getDateNaissance().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));

        // Lui demander de louer le livre "Harry Potter"
        adh1.louer(new Ressource("Harry Potter"));

        // Création d'un actif
        Actif actif1 = new Actif("Murielle", "ROYON", "1980-12-07", new Entreprise("SAVOYE"));

        // Création d'un étudiant
        Etudiant etudiant1 = new Etudiant("Thomas", "CASADEVAL", "2005-11-19", new Universite("TREFILERIE"));

        // Leur demander de louer une ressource
        actif1.louer(new Ressource("Harry Potter 2"));
        etudiant1.louer(new Ressource("Harry Potter 3"));

        // Afficher l'identifiant de la carte de l'étui
        System.out.println(adh1.getCarte().getIdentifiant());
        System.out.println(actif1.getCarte().getIdentifiant());
        System.out.println(etudiant1.getCarte().getIdentifiant());

        System.out.println(adh1);

        // La conversion d'une ressource en String (utilisation de la fonction dans public String toString() )
        System.out.println(new Ressource("ASSE"));

        // La conversion d'un étudiant en String = nom, prenom, age, campus
        System.out.println(etudiant1);

        // Gestion d'un tableau d'adhérents
        Adherent[] annuaire = new Adherent[10];
        annuaire[0] = adh1;
        annuaire[1] = actif1;
        annuaire[2] = etudiant1;

        // On demande au tableau de nous fournir l'un de ces éléments
        Adherent annuaireRang2 = annuaire[2];
        annuaireRang2.louer(null);

        if (annuaireRang2.getClass().getSimpleName().equals("Etudiant"))
        {
            System.out.println(((Etudiant) annuaireRang2).getCampus());
        }

        // Afficher le nom et le prénom de l'élément situé au rang 1
        Object[] elements = new Object[10];
        elements[0] = adh1;
        elements[1] = actif1.getEmployeur();
        elements[2] = etudiant1;
        elements[3] = etudiant1.getCarte();

        if (elements[2] instanceof Personne)
        {
            Personne pres1 = (Personne) elements[2];
            System.out.println(pres1.getNom() + " " + pres1.getPrenom());
        }

        // On a toujours le droit de regarder un objet comme s'il était issu d'une de ses classes parentes
        Adherent actif2 = new Actif("Frédéric", "SUZAT", "1960-09-12", new Entreprise("SAVOYE"));
        Personne actif3 = new Actif("Frédéric", "SUZAT", "1960-09-12", new Entreprise("SAVOYE"));
        Object actif4 = new Actif("Frédéric", "SUZAT", "1960-09-12", new Entreprise("SAVOYE"));

        // adherentRang2 = etudiant1 même si ce n'est pas la même Classe
        System.out.println(annuaireRang2.equals(etudiant1));
        Etudiant etudiant2 = etudiant1 ;
        Adherent adh4 = etudiant2;
        Object obj2 = etudiant1;

        // Déconseillé
        Etudiant etudiant3 = (Etudiant) obj2;
        System.out.println(etudiant3);
    }
}
