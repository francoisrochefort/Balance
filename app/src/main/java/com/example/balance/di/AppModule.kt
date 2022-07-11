package com.example.balance.di

import android.content.Context
import androidx.room.Room
import com.example.balance.data.db.Converters
import com.example.balance.data.db.customer.CustomerDao
import com.example.balance.repo.customer.CustomerRepository
import com.example.balance.repo.customer.CustomerRepositoryImpl
import com.example.balance.data.db.Db
import com.example.balance.data.db.material.MaterialDao
import com.example.balance.data.db.user.UserDao
import com.example.balance.data.db.user_settings.UserSettingsDao
import com.example.balance.data.db.vehicle.VehicleDao
import com.example.balance.repo.material.MaterialRepository
import com.example.balance.repo.material.MaterialRepositoryImpl
import com.example.balance.repo.user.UserRepository
import com.example.balance.repo.user.UserRepositoryImpl
import com.example.balance.repo.user_settings.UserSettingsRepository
import com.example.balance.repo.user_settings.UserSettingsRepositoryImpl
import com.example.balance.repo.vehicle.VehicleRepository
import com.example.balance.repo.vehicle.VehicleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
            context,
            Db::class.java,
            "balance"
        )
        .addTypeConverter(Converters())
        .build()

    @Provides
    fun provideCustomerDao(
        db: Db
    ) = db.customerDao()

    @Provides
    fun provideVehicleDao(
        db: Db
    ) = db.vehicleDao()

    @Provides
    fun provideMaterialDao(
        db: Db
    ) = db.materialDao()

    @Provides
    fun provideUserDao(
        db: Db
    ) = db.userDao()

    @Provides
    fun provideUserSettingsDao(
        db: Db
    ) = db.userSettingsDao()

    @Provides
    fun provideCustomerRepository(
        customerDao: CustomerDao
    ): CustomerRepository = CustomerRepositoryImpl(customerDao)

    @Provides
    fun provideVehicleRepository(
        vehicleDao: VehicleDao
    ): VehicleRepository = VehicleRepositoryImpl(vehicleDao)

    @Provides
    fun provideMaterialRepository(
        materialDao: MaterialDao
    ): MaterialRepository = MaterialRepositoryImpl(materialDao)

    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository = UserRepositoryImpl(userDao)

    @Provides
    fun provideUserSettingsRepository(
        userSettingsDao: UserSettingsDao
    ): UserSettingsRepository = UserSettingsRepositoryImpl(userSettingsDao)

}