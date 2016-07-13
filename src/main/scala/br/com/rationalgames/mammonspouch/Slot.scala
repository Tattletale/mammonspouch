package br.com.rationalgames.mammonspouch

/**
  * Created by tattletale on 10/07/16.
  */
class Slot[T<:Equippable](val slotType: String) {
}

object Slot {
    def main(args: Array[String]): Unit = {
        print(new Slot[PhysicalWeapon]("banana").slotType)
    }
}