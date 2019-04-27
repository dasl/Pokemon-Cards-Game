package cc3002.pokemon.fire;

import cc3002.pokemon.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FireEnergyTest {
    private IEnergy fireEnergy;

    @Before
    public void setUp() {
        fireEnergy = new FireEnergy();
    }

    @Test
    public void createElectricEnergyCard(){
        assertEquals("Fire",fireEnergy.getEnergyNameType());
    }

    @Test
    public void cardType(){
        assertEquals("Energy",fireEnergy.getCardType());
    }

    @Test
    public void energyTypeName() { assertEquals("Fire",fireEnergy.getEnergyNameType());}

}