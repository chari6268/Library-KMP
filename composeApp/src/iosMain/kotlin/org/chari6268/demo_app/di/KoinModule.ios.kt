package org.chari6268.demo_app.di

import org.chari6268.demo_app.database.getDatabaseBuilder
import org.koin.dsl.module

actual val targetModule = module {
    single { getDatabaseBuilder() }
}