package org.chari6268.demo_app.di

import org.chari6268.demo_app.data.getRoomDatabase
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.core.module.dsl.*
import org.chari6268.demo_app.presentation.screen.home.HomeViewModel
import org.chari6268.demo_app.presentation.screen.manage.ManageViewModel
import org.chari6268.demo_app.presentation.screen.details.DetailsViewModel

expect val targetModule: Module

val sharedModule = module {
    single { getRoomDatabase(get()) }
    viewModelOf(::HomeViewModel)
    viewModelOf(::ManageViewModel)
    viewModelOf(::DetailsViewModel)
}

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(targetModule, sharedModule)
    }
}