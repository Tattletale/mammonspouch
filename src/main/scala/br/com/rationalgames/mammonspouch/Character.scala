package br.com.rationalgames.mammonspouch

/**
  *
  */
case class Character(level: Int) extends Ordered[Character] {
  var damage = 0
  var life = 0
  var moves = 0

  def takes(damage: Int) = if (life > 0) life = life - damage else throw new IllegalArgumentException("life cannot be lesser then zero")

  def move = {
    moves = moves + 1
    if (moves > 2) throw new IllegalStateException("character cannot move more then 2 times")

    new Move(damage)
  }

  override def compare(that: Character): Int = {
    if (that.level > this.level)
      1
    else if (that.level < this.level)
      -1
    else if (that.isInstanceOf[Hero])
      1
    else
      0
  }
}
