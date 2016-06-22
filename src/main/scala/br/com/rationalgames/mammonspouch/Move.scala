package br.com.rationalgames.mammonspouch

/**
  *
  */
class Move(damage:Int) {

  def attack(character: Character) = {
    character.takes(damage);
  }

}
