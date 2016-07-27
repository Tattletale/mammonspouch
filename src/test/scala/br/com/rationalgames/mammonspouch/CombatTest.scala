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
      val monster = new Monster(level = 1)
      monster.life = 2
      val hero = new Hero(level = 1)
      hero.damage = 1
      val combat = new Combat(hero, monster)

      And("Player begins the battle (first turn)")
      val player = combat.next
      assert(player.isInstanceOf[Hero])

      When("Player moves once and attacks the enemy")
      player.move().attack(monster)
      info("Enemy takes damage")
      assert(monster.life == 1)

      And("Player moves a second time and attacks the enemy")
      player.move().attack(monster)

      Then("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        player.move()
      }
    }

    scenario("Scenario 2: Hero's higher level than the enemy") {

      Given("Combat begins between a level 2 player and a level 1 enemy")
      val monster = new Monster(level = 1)
      monster.life = 2
      val hero = new Hero(2)
      hero.damage = 1
      val combat = new Combat(hero, monster)

      And("Player begins the battle (first turn)")
      val player = combat.next
      assert(player.isInstanceOf[Hero])

      When("Player moves once and attacks the enemy")
      player.move().attack(monster)
      info("Enemy takes damage")
      assert(monster.life == 1)

      And("Player moves a second time and attacks the enemy")
      player.move().attack(monster)

      Then("Enemy takes damage")
      assert(monster.life == 0)

      info("Player has two moves by default.")
      intercept[IllegalStateException] {
        player.move()
      }
    }

    scenario("Scenario 3: Monster is higher level than the player") {
      Given("Combat begins between a level 1 player and a level 2 enemy")
      val monster = new Monster(level = 2)
      monster.damage = 1
      val hero = new Hero(level = 1)
      hero.life = 1
      val combat = new Combat(hero, monster)
      And("Enemy begins the battle (first turn)")
      val enemy = combat.next
      assert(enemy.isInstanceOf[Monster])

      When("Enemy moves once and attacks the player")
      enemy.move().attack(hero)

      Then("Player takes damage")
      assert(hero.life == 0)
    }

    scenario("Scenario 4: Player fights 2 monsters of the same level as him") {
      Given("Combat begins between a level 1 player and two level 1 enemy")
      val monster = new Monster(level = 1)
      monster.damage = 1
      monster.life = 2
      val hero = new Hero(level = 1)
      hero.damage = 1
      hero.life = 2
      val combat = new Combat(hero, monster)
      And("Player begins the battle (first turn)")
      val player = combat.next
      assert(player.isInstanceOf[Hero])
      When("Player moves once and attacks the enemy")
      player.move().attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 1)
      When("Player moves a second time and attacks the enemy")
      player.move().attack(monster)
      Then("Enemy takes damage")
      assert(monster.life == 0)
      info("Enemy turn")
      val enemy = combat.next
      assert(enemy.isInstanceOf[Monster])
      When("First enemy moves once and attacks the player")
      enemy.move().attack(player)
      Then("Player takes damage")
      assert(player.life == 1)
      When("Second enemy moves once and attacks the player")
      enemy.move().attack(player)
      Then("Player takes damage")
      assert(player.life == 0)
    }

    scenario("Scenario 5: Player fights 2 monsters, one higher level than the other, while the playing being of the same level or above them.") {
      Given("Combat begins between a level 2 player and one enemy of level 1 and another one of level 2")
      val hero = new Hero(level = 2)
      hero.damage = 1
      hero.life = 2

      val monster1 = new Monster(level = 1)
      monster1.damage = 1
      monster1.life = 2

      val monster2 = new Monster(level = 2)
      monster2.damage = 1
      monster2.life = 2

      val combat = new Combat(characters = hero, monster1, monster2)
      And("Player begins the battle (first turn)")
      val player = combat.next
      assert(player.isInstanceOf[Hero])
      When("Player moves once and attacks the enemy")
      player.move().attack(monster1)
      Then("Enemy takes damage")
      assert(monster1.life == 1)
      When("Player moves a second time and attacks the enemy")
      player.move().attack(monster1)
      Then("Enemy takes damage")
      assert(monster1.life == 0)
      info("Enemy turn")
      val enemy1 = combat.next
      assert(enemy1.isInstanceOf[Monster])
      When("Level 2 enemy moves once and attacks the player")
      assert(enemy1.level == 2)
      enemy1.move().attack(hero)
      Then("Player takes damage")
      assert(hero.life == 1)
      When("Level 1 enemy moves once and attacks the player")
      val enemy2 = combat.next
      assert(enemy2.isInstanceOf[Monster])
      assert(enemy2.level == 1)
      enemy1.move().attack(hero)
      Then("Player takes damage")
      assert(hero.life == 0)
    }

    scenario("Scenario 6: Player fights 2 monsters, one higher level than the other, while the playing being lower level than them") {
      Given("Combat begins between a level 1 player and one enemy of level 2 and another one of level 3")
      val hero = new Hero(level = 1)
      hero.damage = 1
      hero.life = 2

      val monster1 = new Monster(level = 2)
      monster1.damage = 1
      monster1.life = 2

      val monster2 = new Monster(level = 3)
      monster2.damage = 1
      monster2.life = 2

      val combat = new Combat(characters = hero, monster1, monster2)
      info("Enemy begins the battle (first turn)")
      val enemy1 = combat.next
      assert(enemy1.isInstanceOf[Monster])
      assert(enemy1.level == 3)
      info("Level 3 enemy moves once and attacks the player")
      enemy1.move().attack(hero)
      info("Player takes damage")
      assert(hero.life == 1)
      info("Level 2 enemy moves once and attacks the player")
      val enemy2 = combat.next
      assert(enemy2.isInstanceOf[Monster])
      assert(enemy2.level == 2)
      enemy2.move().attack(hero)
      info("Player takes damage")
      assert(hero.life == 0)
    }


  }

}
