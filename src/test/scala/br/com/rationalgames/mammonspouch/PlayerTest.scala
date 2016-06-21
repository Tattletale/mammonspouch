package br.com.rationalgames.mammonspouch

import org.scalatest._

/**
  *
  */
class PlayerTest extends FeatureSpec with GivenWhenThen {


  feature("Combat between player and one monster") {
    info("Combat begins")
    info("Combat begins with the highest level creature (hero, or monster), in case of both parties having the same level, first turn is conceded to the player.")
    info("Turns are subdivided in moves, each creature has a set number of moves, turns dictates who is playing at the time, either the player or the opponents.")
    info("In the enemy turn, their order of movement is according to their levels or order of spawn.")
    info("Player has two moves by default.")

    scenario("Scenario 1: Same level parties") {
      info("Combat begins between a level 1 player and a level 1 enemy")
      info("Player begins the battle (first turn)")
      info("Player moves once and attacks the enemy")
      info("Enemy takes damage")
      info("Player moves a second time and attacks the enemy")
      info("Enemy takes damage")
    }

    scenario("Scenario 2: Hero's higher level than the enemy") {
      info("Combat begins between a level 2 player and a level 1 enemy")
      info("Player begins the battle (first turn)")
      info("Player moves once and attacks the enemy")
      info("Enemy takes damage")
      info("Player moves a second time and attacks the enemy")
      info("Enemy takes damage")
    }

    scenario("Scenario 3: Monster is higher level than the player") {
      info("Combat begins between a level 1 player and a level 2 enemy")
      info("Enemy begins the battle (first turn)")
      info("Enemy moves once and attacks the player")
      info("Player takes damage")
    }



  }

}
