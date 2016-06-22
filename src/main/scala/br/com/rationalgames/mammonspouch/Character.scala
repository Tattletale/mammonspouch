package br.com.rationalgames.mammonspouch

/**
  *
  */
class Character(level: Int) {
  var damage = 0
  var life = 0

  def takes(damage: Int) = if(life > 0) life = life - damage

  def move = new Move(damage)

}
