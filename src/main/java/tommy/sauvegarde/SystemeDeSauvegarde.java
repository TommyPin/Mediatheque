package tommy.sauvegarde;

import java.util.ArrayList;

public class SystemeDeSauvegarde
{
    private ArrayList<Recordable> liste;
    private static SystemeDeSauvegarde instance;

    private SystemeDeSauvegarde()
    {
        //Initialisation de la liste
        liste = new ArrayList<>();
    }

    /**
     * Cette méthode permet de ne retourner un sigleton (ne tourne qu'une unique instance de la classe)
     * @return
     */
    public static SystemeDeSauvegarde getInstance()
    {
        // On créé le système de sauvegarde s'il n'a pas déjà été créé
        // Sinon on renvoie l'instance créé précédemment
        if ( instance == null )
        {
            instance = new SystemeDeSauvegarde();
        }
        return instance;
    }

    public ArrayList<Recordable> getListe()
    {
        return liste;
    }

    public void setListe(ArrayList<Recordable> liste)
    {
        this.liste = liste;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean sauvegarder() throws Exception
    {
        // On parcourt la liste des éléments enregistrables
        for (Recordable rec : liste)
        {
            // On invoque la méthode "save" sur chacun d'eux
            rec.save();
        }
        return true;
    }

    /**
     *
     * @param recordable
     * @return
     */
    public boolean addRecordable (Recordable recordable)
    {
        return liste.add(recordable);
    }
}