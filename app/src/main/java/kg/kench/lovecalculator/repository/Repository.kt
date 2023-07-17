package kg.kench.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.kench.lovecalculator.data.local.LoveDao
import kg.kench.lovecalculator.data.remote.LoveApi
import kg.kench.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val dao: LoveDao) {
    fun insert(loveModel: LoveModel) {
        dao.addData(loveModel)
    }

    fun getData(): List<LoveModel> {
        return dao.getList()
    }

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()
        api.getPercentAge(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        liveLove.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("shalala", "onFailure:${t.message} ")
                }
            })
        return liveLove
    }
}