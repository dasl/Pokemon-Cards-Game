package cc3002.pokemon.normal;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class NormalEnergy implements IEnergy {
    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receiveNormalEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
