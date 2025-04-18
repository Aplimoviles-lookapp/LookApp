package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "shift")
data  class ShiftEntity (
    @PrimaryKey(autoGenerate = true)
    val shiftId: Long = 0,
    val nameAndLastName:String,
    val businessName:String,
    val date:Date,
    val time:String,
)