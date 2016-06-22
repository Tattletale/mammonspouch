package br.com.rationalgames.mammonspouch

import org.scalatest._

/**
  *
  */
class CombatTest extends FeatureSpec with GivenWhenThen {

  feature("Combat between player and one monster") {
    info("Combat begins")
    info("Combat begins with the highest level creature (hero, or monster), in case of both parties having the same level, first turn is conceded to the player.")
    info("Turns are subdivided in moves, each creature has a set number of moves, turns dictates who is playing at the time, either the player or the opponents.")
    info("In the enemy turn, their order of movement is according to their levels or order of spawn.")


    scenario("Scenario 1: Same level parties") {
      Given("Combat begins between a level 1 player and a level 1 enemy")
      val monster = new Monster(1)
      monster.life = 1
      val hero = new Hero(1)
      hero.damage = 1
      val combat = new Combat(hero, monster)
      info("Player begins the battle (first turn)")
      When("Player moves once and attacks the enemy")
      combat.first.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)
      When("Player moves a second time and attacks the enemy")
      combat.first.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        combat.first.move
      }
    }

    scenario("Scenario 2: Hero's higher level than the enemy") {
      info("Combat begins between a level 2 player and a level 1 enemy")
      val monster = new Monster(1)
      monster.life = 1
      val hero = new Hero(2)
      hero.damage = 1
      val combat = new Combat(hero, monster)
      info("Player begins the battle (first turn)")
      info("Player moves once and attacks the enemy")
      combat.first.move.attack(monster)
      info("Enemy takes damage")
      assert(monster.life == 0)
      info("Player moves a second time and attacks the enemy")
      combat.first.move.attack(monster)
      info("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        combat.first.move
      }
    }

    scenario("Scenario 3: Monster is higher level than the player") {
      info("Combat begins between a level 1 player and a level 2 enemy")
      info("Enemy begins the battle (first turn)")
      info("Enemy moves once and attacks the player")
      info("Player takes damage")
    }



  }

}
