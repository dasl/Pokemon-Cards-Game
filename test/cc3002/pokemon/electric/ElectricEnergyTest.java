package cc3002.pokemon.electric;


/**
 * Tests set for the ElectricEnergy class.
 *
 * @author Diego Sandoval Leiva
 */

import cc3002.pokemon.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricEnergyTest {
    private IEnergy electricEnergy;

    @Before
    public void setUp() {
        electricEnergy = new ElectricEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Electric",electricEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",electricEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Electric",electricEnergy.getEnergyNameType());}
}