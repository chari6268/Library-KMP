package org.chari6268.demo_app

import androidx.compose.ui.window.ComposeUIViewController
import org.chari6268.demo_app.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }