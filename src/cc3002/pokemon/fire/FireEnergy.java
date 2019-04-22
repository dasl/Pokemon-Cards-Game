package cc3002.pokemon.fire;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class FireEnergy implements IEnergy {
    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receiveFireEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
