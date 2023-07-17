package kg.kench.lovecalculator.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.kench.lovecalculator.data.local.AppDataBase
import kg.kench.lovecalculator.data.local.LoveDao
import kg.kench.lovecalculator.data.remote.LoveApi
import kg.kench.lovecalculator.ui.onboard.viewmodel.OnBoardViewModel.Companion.KEY_PREF
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModel {

    @Provides
    fun provideGetPercentage(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(KEY_PREF, MODE_PRIVATE)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "love_list")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun dao(@ApplicationContext context: Context): LoveDao {
        return provideDatabase(context).dao()
    }
}
