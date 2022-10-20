package mediatheque.metier;

import tommy.sauvegarde.Recordable;
import tommy.sauvegarde.SystemeDeSauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Livre extends Ressource implements Recordable
{
    private String isbn;

    public Livre(String titre, String isbn)
    {
        super(titre);
        this.isbn = isbn;

        // Autoabonnement des livres
        SystemeDeSauvegarde.getInstance().addRecordable(this);
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    @Override
    public boolean save() throws Exception
    {
        System.out.println("Sauvegarde du livre " + this + " dans le fichier livres.csv");

        // Définir le fichier cyble
        File fichier = new File("D://temp//Formation Java//livres.csv");
        //fichier.mkdirs();

        // Création d'un outil Ecriture
        FileWriter writer = new FileWriter(fichier, true);
        BufferedWriter bw = new BufferedWriter(writer);

        // Ecrire la chaîne à placer dans le fichier
        String chaine = getTitre();
        bw.write(chaine);
        bw.newLine();

        // Fermer l'accès au fichier
        bw.close();

        return true;
    }
}
