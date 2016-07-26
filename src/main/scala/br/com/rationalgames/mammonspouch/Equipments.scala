package br.com.rationalgames.mammonspouch

/**
  * Created by tattletale on 10/07/16.
  */
class Equipments(slots: Class[Equippable]*) {
}

object Equipments {
  //    private def slotsToMap(slots: Class[_<:Equippable]*): HashMap[Class[_ <: Equippable], List[Slot[_ <: Equippable]]] = {
  //        var slotsMap = new HashMap[Class[_<:Equippable], List[Slot[_<:Equippable]]]()
  //        slotsMap += (classOf[PhysicalWeapon] -> List(new Slot[PhysicalWeapon]("a")))
  //
  //        slots.foreach(slot => {
  //            slotsMap.get(slot) match {
  //                case Some(x) => slotsMap += (slot -> (x ::: List(new Slot[slot.type]("bbbb"))))
  //                case None => print()
  //            }
  //        })
  //
  //        slotsMap
  //    }

}