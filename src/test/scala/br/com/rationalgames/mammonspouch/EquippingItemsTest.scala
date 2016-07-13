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
        info("When player switches an equipped item for another item," +
            " the previously equipped item is unequipped and the other item is equipped in its place")

        scenario("Player switches a physicalWeapon for another physicialWeapon") {
            Given("a Hero")
            And("another physicialWeapon")
            And("that the hero has a physicialWeapon equipped")
            When("hero switches his physicialWeapon for another physicialWeapon")
            Then("hero's phyisicalWeapon should be the switched-for physicalWeapon")
            Then("the previously equipped item should be returned")
        }

        scenario("Player switches a rangedWeapon for another rangedWeapon") {
            Given("a Hero")
            And("another rangedWeapon")
            And("that the hero has a rangedWeapon equipped")
            When("hero switches his rangedWeapon for another rangedWeapon")
            Then("hero's rangedWeapon should be the switched-for rangedWeapon")
            Then("the previously equipped item should be returned")
        }

        scenario("Player switches an armor for another armor") {
            Given("a Hero")
            And("another armor")
            And("that the hero has an armor equipped")
            When("hero switches his armor for another armor")
            Then("hero's armor should be the switched-for armor")
            Then("the previously equipped item should be returned")
        }

        scenario("Player switches a sigil for another sigil") {
            Given("a Hero")
            And("another sigil")
            And("that the hero has a sigil equipped")
            When("hero switches his sigil for another sigil")
            Then("hero's sigil should be the switched-for sigil")
            Then("the previously equipped item should be returned")
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
