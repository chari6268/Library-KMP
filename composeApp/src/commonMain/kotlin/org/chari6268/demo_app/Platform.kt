package org.chari6268.demo_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform