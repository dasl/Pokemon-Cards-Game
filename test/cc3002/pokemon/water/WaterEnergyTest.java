package cc3002.pokemon.water;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests set for the WaterEnergy class.
 *
 * @author Diego Sandoval Leiva
 */

public class WaterEnergyTest {
    private IEnergy waterEnergy;

    @Before
    public void setUp() {
        waterEnergy = new WaterEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Water",waterEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",waterEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Water",waterEnergy.getEnergyNameType());}

}