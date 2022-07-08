package com.example.balance.data.db

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

/*
import androidx.room.TypeConverter
import java.sql.Date
/////////////////////////////////////////////////////////////////
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}*/

/////////////////////////////////////////////////////////////////
/* wip mathieu
class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Calendar? {
        return value?.let { Calendar.getInstance().apply { timeInMillis = it } }
    }

    @TypeConverter
    fun dateToTimestamp(calendar: Calendar?): Long? {
        return calendar?.timeInMillis
    }
}
*/
/////////////////////////////////////////////////////////////////
/* mathieu
val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
val currentDate = sdf.format(Date())
 */
/////////////////////////////////////////////////////////////////