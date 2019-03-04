/*
 * File: BlockAlarmClock.kt
 * Version: 0.1
 * Date: 2019/02/17
 * Author: Andrea Deidda
 *
 * License:
 * History: registro delle modifiche
 * Andrea Deidda || 2019/02/17 || Creating file and header
 * Andrea Deidda || 2019/02/20 || Add methods
 * Andrea Deidda || 2019/02/26 || Add setDate() method
 *
 */
package com.megalexa.models.blocks
import android.media.Ringtone
import org.json.JSONObject
import java.time.Month
import java.util.*
import kotlin.math.min

class BlockAlarmClock(val alarm: Calendar) : Block{
    private val calendar = alarm
    //set calendar

    //Set time method
    fun setTime(hour: Int,minute: Int) {
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
    }
    //Set date method
    fun setDate(y: Int, m: Int, d:Int) {
        calendar.set(Calendar.YEAR,y)
        calendar.set(Calendar.MONTH,m)
        calendar.set(Calendar.DAY_OF_MONTH,d)
    }
    //Return informations about this block
    override fun getInformation() : String{
        return "AlarmClock block creates a personal alarm clock"
    }
    //Return alarm clock set time
    fun alarmTime(): String {
        return "Alarm set at ${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
    }

    override fun toJSON(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}