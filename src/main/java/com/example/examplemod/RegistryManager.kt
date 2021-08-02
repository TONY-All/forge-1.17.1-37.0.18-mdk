package com.example.examplemod

import com.example.examplemod.gui.AdvancedWorkbenchMenu
import net.minecraft.core.Registry
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.minecraft.world.inventory.MenuType.MenuSupplier

object RegistryManager {
    val ADVANCED_WORKBENCH = register("advanced_crafting") { id, inventory -> AdvancedWorkbenchMenu(id, inventory) }

    private fun <T : AbstractContainerMenu> register(name: String, supplier: MenuSupplier<T>): MenuType<T> {
        return Registry.register(Registry.MENU, name, MenuType(supplier))
    }
}