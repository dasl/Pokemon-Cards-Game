package cc3002.pokemon.electric;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class ElectricEnergy implements IEnergy {
    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receiveElectricEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
