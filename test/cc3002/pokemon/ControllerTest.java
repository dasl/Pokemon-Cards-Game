package cc3002.pokemon;
import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.otherAbilities.Heal;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.AbstractTrainerCard;
import cc3002.pokemon.TrainerCards.StadiumCards.LuckyStadium;
import cc3002.pokemon.TrainerCards.StadiumCards.StadiumCard;
import cc3002.pokemon.controller.ICardObserver;
import cc3002.pokemon.controller.ITrainerObserver;
import cc3002.pokemon.controller.cardObserver;
import cc3002.pokemon.controller.trainerObserver;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.water.BasicWP;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class ControllerTest {
    private ITrainerObserver  trainerObserver;
    private ICardObserver cardObserver;
    private AbstractTrainerCard trainerCard,stadium;
    private Trainer trainer, brook;
    private IPokemon charmander,totodile;
    private IAbilities fireAttack,heal;


    @Before
    public void setUp() {
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        heal = new Heal("Heal","Soy entero pulento y me regenero jajaja",new EnergyCounter());
        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(fireAttack)));
        totodile = new BasicWP("Totodile", 1,100, new ArrayList<>());
        trainerCard = new LuckyStadium("Lucky Stadium","Si juego en casa, tengo ventaja jeje xd");
        trainer = new Trainer("Ash",charmander,new ArrayList<>());
        brook = new Trainer("Brook",totodile,new ArrayList<>());
        stadium = new LuckyStadium("Lucky Stadium","Si juego en casa, tengo ventaja jeje xd");
        cardObserver = new cardObserver(trainerCard);
        trainerObserver = new trainerObserver(trainer);
    }

    @Test
    public void controllerTest(){
        trainer.addToCardsDeck(charmander);
        trainer.addToCardsDeck(charmander);
        trainer.setOponent(brook);
        trainer.fromDeckToHand();
        trainerObserver.StealAndPut();
        trainerObserver.LookHisHandAndPlay();
        trainerObserver.LookinTheScenario();
        trainer.addToCardsDeck(charmander);
        trainer.play(stadium);
        trainer.selectAbility(0);
        trainer.useAbility(brook);
        trainerObserver.useAbility();


    }
}
