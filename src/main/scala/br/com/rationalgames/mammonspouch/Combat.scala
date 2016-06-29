package br.com.rationalgames.mammonspouch

/**
  *
  */
case class Combat(characters: Character*) {

  val order = characters.sorted

  def next = {
    order.iterator.next()
  }

}
