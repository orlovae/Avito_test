package ru.alexandrorlov.avito_test

import android.app.Application
import ru.alexandrorlov.avito_test.di.AppComponent
import ru.alexandrorlov.avito_test.di.DaggerAppComponent
import ru.alexandrorlov.avito_test.feature.authentication.di.AuthComponent
import ru.alexandrorlov.avito_test.feature.authentication.di.DaggerAuthComponent
import ru.alexandrorlov.avito_test.feature.product.di.DaggerProductComponent
import ru.alexandrorlov.avito_test.feature.product.di.ProductComponent
import ru.alexandrorlov.avito_test.feature.product_detail.di.DaggerProductDetailComponent
import ru.alexandrorlov.avito_test.feature.product_detail.di.ProductDetailComponent
import ru.alexandrorlov.avito_test.feature.registration.di.DaggerRegistrationComponent
import ru.alexandrorlov.avito_test.feature.registration.di.RegistrationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)

        registrationComponent = DaggerRegistrationComponent.factory().create(
            dependencies = appComponent,
        )

        authComponent = DaggerAuthComponent.factory().create(
            dependencies = appComponent,
        )

        productListComponent = DaggerProductComponent.factory().create(
            dependencies = appComponent,
        )

        productDetailComponent = DaggerProductDetailComponent.factory().create(
            dependencies = appComponent,
        )
    }

    companion object {
        private lateinit var appComponent: AppComponent
        lateinit var registrationComponent: RegistrationComponent
        lateinit var authComponent: AuthComponent
        lateinit var productListComponent: ProductComponent
        lateinit var productDetailComponent: ProductDetailComponent
    }
}
