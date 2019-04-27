
# Pokemon Cards Game

Cards game based on Pokemon Cards.

For the subject 
Design and Programming Methodologies  of the University of Chile.

## Getting started with the implementation


This card game implements different functionalities of the real game, you were implemented as:

* Cards

    * 
      This works as an interface, which is implemented by the two types of cards in the game, energies 
      and pokemons.
      

* Pokemons

    * 
       An interface was made with the main objective of being able to carry out a double dispatch and with this being able to apply the
       properties of each attack and identify how the attack affects a receiving pokemon.
        
       Furthermore, an Abstract class that represents a generic Pokemon. This class contains the necessary methods to
       attack and receive damage, and definitions to get the properties of each Pokemon, like its name
       and hp.


* Energies

    * 
      This function is performed through an interface, whose main function is to act as an intermediary to implement a double disptach, such that they can be
      apply the energies required for an attack, as well as the energies
      added for a certain pokemon.
      
      Furthermore, an Abstract class for the hereditary identification functions.
    
      

* Attacks

    * Common interface for all the attacks. Every attack have a name and a base damage, and should be
      able to damage a Pokémon.
      
      Furthermore, an Abstract class for all the attacks. This contains the methods to access the attack's properties, like
      it's name and base damage.
      
      

* Trainer
    * Abstract class that represents a generic Trainer. This class contains the necessary methods to
      create a Pockedeck, an active pokemon, identify if a pokemon is dead or if a pokemon is able to attack.





## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The web framework used



## Authors

* **Diego Sandoval Leiva** - *Initial work* - [dasl.icu](https://dasl.icu/)


## License

This project is licensed under the MIT License 

## Acknowledgments
* Ignacio Slater M.
* Alexandre Bergel
* Juan-Pablo Silva
* Ash Ketchum

