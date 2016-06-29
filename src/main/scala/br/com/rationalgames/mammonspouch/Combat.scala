package br.com.rationalgames.mammonspouch

/**
  *
  */
case class Combat(characters: Character*) {

  val order = characters.sorted
  val first = next
  val second = next

  def next = {
    order.iterator.next()
  }

}
