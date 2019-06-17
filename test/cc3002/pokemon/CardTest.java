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
import cc3002.pokemon.TrainerCards.SupportCards.ProfessorJuniper;
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
    private ICard cosmo,juniper,stadium, GreatBall,potion;
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
        cosmo = new ProfessorCozmosDiscovery("Professor Cozmo's Discovery","Juegos de azar y mujerzuelas");
        stadium = new LuckyStadium("Lucky Stadium","Si juego en casa, tengo ventaja jeje xd");
        juniper = new ProfessorJuniper("Professor Juniper","Estoy entero picado, voy a resetear mi mano jajaxd");
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
        // Professor Cosmo
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsHand(cosmo);
        assertEquals(Ash.sizePokeHand(),1);
        Ash.play(cosmo);
        assertTrue(Ash.sizePokeHand()==2 || Ash.sizePokeHand()==3);
        assertFalse(Ash.getHand().contains(cosmo));

        // Professor Juniper
        Ash.dropHand();

        Ash.addToCardsHand(pokemoncojo);
        Ash.addToCardsHand(pokemoncojo);
        Ash.addToCardsHand(pokemoncojo);
        assertEquals(Ash.getHand().size(),3);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);
        Ash.addToCardsDeck(charmander);

        Ash.play(juniper);
        assertEquals(Ash.getHand().size(),7);

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
        Ash.addToCardsHand(potion);
        Ash.setSelectedPokemon(pokemoncojo);
        assertEquals(Ash.getSelectedPokemon().getHP(),50);
        Ash.play(potion);
        assertEquals(Ash.getSelectedPokemon().getHP(),50);

    }

    @Test
    public void cardStringType(){
        assertEquals("StadiumCard",stadium.getCardType());
        assertEquals("SupportCard",cosmo.getCardType());
        assertEquals("ObjectsCard", GreatBall.getCardType());
    }
}
