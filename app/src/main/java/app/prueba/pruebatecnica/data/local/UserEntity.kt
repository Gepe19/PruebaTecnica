package app.prueba.pruebatecnica.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var lastName: String = "",
    var motherLastName: String = "",
    var birthDate: String = "",
    var country: String = ""

)