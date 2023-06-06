package com.example.hauntedhaven.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HauntedPlace")
data class HauntedPlace(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "quick_desc") val quick_desc: String?,
    @ColumnInfo(name = "event_desc") val event_desc: String?,
    @ColumnInfo(name = "sleep_available") val sleep_available: Int?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "available_ppl") val available_ppl: Int?,
    @ColumnInfo(name = "desc") val desc: String?,
    @ColumnInfo(name = "warning") val warning: String?,
    @ColumnInfo(name = "imageUri") val imageUri: String?,
    @ColumnInfo(name = "category") val category: String?
)
