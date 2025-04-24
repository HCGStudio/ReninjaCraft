package com.hcgstudio.reninjacraft.ninjutsu

interface Ninjutsu {
    val soundId: String
    val castSequence: List<NinjutsuKeys>
    val rekaraCost: Int
    val coolDown: Int
    val handCost: Int
    fun canCast(): Boolean
    fun cast()
}
