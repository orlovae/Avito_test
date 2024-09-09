package ru.alexandrorlov.avito_test.feature.registration.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.authentication.di.ViewModelKey
import ru.alexandrorlov.avito_test.feature.registration.di.bindmodule.RegistrationRepositoryBindModule
import ru.alexandrorlov.avito_test.feature.registration.di.bindmodule.RegistrationValidatorBindModule
import ru.alexandrorlov.avito_test.feature.registration.domain.repository.RegistrationRepository
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.NameValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.viewmodel.RegistrationViewModel

@Module(includes = [
    RegistrationValidatorBindModule::class,
    RegistrationRepositoryBindModule::class,
])
class RegistrationModule {

    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    @Provides
    fun provideRegistrationViewModel(
        nameValidator: NameValidator,
        passwordValidator: PasswordValidator,
        emailValidator: EmailValidator,
        @Registration
        allDataValidator: AllDataValidator,
        registrationRepository: RegistrationRepository,
    ): ViewModel =
        RegistrationViewModel(
            nameValidator = nameValidator,
            passwordValidator = passwordValidator,
            emailValidator = emailValidator,
            allDataValidator = allDataValidator,
            registrationRepository = registrationRepository,
        )
}