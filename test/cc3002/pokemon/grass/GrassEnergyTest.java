package cc3002.pokemon.grass;

import cc3002.pokemon.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Tests set for the GrassEnergy class.
 *
 * @author Diego Sandoval Leiva
 */
public class GrassEnergyTest {
    private IEnergy grassEnergy;

    @Before
    public void setUp() {
        grassEnergy = new GrassEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Grass",grassEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",grassEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Grass",grassEnergy.getEnergyNameType());}


}