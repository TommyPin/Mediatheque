package mediatheque.test;
import java.time.LocalTime;
import java.time.Year;

public class TestSyntaxe
{
    /**
     *  Methode destiné à faire une salutation simple
     *  Elle affiche également l'heure courante
     */
    public static void saluer()
    {
        System.out.println("Bonjour Monsieur");
        System.out.println("Il est actuellement " + LocalTime.now());
    }

    /**
     *
     * @param rayon
     * Rayon du cercle
     * @return
     */
    public static double calculerPerimetreCercle(double rayon)
    {
        return 2 * Math.PI * rayon;
    }

    /**
     *
     * @param nom
     * Nom de famille de la personne à saluer
     * @param genre
     * Genre de la personne à saluer
     * Cette méthode affiche une sulation personnalisée
     */
    public static void saluerPersonneGenre (String nom, int genre)
    {
        System.out.println("Bonjour " + ((genre == 1) ? "Monsieur " : "Madame ") + nom);
    }

    public static void main(String[] args)
    {
        // Déclarer et définir une variable (==> Espace mémoire dans laquel on va stocker une valeur primitive)
        int compteur;
        compteur = 20;
        System.out.println("Le compteur vaut : " + compteur);

        // Déclaration et valorisation d'une constante
        final boolean SUCCES = true; // La valeur est bloquée et ne peut jamais changer !
        System.out.println("Cette valeur est toujours VRAIE : " + SUCCES);

        // Réalisation d'un test
        // Utilisation d'opérateurs de comparaison : >, >=, <, <=, ==, !=, !
        // utilisation d'opérateurs logique : && (ET logique) et || (OU logique)
        if (compteur >= 100 && SUCCES)
        {
            System.out.println("Le compteur a une valeur importante.");
        }
        else
        {
            System.out.println("Le compteur est faible.");
        }

        // Traitement itératif
        // 1. On connaît à l'avance le nombre d'itérations.
        // Exemple : Afficher une table de multiplication
        for (int i = 1; i < compteur ; i++)
        {
            // On ignore le traitement de la valeur 5
            if (i == 5) continue;
            System.out.println(i + "x 7 = " + i * 7);
        }

        // 2. On ne connaît pas à l'avance le nombre d'itérations.
        // Exemple :Afficher les 4 premières années bisextiles après 1857
        Year annee = Year.of(1837);
        int nbAnneeBissextilesTrouvees = 0;
        while (nbAnneeBissextilesTrouvees < 4)
        {
            if (annee.isLeap())
            {
                System.out.println(annee);
                nbAnneeBissextilesTrouvees++;
            }
            //On passe à l'année suivante
            annee = annee.plusYears(1);
        }

        // 3. On ne connaît pas à l'avance le nombre d'itérations.
        // On passera au moins 1 fois dans la boucle.
        double valeur = 1234567.0;
        do
        {
            System.out.println(valeur);
            valeur = valeur / Math.PI;
        }
        while (valeur >= 3);

        // Traitement au cas par cas.
        // Afficher le nombre de jours d'un mois précis
        int moisCourant = 10;
        switch(moisCourant)
        {
            case 1:
                System.out.println("31 jours");
                break;
            case 4:
                System.out.println("30 jours");
                break;
            case 10:
                System.out.println("31 jours");
                break;
            default:
                System.out.println("Nombres de jours inconnu.");
        }

        // Tableaux
        // Ensemble de données de même valeurs avec capacité fixe et un index commençant par 0
        String joursDeLaSemaine[] = {"Lundi", "Mardi", "Mercredi"};
        System.out.println(joursDeLaSemaine[1]);

        String[] codesPostaux = new String[40000];
        for (Integer i = 0; i < 40000 ; i++)
        {
            // Les trois solutions ci-dessous fonctionnent :

            //1.
            // Integer dixMille = 10000;
            // Integer resultat = i + dixMille;
            // codesPostaux[i] = resultat.toString();

            //2.
            // codesPostaux[i] = String.valueOf(i+10000);

            //3.
            codesPostaux[i] = i + 10000 + "";
        }
        System.out.println(codesPostaux[1]);

        // Tableaux à double entrée (matrice)
        String[][] annuaire = new String[21][4];
        annuaire[1][3] = "2001-01-02";
        annuaire[20][0] = "N21";
        System.out.println(annuaire[1][2]);

        // Affichage de tous les jours de la semaine
        for (String unJour : joursDeLaSemaine )
        {
            System.out.println(unJour);
        }

        // Invocation de la méthode "saluer"
        saluer();

        // Invocation de la méthode "calculerPerimetreCercle"
        System.out.println(calculerPerimetreCercle(12));

        //Créer une procédure qui accepte une salutation avec le nom de la personne et son genre
        saluerPersonneGenre("Dupont", 1);
        saluerPersonneGenre("Durand", 2);
    }
}