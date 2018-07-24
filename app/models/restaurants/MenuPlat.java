package models.restaurants;

import play.data.validation.Required;
import play.db.jpa.JPABase;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menuPlat")
public class MenuPlat extends Model {
  /**
   *
   */
  @Required
  @ManyToOne
  private Menu menu;
  /**
   *
   */
  @Required
  @ManyToOne
  private Plat plat;

  public MenuPlat() {
  }

  public MenuPlat(Menu menu, Plat plat) {
    this.menu = menu;
    this.plat = plat;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Plat getPlat() {
    return plat;
  }

  public void setPlat(Plat plat) {
    this.plat = plat;
  }

  public static String findMenuById(Menu menu){
    return menu.getLibelle();
  }

  public static String findPlatById(Plat plat){
    return plat.getDescription();
  }


}
