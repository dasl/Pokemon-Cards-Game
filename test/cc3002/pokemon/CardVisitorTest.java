package cc3002.pokemon;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.CardVisitor.EnergyCardVisitor;
import cc3002.pokemon.CardVisitor.ICardVisitor;
import cc3002.pokemon.CardVisitor.PokemonCardVisitor;
import cc3002.pokemon.CardVisitor.TrainerCardVisitor;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;
import cc3002.pokemon.TrainerCards.ObjectsCards.ObjectsCard;
import cc3002.pokemon.TrainerCards.StadiumCards.StaduimCard;
import cc3002.pokemon.TrainerCards.SupportCards.ProfessorCozmosDiscovery;
import cc3002.pokemon.TrainerCards.SupportCards.SupportCard;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.water.BasicWP;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CardVisitorTest {
    private IPokemon charmander,totodile;
    private SupportCard support;
    private StaduimCard stadium;
    private ObjectsCard objectsCard;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, shift,waterAttack,afterimageassault;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;
    ICardVisitor pokemonCardVisitor,trainerCardVisitor,energyCardVisitor;
    AbstractEnergy abstractEnergy;
    AbstractPokemon abstractPokemon;
    AbstractTrainerCard abstractTrainerCard;


    @Before
    public void setUp() {
        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>());
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>());
        Ash = new Trainer("Ash",charmander,new ArrayList<>());
        support = new ProfessorCozmosDiscovery("Professor Cozmo's Discovery","Juegos de azar y mujerzuelas");
        waterEnergy = new WaterEnergy();
        pokemonCardVisitor = new PokemonCardVisitor();
        trainerCardVisitor = new TrainerCardVisitor();
        energyCardVisitor = new EnergyCardVisitor();
    }

    @Test
    public void PokemonCardVisitorTest(){
        Ash.setSelectedPokemon(totodile);
        Ash.getSelectedPokemon().accept(pokemonCardVisitor);
        pokemonCardVisitor.visitEnergyCard(abstractEnergy);
        pokemonCardVisitor.visitTrainerCard(abstractTrainerCard);

    }

    @Test
    public void EnergyCardVisitorTest(){
        waterEnergy.accept(energyCardVisitor);
        energyCardVisitor.visitTrainerCard(abstractTrainerCard);
        energyCardVisitor.visitPokemonCard(abstractPokemon);
    }

    @Test
    public void TrainerCardVisitorTest(){
        support.accept(trainerCardVisitor);
        trainerCardVisitor.visitEnergyCard(abstractEnergy);
        trainerCardVisitor.visitPokemonCard(abstractPokemon);
    }

}
