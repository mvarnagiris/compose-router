package com.example.lifelike.composable.loggedin

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Spacer
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.lifelike.entity.User


interface Profile {

    companion object {
        @Composable
        fun Content(user: User, onLogout: () -> Unit) {
            Column(
                modifier = LayoutHeight.Fill + LayoutPadding(40.dp),
                arrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "You are logged in as:",
                    style = MaterialTheme.typography().h4
                )
                Column {
                    Text(
                        text = user.name,
                        style = MaterialTheme.typography().h5
                    )
                    Spacer(modifier = LayoutHeight(16.dp))
                    Text(
                        text = user.phone,
                        style = MaterialTheme.typography().h5
                    )
                }
                Button(onClick = onLogout) {
                    Text(text = "Log out")
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    Profile.Content(user = User("Demo user", "123456789"), onLogout = {})
}
