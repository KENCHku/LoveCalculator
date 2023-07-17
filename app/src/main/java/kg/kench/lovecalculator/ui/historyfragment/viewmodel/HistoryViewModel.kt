package kg.kench.lovecalculator.ui.historyfragment.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.kench.lovecalculator.model.LoveModel
import kg.kench.lovecalculator.repository.Repository
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getData(): List<LoveModel> {
        return repository.getData()
    }
}