package kg.kench.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.kench.lovecalculator.remote.LoveModel

class LoveViewModel: ViewModel() {

    val repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel>{


        return repository.getData(firstName, secondName)
    }
}