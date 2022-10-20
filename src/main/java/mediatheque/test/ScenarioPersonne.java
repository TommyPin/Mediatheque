package mediatheque.test;

import mediatheque.metier.Adherent;
import mediatheque.metier.Carte;
import mediatheque.metier.Personne;
import mediatheque.metier.Ressource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Scanner;

public class ScenarioPersonne
{
    public static void main(String[] args)
    {
        Personne p1 = null;
        try
        {
            //Déclaration et instanciation d'une personne.
            p1 = new Personne("PINAY", "Tommy");
            // Attribution d'une identité à la personne.
            p1.setNom("Pinay");
            p1.setPrenom("Tommy");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        p1.setDateNaissance(LocalDate.of(1993, 07, 03));
        p1.setDateNaissance(LocalDate.parse("1993-07-03"));
        p1.marcher();

        //Création d'une autre personne.
        Personne p2 = null;
        try
        {
            p2 = new Personne("PONSONNET", "Matthieu", "1995-07-03");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("L'année de naissance de p2 est : " + p2.getDateNaissance().getYear());

        // Création d'une ressource
        Ressource r1 = new Ressource("Tintin au Tibet");
        System.out.println("Mon livre s'appelle " + r1.getTitre() );

        boolean erreur = false;
        do
        {
            try
            {
                //Calcul du nombre d'années entre 2 dates
                System.out.println("Veuillez saisir la date de l'armistice 1918");
                Scanner scanner = new Scanner (System.in);
                String saisie = scanner.nextLine();
                System.out.println(Personne.getNbAnnees(LocalDate.parse(saisie), LocalDate.now()));
                erreur = false;
            }
            catch (DateTimeException dte)
            {
                System.out.println("Veuillez renseigner une date sous le format YYYY-MM-DD");
                erreur = true;
            }
        }
        while (erreur);

        // Afficher l'âge des personnes
        System.out.println( p1.getAge() );
        System.out.println( p2.getAge() );

        // Afficher la carte d'une personne p1 et mettre la carte dans sa poche
        //p1.setCarte(new Carte("Tommy"));
        Carte carte1 = new Carte("Tommy");
        p1.setCarte(carte1);

        // On met la carte dans la poche de p2
        carte1 = new Carte(p1);

        // Afficher le mois de naissance du propriétaire p1 de la carte
        System.out.println(carte1.getProprietaire().getDateNaissance().getMonth());

        // Affichage de l'identifiant de la carte
        System.out.println(carte1.getIdentifiant());

        // Création de 100 cartes
        for (int i = 1 ; i <= 100 ; i ++)
        {
            Carte c = new Carte(p1);
            System.out.println(c.getIdentifiant());
        }
    }
}
