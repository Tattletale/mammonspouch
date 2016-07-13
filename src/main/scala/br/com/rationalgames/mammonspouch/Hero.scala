package br.com.rationalgames.mammonspouch

/**
  *
  */
class Hero(level: Int) extends Character(level) {
    private val equipments: Equipments = new Equipments
    private var _physicalWeapon: PhysicalWeapon = null
    private var _rangedWeapon: RangedWeapon = null
    private var _sigil: Sigil = null
    private var _armor: Armor = null

    def physicalWeapon() = _physicalWeapon
    def rangedWeapon() = _rangedWeapon
    def sigil() = _sigil
    def armor() = _armor

    def equip(aPhysicalWeapon: PhysicalWeapon) = _physicalWeapon = aPhysicalWeapon
    def equip(aSigil: Sigil) = _sigil = aSigil
    def equip(aRangedWeapon: RangedWeapon) = _rangedWeapon = aRangedWeapon
    def equip(anArmor: Armor) = _armor = anArmor
}