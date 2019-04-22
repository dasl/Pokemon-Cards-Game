package cc3002.pokemon.water;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class WaterEnergy implements IEnergy {
    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receiveWaterEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
