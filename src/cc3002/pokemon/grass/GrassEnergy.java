package cc3002.pokemon.grass;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class GrassEnergy implements IEnergy {
    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receiveGrassEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
