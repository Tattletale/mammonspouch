package br.com.rationalgames.mammonspouch

/**
  *
  */
case class Combat(characters: Character*) {

  val order = characters.sorted

  val iterator = order.iterator

  def next = {
    iterator.next()
  }

}
