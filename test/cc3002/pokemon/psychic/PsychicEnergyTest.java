package cc3002.pokemon.psychic;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.electric.ElectricEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests set for the PsychicEnergy class.
 *
 * @author Diego Sandoval Leiva
 */


public class PsychicEnergyTest {
    private IEnergy psychicEnergy;

    @Before
    public void setUp() {
        psychicEnergy = new PsychicEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Psychic",psychicEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",psychicEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Psychic",psychicEnergy.getEnergyNameType());}

}