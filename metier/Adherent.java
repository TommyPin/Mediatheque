package mediatheque.metier;

import String;
import LocalDate;
import Location;

public abstract class Adherent extends Personne {

  public String numero;

  public LocalDate dateAdhesion;

  public abstract Location louer( res);

}