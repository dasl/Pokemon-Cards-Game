
# Pokemon Cards Game

Cards game based on Pokemon Cards.

For the subject 
Design and Programming Methodologies  of the University of Chile.

## Getting started with the implementation


This card game implements different functionalism's of the real game, that was implemented as:


* Cards

    * 
      This works as an interface, which is implemented by the two types of cards in the game, energies, trainerCards 
      and pokemons. Also, this has an Abstract Class to determinate common constructor and trainer features.
      


* Pokemons

    * 
       An interface was made with the main objective of being able to carry out a double dispatch and with this being able to apply the
       properties of each attack and identify how the attack affects a receiving pokemon.
        
       Furthermore, an Abstract class that represents a generic Pokemon. This class contains the necessary methods to
       attack and receive damage, and definitions to get the properties of each Pokemon, like its name
       and hp.
       
       For each type pokemon exist an Abstract Class that extend from AbstractPokemon and implements an own interface named
       as herself (E.g. IElectricPokemon). Also, thank of this Abstract Class, exists an implementations of basic pokemon,
       phase one pokemon and phase two pokemon, the respective evolutions for each type of pokemon.
       
       


* Energies

    * 
      This functionality is performed through an interface, whose main function is to act as an intermediary to implement a double disptach, such that they can be
      apply the energies required for an attack, as well as the energies
      added for a certain pokemon.
      
      Furthermore, an Abstract class for the hereditary identification functions.
    
      

* Attacks

    * Common interface for all the attacks. Every attack have a name and a base damage, and should be
      able to damage a Pokemon.
      
      Furthermore, an Abstract class for all the attacks. This contains the methods to access the attack's properties, like
      it's name and base damage.
      
      * AfterimageAssault, is an attack.
      
      

* Trainer
    * Abstract class that represents a generic Trainer. This class contains the necessary methods to
      create a PokeDeck, an active pokemon, identify if a pokemon is dead or if a pokemon is able to attack.
      Furthermore this feature implements an interface named ITrainer. 


* CardVisitor

    * 
      This works using the visitor pattern design for determinate the different types of cards existing in the game.
      An interface named ICardVisitor does the work of disambiguate the different Visitor for each card. Furthermore, there 
      are tree different concrete visitor that act as the visitor using multiple dispatch.
      
* Abilities
    * Considering an attack as a particular ability, and the existence of a differentiate between (no-damage) abilities and
    attacks then a visitor pattern design was implemented to disambiguate the different types of abilities.
    
        * Shift, is an ability.
    
* TrainerCards:
    * These cards alter the state of the game at the time of being played, they were implemented 
    through an Abstract Class named AbstractTrainerCard that inherit from AbstractCard. Furthermore,this class accept
    the relative visitor of CardVisitor.
    
    There are tree types of TrainerCards that inherits from AbstractTrainerCard, the implementation includes the following types with their respective cards.
    
   
        - Support:
            *   Professor Cozmo's Discovery.
        - Objects:
            *   Great Ball.
        - Stadium:
            *   Lucky Stadium.           
     
 * Controller:
    * This features was implemented using a observer pattern design. There are tree different observer, one for the Trainer,
    other one for the Cards and a last one for the abilities. These observers check the correctly course of a turn in the game.       
            

######Clarification: None of the method instanceOf() is used to disambiguate instead of double dispatch or visitor design pattern.
###### Exist an instanceOf() that disambiguate in observer design pattern because of the JAVA 8.

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The web framework used



## Authors

* **Diego Sandoval Leiva** - *Initial work* 


## License

This project is licensed under the MIT License 

## Acknowledgments
* Ignacio Slater M.
* Alexandre Bergel
* Juan-Pablo Silva
* Ash Ketchum

## Off-Topic
* Dear assistant, please excuse my terrible English. jeje xd

