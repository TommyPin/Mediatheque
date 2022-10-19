package mediatheque.metier;

import java.time.LocalDate;
import java.time.Period;

public class Personne
{
    // Propriétés
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Carte carte;

    // Méthodes

    // Constructeur
    public Personne (String nom, String prenom)
    {
        setNom(nom);
        setPrenom(prenom);
        // Création d'une carte et placement de celle-ci dans la poche de la personne
        setCarte(new Carte (this));
    }

    public Personne (String nom, String prenom, String dateNaissance)
    {
        this (nom, prenom); // ==> setNom(nom); setPrenom(prenom);
        setDateNaissance(LocalDate.parse(dateNaissance));
    }

    public Personne(Carte carte)
    {
        this.carte = carte;
    }

    // Accesseurs en lecture
    public String getNom()
    {
        if (nom != null)
        {
            return nom.toUpperCase();
        }
        else
        {
            return null;
        }

    }

    public String getPrenom()
    {
        return prenom;
    }

    public LocalDate getDateNaissance()
    {
        return dateNaissance;
    }

    public Carte getCarte()
    {
        return carte;
    }

    // Accesseurs en écriture
    public void setNom(String nom)
    {
        if (nom.length() >= 3)
        {
            this.nom = nom;
        }
        else
        {
            System.out.println("La proposition " + nom + " est invalide.");
        }
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public void setDateNaissance(LocalDate dateNaissance)
    {
        this.dateNaissance = dateNaissance;
    }

    public void setCarte(Carte carte)
    {
        this.carte = carte;
    }

    public boolean marcher()
    {
        System.out.println(getPrenom() + " " + getNom() + " marche.");
        return true;
    }

    //Méthode renvoyant le nombre d'année entre 2 dates
    public static int getNbAnnees (LocalDate date1, LocalDate date2)
    {
        Period periode = Period.between(date1, date2);
        return periode.getYears();
    }

    // Méthode renvoyant l'âge d'une personne
    public int getAge ()
    {
        //return Period.between(getDateNaissance(), LocalDate.now()).getYears();
        return getNbAnnees(getDateNaissance(), LocalDate.now());
    }

    @Override
    public String toString()
    {
        // Le comportement de toString dans Objet ne convient pas pour les personnes.
        // On souhaite alors récupérer le nom et le prénom
        return getPrenom() + " " + getNom();
    }
}