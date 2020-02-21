package com.github.zsoltk.compose.savedinstancestate

import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.Providers

class TimeCapsule {
    private var savedInstanceState: Bundle = Bundle()

    @Composable
    fun Provider(savedInstanceState: Bundle?, children: @Composable() () -> Unit) {
        this.savedInstanceState = savedInstanceState?.getBundle(KEY) ?: Bundle()

        Providers(com.github.zsoltk.compose.savedinstancestate.savedInstanceState.provides(this.savedInstanceState)) {
            children()
        }
    }

    fun onSaveInstanceState(outState: Bundle) {
        outState.putBundle(KEY, savedInstanceState)
    }

    companion object {
        private const val KEY = "TimeCapsule.Root"
    }
}
