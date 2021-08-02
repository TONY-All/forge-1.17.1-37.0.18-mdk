package com.example.examplemod.utils

import net.minecraft.network.chat.Component
import net.minecraft.world.SimpleMenuProvider
import net.minecraft.world.inventory.MenuConstructor

fun SimpleMenuProvider(component: Component, constructor: MenuConstructor): SimpleMenuProvider {
    return SimpleMenuProvider(constructor, component)


}