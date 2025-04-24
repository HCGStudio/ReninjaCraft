package com.hcgstudio.reninjacraft.ninjutsu

class ShakeShakeHand : Ninjutsu {
    override val soundId = "shake_shake_hand"

    override val rekaraCost = 100

    override val coolDown = 20

    override val handCost = -1

    override val castSequence: List<NinjutsuKeys> = listOf(
        NinjutsuKeys.Right,
        NinjutsuKeys.Right,
        NinjutsuKeys.Up
    )

    override fun canCast(): Boolean {
        return true
    }

    override fun cast() {
    }
}
