package mediatheque.test;

import mediatheque.metier.Actif;
import mediatheque.metier.Entreprise;
import mediatheque.metier.Livre;
import tommy.sauvegarde.SystemeDeSauvegarde;

import java.time.LocalDate;

public class ScenarioSauvegarde
{
    public static void main(String[] args) throws Exception
    {
        // Instancier un système de sauvegarde
         SystemeDeSauvegarde sauvegarde = SystemeDeSauvegarde.getInstance();

        // Créer 5 actifs
        LocalDate dateDepart = LocalDate.parse("1993-01-03");
        for (int i = 1 ; i <= 5 ; i++)
        {
            Actif actif = new Actif
                    (
                            "PINAY" + i
                            , "Tommy" + i
                            , dateDepart.plusMonths(1).toString()
                            , new Entreprise("SAVOYE")
                    );

            // Abonnement des actifs aux services du système de sauvegarde
            //sauvegarde.addRecordable(actif);
            // En commentaire puisque l'on a fait l'abonnement dans la classe Actif
        }

        // Créer 5 livres
        for (int i = 1 ; i <= 5 ; i++)
        {
            Livre livre = new Livre("Harry Potter " + i, "123 " + i);

            // Abonnement des livres aux services du système de sauvegarde
            //sauvegarde.addRecordable(livre);
            // En commentaire puisque l'on a fait l'abonnement dans la classe Livre
        }

        // Lancer la sauvegarde
        sauvegarde.sauvegarder();
    }
}
