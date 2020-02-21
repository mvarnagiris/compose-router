package com.example.lifelike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Providers
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.example.lifelike.composable.Root
import com.example.lifelike.composable.Root.Routing.LoggedOut
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.routing
import com.github.zsoltk.compose.savedinstancestate.TimeCapsule

class MainActivity : AppCompatActivity() {
    private val backPressHandler = BackPressHandler()
    private val timeCapsule = TimeCapsule()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                backPressHandler.Provider {
                    timeCapsule.Provider(savedInstanceState) {
                        Providers(routing.provides(intent.deepLinkRoute())) {
                            Root.Content(LoggedOut)
                        }
                    }

                }
            }
        }
    }

    override fun onBackPressed() {
        if (!backPressHandler.handle()) {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        timeCapsule.onSaveInstanceState(outState)
    }
}
