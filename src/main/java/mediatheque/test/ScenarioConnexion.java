package mediatheque.test;

import mediatheque.metier.Retraite;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class ScenarioConnexion
{
    public static void main(String[] args) throws Exception
    {
        // Charger le pilote du SGBD en mémoire vive
        Class.forName("org.postgresql.Driver");

        // Obtenir une connexion à partir de l'URL JDBC et des paramètres d'authentification
        String urlJDBC = "jdbc:postgresql://localhost:5432/Mediatheque";
        String user = "postgres";
        String pwd = "kiss";
        java.sql.Connection  cnx = DriverManager.getConnection(urlJDBC, user, pwd);

        // Exécution d'un Statement (objet technique utilisé pour lancer des requêtes)
        Statement st = cnx.createStatement();

        // Exécution d'une requête en lecture
        String requete = "select * from adherent";
        ResultSet jeu = st.executeQuery(requete);

        // Traitement des données
        while (jeu.next())
        {
            String nom = jeu.getString("nom");
            String prenom = jeu.getString("prenom");
            Date dateNaissanceBDD = jeu.getDate("dateNaissance");

            LocalDate dateNaissance = dateNaissanceBDD.toLocalDate();

            Retraite retraite = new Retraite(nom, prenom, dateNaissance.toString());
            System.out.println(retraite);
        }

        // Fermeture de la connexion
        cnx.close();
    }
}
