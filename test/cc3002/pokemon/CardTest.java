package cc3002.pokemon;
import static org.junit.Assert.*;

import cc3002.pokemon.Abilities.IAbilities;
import cc3002.pokemon.Abilities.attacks.ElectricShock;
import cc3002.pokemon.Abilities.otherAbilities.Heal;
import cc3002.pokemon.Trainer.Trainer;
import cc3002.pokemon.TrainerCards.ObjectsCards.GreatBall;
import cc3002.pokemon.TrainerCards.ObjectsCards.Potion;
import cc3002.pokemon.TrainerCards.StadiumCards.LuckyStadium;
import cc3002.pokemon.TrainerCards.SupportCards.ProfessorCozmosDiscovery;
import cc3002.pokemon.fire.BasicFP;
import cc3002.pokemon.fire.FireAttack;
import cc3002.pokemon.water.BasicWP;
import cc3002.pokemon.water.WaterAttack;
import cc3002.pokemon.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CardTest {
    private IPokemon charmander,totodile, pokemoncojo;
    private ICard support,stadium, GreatBall,potion;
    private Trainer Ash, Brook;
    private IAbilities fireAttack, heal,waterAttack, electricShock;
    private IEnergy waterEnergy, fireEnergy, electricEnergy, grassEnergy, pyshicEnergy, normalEnergy;

    @Before
    public void setUp() {
        waterAttack = new WaterAttack("Bubble", 50,"An attack using bubbles. May lower the foe's Speed.",new EnergyCounter());
        fireAttack = new FireAttack("Ember", 40,"An attack that may inflict a burn.",new EnergyCounter());
        electricShock = new ElectricShock("ElectricShock", 40,"An attack that may inflict a burn.",new EnergyCounter());
        heal = new Heal("Heal","Soy entero pulento",new EnergyCounter());

        charmander = new BasicFP("Charmander",1, 100, new ArrayList<>(Arrays.asList(heal,fireAttack, electricShock)));
        pokemoncojo = new BasicFP("Cojomonder",198, 50, new ArrayList<>(Arrays.asList(heal,fireAttack, electricShock)));
        support = new ProfessorCozmosDiscovery("Professor Cozmo's Discovery","Juegos de azar y mujerzuelas");
        stadium = new LuckyStadium("Lucky Stadium","Si juego en casa, tengo ventaja jeje xd");
        GreatBall = new GreatBall("Great Ball","Cacha como crece mi banca de pokemones jajaja.");
        potion = new Potion("Potion","Cacha como regenero a mi pokemon seleccionado, jaja sin picarse.");


        totodile = new BasicWP("Totodile",25,100, new ArrayList<>());
        Ash = new Trainer("Ash",charmander,new ArrayList<>());
    }

    @Test
    public void testingPokemonCards(){
        Ash.addToCardsHand(totodile);
        Ash.play(totodile);
        assertTrue(Ash.getBench().contains(totodile));

    }


    @Test
    public void testingEnergyCards(){
        waterEnergy = new WaterEnergy();
        Ash.setSelectedPokemon(charmander);
        Ash.play(waterEnergy);
        assertEquals(Ash.getSelectedPokemon().getWaterEnergies(),1);
    }

    @Test
    public void testingSupportCards(){
        // Mazo de charmanders
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsHand(support);
        assertEquals(Ash.sizePokeHand(),1);
        Ash.play(support);
        assertTrue(Ash.sizePokeHand()==2 || Ash.sizePokeHand()==3);
        assertFalse(Ash.getHand().contains(support));
    }

    @Test
    public void testingStadiumCards(){
        Ash.addToCardsDeck(charmander);
        Ash.dropHand();
        Ash.addToCardsHand(stadium);
        Ash.play(stadium);
        assertTrue(Ash.sizePokeHand()==1 || Ash.sizePokeHand()==2);
    }

    @Test
    public void testingObjectsCards(){
        // GreatBall
        Ash.addToCardsDeck(charmander);
        Ash.dropHand();
        Ash.addToCardsHand(GreatBall);
        Ash.setSelectedPokemon(charmander);
        Ash.play(GreatBall);
        assertTrue(Ash.sizePokeBench()==1);

        // Potion
        Ash.setSelectedPokemon(pokemoncojo);
        assertEquals(Ash.getSelectedPokemon().getHP(),50);
        Ash.play(potion);
        assertEquals(Ash.getSelectedPokemon().getHP(),70);

    }

    @Test
    public void cardStringType(){
        assertEquals("StadiumCard",stadium.getCardType());
        assertEquals("SupportCard",support.getCardType());
        assertEquals("ObjectsCard", GreatBall.getCardType());
    }
}
