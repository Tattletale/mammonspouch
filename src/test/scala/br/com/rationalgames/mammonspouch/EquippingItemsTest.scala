package br.com.rationalgames.mammonspouch

import org.scalatest._

class EquippingItemsTest extends FeatureSpec with GivenWhenThen {
    feature("Player equips an item that is equippable") {
        info("when player equips a PhysicalWeapon, it should be stored in his physical weapon slot")
        info("when player equips a RangedWeapon, it should be stored in his physical weapon slot")
        info("when player equips a Armor, it should be stored in his armor slot")
        info("when player equips a Sigil, it should be stored in his sigil slot")

        scenario("Player equips a PhysicalWeapon") {
            Given("a Hero")
            val aHero: Hero = new Hero(1)
            And("a PhysicalWeapon")
            val aPhysicalWeapon: PhysicalWeapon = new PhysicalWeapon
            When("hero equips a physicalWeapon")
            aHero.equip(aPhysicalWeapon)
            Then("hero's physicalWeapon should be the equipped weapon")
            assert(aHero.physicalWeapon == aPhysicalWeapon)
        }


        scenario("Player equips a RangedWeapon") {
            Given("a Hero")
            val aHero: Hero = new Hero(1)
            And("a RangedWeapon")
            val aRangedWeapon: RangedWeapon = new RangedWeapon
            When("hero equips a rangedWeapon")
            aHero.equip(aRangedWeapon)
            Then("hero's rangedWeapon should be the equipped weapon")
            assert(aHero.rangedWeapon == aRangedWeapon)
        }


        scenario("Player equips a Sigil") {
            Given("a Hero")
            val aHero: Hero = new Hero(1)
            And("a Sigil")
            val aSigil: Sigil = new Sigil
            When("hero equips a Sigil")
            aHero.equip(aSigil)
            Then("hero's Sigil should be the equipped sigil")
            assert(aHero.sigil == aSigil)
        }


        scenario("Player equips an Armor") {
            Given("a Hero")
            val aHero: Hero = new Hero(1)
            And("an Armor")
            val anArmor: Armor = new Armor
            When("hero equips an Armor")
            aHero.equip(anArmor)
            Then("hero's Armor should be the equipped armor")
            assert(aHero.armor == anArmor)
        }

    }

    feature("Player can switch items") {
        info("In case the player wants to equip a weapon but he already has a weapon equiped for that slot," +
            " his currently equiped weapon is switched for the one he wants to equip")

        scenario("Player equips a phyisicalWeapon when he's already had a phyisicalWeapon equipped") {
            Given("a Hero that has a phyisicalWeapon equipped")
            val aHero: Hero = new Hero(1)
            aHero.equip(new PhysicalWeapon)
            And("a new physicalWeapon")
            val newPhysicalWeapon: PhysicalWeapon = new PhysicalWeapon
            When("hero equips the new phyisicalWeapon")
            aHero.equip(newPhysicalWeapon)
            Then("hero's physicalWeapon should be the newly equipped weapon")
            assert(aHero.physicalWeapon == newPhysicalWeapon)
        }


        scenario("Player equips a rangedWeapon when he's already had a rangedWeapon equipped") {
            Given("a Hero")
            And("that the hero has a rangedWeapon equipped")
            When("hero equips another rangedWeapon")
            Then("hero 's rangedWeapon should be the newly equipped weapon")
        }

        scenario("Player equips a sigil when he's already had a sigil equipped") {
            Given("a Hero")
            And("that the hero has a Sigil equipped")
            When("hero equips another Sigil")
            Then("hero 's Sigil should be the newly equipped Sigil")
        }

        scenario("Player equips an armor when he's already had an armor equipped") {
            Given("a Hero")
            And("that the hero has an armor equipped")
            When("hero equips another Armor")
            Then("hero 's Armor should be the newly equipped Armor")
        }
    }


    feature("Player unequips an item") {
        info("When a player unequips one of his weapons, a Weapon.none is set in the before-equipped weapon's place.")

        scenario("Player unequips a phyisicalWeapon") {
            Given("a Hero")
            And("that the hero has a phyisicalWeapon equipped")
            When("hero unequips his physicalWeapon")
            Then("hero 's physicalWeapon should be Weapon.none")
        }

        scenario("Player unequips a rangedWeapon") {
            Given("a Hero")
            And("that the hero has a rangedWeapon equipped")
            When("hero unequips his rangedWeapon")
            Then("hero 's rangedWeapon should be Weapon.none")
        }

        scenario("Player unequips a Sigil") {
            Given("a Hero")
            And("that the hero has a Sigil equipped")
            When("hero unequips his Sigil")
            Then("hero 's Sigil should be Sigil.none")
        }


        scenario("Player unequips an Armor") {
            Given("a Hero")
            And("that the hero has an Armor equipped")
            When("hero unequips his Armor")
            Then("hero 's Armor should be Armor.none")
        }
    }
}
