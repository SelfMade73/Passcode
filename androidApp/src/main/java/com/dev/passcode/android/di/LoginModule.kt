package com.dev.passcode.android.di

import com.dev.passcode.android.domain.PinCodeStatusInteractor
import com.dev.passcode.android.domain.PinCodeStatusInteractorImpl
import com.dev.passcode.android.presentation.viewmodels.PinCodeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val loginModule = Kodein.Module(
    name = "loginModule",
    init = {
        bind<PinCodeStatusInteractor>() with singleton { PinCodeStatusInteractorImpl() }
        bind<PinCodeViewModelFactory>() with singleton { PinCodeViewModelFactory(instance()) }
    }
)
val loginKodein = Kodein{
    import(loginModule)
}