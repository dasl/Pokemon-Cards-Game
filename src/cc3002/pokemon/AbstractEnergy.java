package cc3002.pokemon;

public abstract class AbstractEnergy implements IEnergy {
    private IEnergy type;

    /**
     * Creates a new attack.
     *
     * @param energy Energy Type
     */
    protected AbstractEnergy(IEnergy energy) {
        this.type = energy;
    }


    @Override
    public IEnergy getType() {return this.type;}

}
