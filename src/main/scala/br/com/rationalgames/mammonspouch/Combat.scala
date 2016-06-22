package br.com.rationalgames.mammonspouch

/**
  *
  */
case class Combat(hero: Hero, monster: Monster) {

  val first = if (hero.level >= monster.level) hero else monster


  val second = if (first.isInstanceOf[Hero]) monster else hero

}
