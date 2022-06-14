package com.example.balance.di

import android.content.Context
import androidx.room.Room
import com.example.balance.data.customer.CustomerDao
import com.example.balance.repo.customer.CustomerRepository
import com.example.balance.repo.customer.CustomerRepositoryImpl
import com.example.balance.data.Db
import com.example.balance.data.material.MaterialDao
import com.example.balance.data.user.UserDao
import com.example.balance.data.user_settings.UserSettingsDao
import com.example.balance.data.vehicle.VehicleDao
import com.example.balance.repo.material.MaterialRepository
import com.example.balance.repo.material.MaterialRepositoryImpl
import com.example.balance.repo.user.UserRepository
import com.example.balance.repo.user.UserRepositoryImpl
import com.example.balance.repo.user_settings.UserSettingsRepository
import com.example.balance.repo.user_settings.UserSettingsRepositoryImpl
import com.example.balance.repo.vehicle.VehicleRepository
import com.example.balance.repo.vehicle.VehicleRepositoryImpl
//import com.example.balance.data.customer_vehicle.CustomerVehicleDao
//import com.example.balance.repo.customer_vehicle.CustomerVehicleRepository
//import com.example.balance.repo.customer_vehicle.CustomerVehicleRepositoryImpl
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
    ).build()

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