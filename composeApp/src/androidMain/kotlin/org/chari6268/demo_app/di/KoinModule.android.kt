package org.chari6268.demo_app.di

import org.koin.dsl.module
import org.chari6268.demo_app.database.getDatabaseBuilder

actual val targetModule = module {
    single { getDatabaseBuilder(context = get()) }
}