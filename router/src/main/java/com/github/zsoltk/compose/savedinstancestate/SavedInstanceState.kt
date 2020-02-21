package com.github.zsoltk.compose.savedinstancestate

import android.os.Bundle
import androidx.compose.Ambient
import androidx.compose.ambientOf

val savedInstanceState = ambientOf { Bundle() }
