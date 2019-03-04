/*
* File: AlarmClockFragment.kt
* Version: 0.0.1
* Date: 2019-02-23
* Author: Andrea Deidda
* License:
*
* History:
* Author           || Date         || Description
* Andrea Deidda    || 2019-02-23   || creating file and header
* Andrea Deidda    || 2019-02-25   || Insert methods
*/
package com.megalexa.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.megalexa.R
import java.util.*


class AlarmClockFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.layout_alarmclock,container,false)
        val button= view.findViewById<Button>(R.id.setButton)

        //alarm clock informations

        val day = view.findViewById<EditText>(R.id.editDay).text.toString()
        val month= view.findViewById<EditText>(R.id.editMonth).text.toString()
        val year = view.findViewById<EditText>(R.id.editYear).text.toString()
        val hour = view.findViewById<EditText>(R.id.editHour).text.toString()
        val minute = view.findViewById<EditText>(R.id.editMinutes).text.toString()

        val calendar= Calendar.getInstance()
        calendar.set(Integer.parseInt(month),Integer.parseInt(year),
            Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute),0)

        
        button.setOnClickListener {

            //ViewModel.addAlarmBlock()
            Toast.makeText(view.context,"Button Clicked",Toast.LENGTH_SHORT).show()
        }
        return view
    }

}