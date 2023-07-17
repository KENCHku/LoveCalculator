package kg.kench.lovecalculator.ui.onboard.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(private val pref: SharedPreferences) : ViewModel() {

    fun isUserSeen(): Boolean {
        return pref.getBoolean(KEY_BOARD, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(KEY_BOARD, true).apply()
    }

    companion object {
        const val KEY_PREF = "pref"
        const val KEY_BOARD = "board"
    }

}