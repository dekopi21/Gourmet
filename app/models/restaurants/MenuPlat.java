package models.restaurants;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "menuPlat")
public class MenuPlat extends Model {
  /**
   *
   */
  @Required
  private Menu menu;
  /**
   *
   */
  @Required
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
}
