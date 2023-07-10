package kg.kench.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.kench.lovecalculator.remote.LoveModel
import kg.kench.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()
        RetrofitService.api.getPercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel>{
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful){
                        liveLove.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                   Log.e("ololo", "onFailure: ${t.message}")
                }

            })
        return liveLove
    }
}