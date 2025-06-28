package app.prueba.pruebatecnica.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getUser(): UserEntity?
    @Insert
    suspend fun insertUser(user: UserEntity)
}