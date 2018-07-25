package models.restaurants;


import models.Commandes.LigneCommande;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
@Entity
@Table(name = "menu")
public class Menu extends Model {

  /**
   *
   */
  @Required
  @MaxSize(30)
  private String libelle;

  public Menu(String libelle, TypeMenu typeMenu, List<Restaurant> restaurants) {
    this.libelle = libelle;
    this.calendrie = new GregorianCalendar();
    this.typeMenu = typeMenu;
    this.restaurants = restaurants;
  }

  /**

   *
   */
  @Required
  private GregorianCalendar calendrie;
  /**
   *
   */
  @Required
  @ManyToOne
  private TypeMenu typeMenu;
  /**
   *
   */
  @Required
  @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
  private List<Restaurant> restaurants;



  public Menu() {
  }

  public Menu(String libelle, TypeMenu typeMenu) {
    this.libelle = libelle;
    this.calendrie = new GregorianCalendar();
    this.typeMenu = typeMenu;
    this.restaurants = new ArrayList<Restaurant>();
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Calendar getCalendrie() {
    return calendrie;
  }

  public void setCalendrie(GregorianCalendar calendrie) {
    this.calendrie = calendrie;
  }

  public TypeMenu getTypeMenu() {
    return typeMenu;
  }

  public void setTypeMenu(TypeMenu typeMenu) {
    this.typeMenu = typeMenu;
  }

  public String findLibelleById(TypeMenu typeMenu) {
    return typeMenu.getLibelle();
  }
}
