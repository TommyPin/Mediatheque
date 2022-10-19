package mediatheque.test;

import mediatheque.metier.Adherent;
import mediatheque.metier.Carte;
import mediatheque.metier.Personne;
import mediatheque.metier.Ressource;

import java.time.LocalDate;
import java.time.format.TextStyle;

public class ScenarioPersonne
{
    public static void main(String[] args)
    {
        //Déclaration et instanciation d'une personne.
        Personne p1 = new Personne("PINAY", "Tommy");
        // Attribution d'une identité à la personne.
        p1.setPrenom("Tommy");
        p1.setNom("Pi");
        p1.setDateNaissance(LocalDate.of(1993, 07, 03));
        p1.setDateNaissance(LocalDate.parse("1993-07-03"));
        p1.marcher();

        //Création d'une autre personne.
        Personne p2 = new Personne("PONSONNET", "Matthieu", "1995-07-03");
        System.out.println("L'année de naissance de p2 est : " + p2.getDateNaissance().getYear());

        // Création d'une ressource
        Ressource r1 = new Ressource("Tintin au Tibet");
        System.out.println("Mon livre s'appelle " + r1.getTitre() );

        //Calcul du nombre d'années entre 2 dates
        System.out.println(Personne.getNbAnnees(LocalDate.parse("1918-11-11"), LocalDate.now()));

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

        // Affichagede l'identifiant de la carte
        System.out.println(carte1.getIdentifiant());

        // Création de 100 cartes
        for (int i = 1 ; i <= 100 ; i ++)
        {
            Carte c = new Carte(p1);
            System.out.println(c.getIdentifiant());
        }
    }
}
