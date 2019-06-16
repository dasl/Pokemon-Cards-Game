package cc3002.pokemon.Abilities;

import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

public interface IAbilities{
    void accept(IAbilityVisitor visitor);

    int getFireRequiredEnergies();

    int getWaterRequiredEnergies();

    int getGrassRequiredEnergies();

    int getElectricRequiredEnergies();

    int getNormalRequiredEnergies();

    int getPsychicRequiredEnergies();

    void setFireRequiredEnergies(FireEnergy energy);

    void setWaterRequiredEnergies(WaterEnergy energy);

    void setElectricRequiredEnergies(ElectricEnergy energy);

    void setPsychicRequiredEnergies(PsychicEnergy energy);

    void setGrassRequiredEnergies(GrassEnergy energy);

    void setNormalRequiredEnergies(NormalEnergy energy);

    String getName();


    /**
     * Add an effect to an abstractPokemon
     * This is the handshake of the double dispatch
     *
     * @param abstractPokemon
     */
    void applyEffect(Trainer abstractPokemon);

    int getBaseDamage();
}
