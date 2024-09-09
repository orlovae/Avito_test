package ru.alexandrorlov.avito_test.feature.authentication.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.authentication.di.bindmodule.AuthValidatorBindModule
import ru.alexandrorlov.avito_test.feature.authentication.ui.viewmodel.AuthViewModel

@Module(includes = [
    AuthValidatorBindModule::class,
//    RegistrationRepositoryBindModule::class,
])
class AuthModule {

    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    @Provides
    fun provideAuthViewModel(
        passwordValidator: PasswordValidator,
        emailValidator: EmailValidator,
        @Auth
        allDataValidator: AllDataValidator,
//        registrationRepository: RegistrationRepository,
    ): ViewModel =
        AuthViewModel(
            passwordValidator = passwordValidator,
            emailValidator = emailValidator,
            allDataValidator = allDataValidator,
//            registrationRepository = registrationRepository,
        )
}