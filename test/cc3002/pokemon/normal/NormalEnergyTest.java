package cc3002.pokemon.normal;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.electric.ElectricEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Tests set for the NormalEnergy class.
 *
 * @author Diego Sandoval Leiva
 */

public class NormalEnergyTest {
    private IEnergy normalEnergy;

    @Before
    public void setUp() {
        normalEnergy = new NormalEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Normal",normalEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",normalEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Normal",normalEnergy.getEnergyNameType());}

}