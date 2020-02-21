package com.github.zsoltk.compose.backpress

import androidx.compose.Composable
import androidx.compose.ProvidableAmbient
import androidx.compose.Providers
import androidx.compose.ambientOf

internal val backPressHandler: ProvidableAmbient<BackPressHandler> =
        ambientOf { throw IllegalStateException("backPressHandler is not initialized") }


class BackPressHandler(
        val id: String = "Root"
) {
    var children = mutableListOf<() -> Boolean>()

    fun handle(): Boolean =
            children.reversed().any { it() }

    @Composable
    fun Provider(children: @Composable() () -> Unit) {
        Providers(backPressHandler.provides(this)) {
            children()
        }
    }
}

