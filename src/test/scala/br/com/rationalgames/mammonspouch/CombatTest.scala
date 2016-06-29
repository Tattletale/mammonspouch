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
      val player = combat.next
      assert(player.isInstanceOf[Hero])
      When("Player moves once and attacks the enemy")
      player.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)
      When("Player moves a second time and attacks the enemy")
      player.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        player.move
      }
    }

    scenario("Scenario 2: Hero's higher level than the enemy") {
      Given("Combat begins between a level 2 player and a level 1 enemy")
      val monster = new Monster(1)
      monster.life = 1
      val hero = new Hero(2)
      hero.damage = 1
      val combat = new Combat(hero, monster)
      info("Player begins the battle (first turn)")
      val player = combat.next
      assert(player.isInstanceOf[Hero])
      When("Player moves once and attacks the enemy")
      player.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)
      When("Player moves a second time and attacks the enemy")
      player.move.attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        player.move
      }
    }

    scenario("Scenario 3: Monster is higher level than the player") {
      Given("Combat begins between a level 1 player and a level 2 enemy")
      val monster = new Monster(2)
      monster.damage = 1
      val hero = new Hero(1)
      hero.life = 1
      val combat = new Combat(hero, monster)
      info("Enemy begins the battle (first turn)")
      val enemy = combat.next
      assert(enemy.isInstanceOf[Monster])
      When("Enemy moves once and attacks the player")
      enemy.move.attack(hero)
      Then("Player takes damage")
      assert(hero.life == 0)
    }

    scenario("Scenario 4: Player fights 2 monsters of the same level as him"){
      info("Combat begins between a level 1 player and two level 1 enemy")
      info("Player begins the battle (first turn)")
      info("Player moves once and attacks the enemy")
      info("Enemy takes damage")
      info("Player moves a second time and attacks the enemy")
      info("Enemy takes damage")
      info("Enemy turn")
      info("First enemy moves once and attacks the player")
      info("Player takes damage")
      info("Second enemy moves once and attacks the player")
      info("Player takes damage")
    }
  }

}
