import models.Commandes.Client;
import models.restaurants.Agent;
import models.utilisateurs.Utilisateur;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void enrUti() {
        new Agent("pierreDKP", "motdepasse", "pierredegboevi@gmail.com").save();
    }

}
