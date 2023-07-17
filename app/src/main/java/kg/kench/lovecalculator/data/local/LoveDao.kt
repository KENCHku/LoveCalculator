package kg.kench.lovecalculator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kg.kench.lovecalculator.model.LoveModel

@Dao
interface LoveDao {
    @Query("SELECT * FROM love_list ORDER BY id DESC")
    fun getList(): List<LoveModel>

    @Insert
    fun addData(loveModel: LoveModel)
}