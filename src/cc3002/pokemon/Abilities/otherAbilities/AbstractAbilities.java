package cc3002.pokemon.Abilities.otherAbilities;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.visitor.IAbilityVisitor;
import cc3002.pokemon.AbstractCard;
import cc3002.pokemon.EnergyCounter;
import cc3002.pokemon.IEnergy;
import cc3002.pokemon.electric.ElectricEnergy;
import cc3002.pokemon.fire.FireEnergy;
import cc3002.pokemon.grass.GrassEnergy;
import cc3002.pokemon.normal.NormalEnergy;
import cc3002.pokemon.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterEnergy;

public abstract class AbstractAbilities extends AbstractCard implements IAbilities {
    private String text;
    private String name;
    private EnergyCounter costs;

    public AbstractAbilities(String name,String text, EnergyCounter costs){
        this.name = name;
        this.text = text;
        this.costs = costs;
    }

    @Override
    public void accept(IAbilityVisitor visitor){
        visitor.visitConcreteAbility(this);
    }

    @Override
    public int getFireRequiredEnergies() {
        return this.costs.getFireEnergy();
    }
    @Override
    public int getWaterRequiredEnergies() {
        return this.costs.getWaterEnergy();
    }
    @Override
    public int getGrassRequiredEnergies() {
        return this.costs.getGrassEnergy();
    }
    @Override
    public int getElectricRequiredEnergies() {
        return this.costs.getElectricEnergy();
    }
    @Override
    public int getNormalRequiredEnergies() {
        return this.costs.getNormalEnergy();
    }
    @Override
    public int getPsychicRequiredEnergies() {
        return this.costs.getPyshicEnergy();
    }

    @Override
    public void setFireRequiredEnergies(FireEnergy energy) {this.costs.setFireEnergy(); }
    @Override
    public void setWaterRequiredEnergies(WaterEnergy energy) {this.costs.setWaterEnergy(); }
    @Override
    public void setElectricRequiredEnergies(ElectricEnergy energy) {this.costs.setElectricEnergy(); }
    @Override
    public void setPsychicRequiredEnergies(PsychicEnergy energy) {this.costs.setNormalEnergy(); }
    @Override
    public void setGrassRequiredEnergies(GrassEnergy energy) {this.costs.setGrassEnergy(); }
    @Override
    public void setNormalRequiredEnergies(NormalEnergy energy) {this.costs.setNormalEnergy(); }

    public void receiveRequiredEnergy(IEnergy energy){
        energy.addInto(this);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getCardType() {
        return null;
    }

    @Override
    public int getBaseDamage(){
        return -1;
    }

}
