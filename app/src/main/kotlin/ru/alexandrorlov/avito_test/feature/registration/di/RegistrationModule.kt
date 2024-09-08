package ru.alexandrorlov.avito_test.feature.registration.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.feature.registration.di.bindmodule.RegistrationBindModule
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.EmailValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.viewmodel.RegistrationViewModel

@Module(includes = [
    RegistrationBindModule::class,
])
class RegistrationModule {

    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    @Provides
    fun provideRegistrationViewModel(
        passwordValidator: PasswordValidator,
        emailValidator: EmailValidator,
        allDataValidator: AllDataValidator,
    ): ViewModel =
        RegistrationViewModel(
            passwordValidator = passwordValidator,
            emailValidator = emailValidator,
            allDataValidator = allDataValidator,
        )
}