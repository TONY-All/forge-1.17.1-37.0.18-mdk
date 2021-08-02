package com.example.examplemod.gui

import com.example.examplemod.AdvancedWorkbench
import com.example.examplemod.RegistryManager
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.*

class AdvancedWorkbenchMenu(id: Int, inventory: Inventory, levelAccess: ContainerLevelAccess) :
    AbstractContainerMenu(RegistryManager.ADVANCED_WORKBENCH, id) {

    private val craftSlots = CraftingContainer(this, 3, 3)
    private val resultSlots = ResultContainer()
    private val access: ContainerLevelAccess = levelAccess
    private val player: Player = inventory.player

    // 代码去 MaxMC 的 Git
    init {
        addSlot(ResultSlot(inventory.player, this.craftSlots, this.resultSlots, 0, 124, 35))

        for (i in 0..2) {
            for (j in 0..2) {
                addSlot(Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18))
            }
        }
        for (k in 0..2) {
            for (i1 in 0..8) {
                addSlot(Slot(inventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18))
            }
        }
        for (l in 0..8) {
            addSlot(Slot(inventory, l, 8 + l * 18, 142))
        }
    }

    constructor(invId: Int, inventory: Inventory): this(invId, inventory, ContainerLevelAccess.NULL)

    override fun stillValid(player: Player) = stillValid(access, player, AdvancedWorkbench)
}