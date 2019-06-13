package cc3002.pokemon;

public abstract class AbstractCard implements ICard{
    private Trainer pokeMaster;

    /**
     * Play this pokemon card.
     */
    @Override
    public void play(){
        // DEBO RELLENAR
    }

    /**
     * Set the pokemon master owner of the energy.
     * @param trainer Received trainer.
     */
    @Override
    public void setTrainer(Trainer trainer) {
        this.pokeMaster=trainer;
    }


    /**
     * Get the pokemon master owner of the energy.
     */
    @Override
    public Trainer getTrainer() {
        return this.pokeMaster;
    }

}
