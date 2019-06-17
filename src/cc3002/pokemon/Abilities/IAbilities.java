package cc3002.pokemon.Abilities;

import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

/**
 * Common interface for all the abilities. Considering their two types of abilities, attacks and a generic ability
 *
 * @author Diego Sandoval Leiva
 */


public interface IAbilities{
    void accept(IAbilityVisitor visitor);

    /**
     * Getter for Fire Required Energies.
     *
     * @return Fire Required Energies.
     */
    int getFireRequiredEnergies();


    /**
     * Getter for Grass Required Energies.
     *
     * @return Grass Required Energies.
     */
    int getGrassRequiredEnergies();


    /**
     * Getter for Fire Required Energies.
     *
     * @return Fire Required Energies.
     */
    int getElectricRequiredEnergies();


    /**
     * Getter for Normal Required Energies.
     *
     * @return Normal Required Energies.
     */
    int getNormalRequiredEnergies();


    /**
     * Getter for Water Required Energies.
     *
     * @return Water Required Energies.
     */
    int getWaterRequiredEnergies();


    /**
     * Getter for Psychic Required Energies.
     *
     * @return Psychic Required Energies.
     */
    int getPsychicRequiredEnergies();


    /**
     * Receive an energy.
     *
     */
    void receiveRequiredEnergy(IEnergy energy);

    /**
     * Setter for Fire Required Energies.
     *
     */
    void setFireRequiredEnergies(FireEnergy energy);

    /**
     * Setter for Water Required Energies.
     *
     */
    void setWaterRequiredEnergies(WaterEnergy energy);


    /**
     * Setter for Electric Required Energies.
     *
     */
    void setElectricRequiredEnergies(ElectricEnergy energy);


    /**
     * Setter for Psychic Required Energies.
     *
     */
    void setPsychicRequiredEnergies(PsychicEnergy energy);


    /**
     * Setter for Grass Required Energies.
     *
     */
    void setGrassRequiredEnergies(GrassEnergy energy);


    /**
     * Setter for Normal Required Energies.
     *
     */
    void setNormalRequiredEnergies(NormalEnergy energy);


    String getName();


    /**
     * Add an effect to an abstractPokemon
     * This is the handshake of the double dispatch
     *
     * @param trainer
     */
    void applyEffect(Trainer trainer);

    int getBaseDamage();

}
