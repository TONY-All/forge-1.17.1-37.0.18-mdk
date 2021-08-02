package com.example.examplemod

import com.example.examplemod.gui.AdvancedWorkbenchMenu
import com.example.examplemod.utils.SimpleMenuProvider
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.ContainerLevelAccess
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material
import net.minecraft.world.phys.BlockHitResult

object AdvancedWorkbench : Block(Properties.of(Material.WOOD)) {
    private val CONTAINER_TITLE: Component = TranslatableComponent("container.crafting")

    override fun use(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hand: InteractionHand,
        result: BlockHitResult,
    ): InteractionResult {
        return if (level.isClientSide) {
            InteractionResult.SUCCESS
        } else {
            player.openMenu(state.getMenuProvider(level, pos))
            player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE)
            InteractionResult.CONSUME
        }
    }

    override fun getMenuProvider(state: BlockState, level: Level, pos: BlockPos): MenuProvider {
        return SimpleMenuProvider(CONTAINER_TITLE)
        { invID: Int, inv: Inventory, _: Player ->
            AdvancedWorkbenchMenu(invID, inv, ContainerLevelAccess.create(level, pos))
        }
    }
}