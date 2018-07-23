package controllers.utilisateurs;

import controllers.CRUD;
import models.Commandes.TypeReglement;
import models.restaurants.Menu;
import models.restaurants.TypeMenu;

import java.util.List;

public class Administrateurs extends CRUD{
    public static void crudAdmin(){
        List<TypeReglement> typeReglementList = TypeReglement.findAll();
        List<Menu> menus = Menu.findAll();
        List<TypeMenu> typeMenuList = TypeMenu.findAll();
        render(typeReglementList, menus, typeMenuList);
    }

}
