package cc3002.pokemon.psychic;

import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class PsychicEnergy implements IEnergy{

    @Override
    public void applyEnergyTo(IPokemon other) {
        other.receivePsychicEnergy(this);
    }
    @Override
    public boolean abilityEnabled(){
        return true;
    }
}
