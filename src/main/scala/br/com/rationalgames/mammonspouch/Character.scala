package br.com.rationalgames.mammonspouch

/**
  *
  */
class Character(level: Int) {
  var damage = 0
  var life = 0

  def takes(damage: Int) = if(life > 0) life = life - damage

  var moves = 0

  def move = {
    moves = moves + 1
    if(moves > 2) {
      throw new IllegalStateException()
    }
    new Move(damage)
  }

}
