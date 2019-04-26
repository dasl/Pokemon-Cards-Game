package cc3002.pokemon;

public abstract class AbstractEnergy implements IEnergy {
    private String energyType;
    protected IEnergy type;

    @Override
    public void EnergieType(IEnergy energy) {
        this.type = energy;
    }

}
