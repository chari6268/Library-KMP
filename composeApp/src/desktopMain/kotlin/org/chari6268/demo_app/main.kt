package org.chari6268.demo_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DemoApp",
    ) {
        App()
    }
}