package mediatheque.metier;

import tommy.utils.Toolbox;

import javax.tools.Tool;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Adherent extends Personne
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

    public Adherent(String nom, String prenom, String dateNaissance) throws Exception
    {
        // Appel du constructeur parent
        // On lui passe les informations reçues. Il sait comment les traiter.
        super(nom, prenom, dateNaissance);
    }

    public abstract Location louer (Ressource ressource);

    public static ArrayList<Adherent> load() throws Exception
    {
        ArrayList<Adherent> annuaire = new ArrayList<Adherent>();

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

            // On place le retraité dans la liste
            annuaire.add(retraite);
        }

        // Fermeture de la connexion
        cnx.close();
        return annuaire;
    }
    public static Adherent getAdherentAleatoire() throws Exception
    {
        LocalDate dateAleatoire = Toolbox.getRandomLocalDate(1937, 2021);
        String suffixe = dateAleatoire.toString().replace("-", "");

        Adherent adh = new Actif ("Nom" + suffixe
                                    , "Prenom" + suffixe
                                    , dateAleatoire.toString()
                                    , new Entreprise("SAVOYE"));

        return adh;
    }

}
