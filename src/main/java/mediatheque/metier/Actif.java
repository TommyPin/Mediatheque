package mediatheque.metier;

import tommy.sauvegarde.Recordable;
import tommy.sauvegarde.SystemeDeSauvegarde;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Actif extends Adherent implements Recordable
{
    private Entreprise employeur;

    public Actif(String nom, String prenom, String dateNaissance, Entreprise employeur) throws Exception
    {
        super(nom, prenom, dateNaissance);
        setEmployeur(employeur);

        // Autoabonnement des actifs
        SystemeDeSauvegarde.getInstance().addRecordable(this);
    }

    public Entreprise getEmployeur()
    {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur)
    {
        this.employeur = employeur;
    }

    @Override
    public Location louer (Ressource ressource)
    {
        System.out.println("Location demi tarif de " + ressource + " par " + this);
        return null;
    }

    @Override
    public boolean save() throws Exception
    {
        System.out.println("Sauvegarde de l'actif " + this + " dans la base de données");

        // Charger le pilote du SGBD en mémoire vive
        Class.forName("org.postgresql.Driver");

        // Obtenir une connexion à partir de l'URL JDBC et des paramètres d'authentification
        String urlJDBC = "jdbc:postgresql://localhost:5432/Mediatheque";
        String user = "postgres";
        String pwd = "kiss";
        java.sql.Connection  cnx = DriverManager.getConnection(urlJDBC, user, pwd);

        // Exécution d'un Statement (objet technique utilisé pour lancer des requêtes)
        Statement st = cnx.createStatement();

        // Permettre la sauvegarde d'un actif dans la table Adherent
        // Copier le contenu de ScenarioConnexion.main dans Actif.save
        // Adapter la requête
        // Ne pas faire "st.executeQuery" mais "st.execute"
        String requete = "insert into adherent values ('"
                + getNom()
                + "','"
                + getPrenom()
                + "','"
                + getDateNaissance().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "');";

        st.execute(requete);

        // Fermeture de la connexion
        cnx.close();

        return true;
    }
}