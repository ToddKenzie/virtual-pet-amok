# Virtual Pets AMOK!

**Module 4 Graded Project**

## Synopsis

Oh noes! Your virtual pet shelter has become a mess!

Food and water and playtime aren’t enough anymore. The virtual cats are chasing the virtual dogs. The virtual organic animals are letting nature take its course in every corner, while the virtual robotic pets are getting rusty. Let’s just say things are piling up.

Thanks to the generosity of donors, leashes aren’t an issue, so you can walk all of your virtual dogs at once. This is great, since they are less like to soil their cages if walked regularly. Did I mention dogs are in cages now? Yeah, it keeps the cats from chasing them. Better keep those cages clean.

Cats hang out in a communal area and use a common litter box. Don’t even bother trying to walk them. What happens if that litter box overflows? Does it reduce pets’ health?

We’re introducing a health attribute for pets. Organic pets have their health decreased by unclean circumstances, and by thirst or hunger growing too high. Robotic pets only lose health if they’re not oiled regularly. All pets lose health if their happiness drops too low.

### Required Tasks

**General**

* introduce ways to track:
* cage cleanliness for organic dogs
* shelter litter box cleanliness for organic cats
* oil/maintenance level for robot animals

**All classes**

* Encapsulate all instance variables.
* Assign appropriate visibility modifiers to methods only used internally by a class or within a class hierarchy.

**VirtualPet class and related subclasses/interfaces**

In addition to the last project’s requirements:

* create a model that allows for dogs and cats, either of which may be robotic
* introduce an attribute (instance variable) representing overall health that is updated as a result of other attributes moving in a negative or positive direction, influencing happiness
* introduce methods that allow for:
	* oiling robotic pets
	* walking dogs, decreasing the likelihood that organic dogs will soil their cages, while increasing happiness in all dogs
* do not allow:
	* feeding/watering robotic pets
	* oiling organic pets
* modify the tick method to return a value indicating the amount of waste a pet creates, which should contribute to either (optionally, create accessor methods to retrieve these values instead):
	* amount of waste in the litter box
	* amount of waste in an individual dog cage

**VirtualPetShelter class**

In addition to the last project’s requirements:

* introduce methods that allow for:
* oiling/maintaining all robotic pets
* cleaning dog cages
* emptying the litterbox
* modify existing methods to only feed/water pets that are not robotic

**VirtualPetShelterApp class**

In addition to the last project’s requirements:

* add options to:
* walk all dogs
* clean dog cages
* clean the shelter litterbox
* oil all robotic pets

### Minor Additions

* Added Using Laser Pointers to play with all Robotic Pets and Cats
* Added Using Toy Mice to Play with All Cats (and rile up all dogs)
* App will let you choose options that no pets exist for, but will let you know on option commit that there's no point to doing that
