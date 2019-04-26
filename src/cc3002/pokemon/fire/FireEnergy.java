package cc3002.pokemon.fire;

import cc3002.pokemon.AbstractEnergy;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.IPokemon;

public class FireEnergy extends AbstractEnergy {
    private IEnergy type;
    private String energyTagType;


    @Override
    public void EnergieType(IEnergy energy) {
        this.type = energy;
    }

    @Override
    public void getEnergy(IEnergy energy) {

    }

    @Override
    public String getType(IEnergy energy){
        return this.energyTagType;
    }
}
