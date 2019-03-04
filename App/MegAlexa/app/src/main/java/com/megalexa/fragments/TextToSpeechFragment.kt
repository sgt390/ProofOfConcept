package com.megalexa.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.megalexa.R
import com.megalexa.activities.CreateBlockActivity
import com.megalexa.models.blocks.BlockTextBox

class TextToSpeechFragment: Fragment(){

    private var text =  ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.text_to_speech_fragment_layout,container,false)

        val button= view.findViewById<Button>(R.id.confirm_button)
        val editText= view.findViewById<EditText>(R.id.insert_text)

        button.setOnClickListener {
            if(editText.text.toString() == "") {
                Toast.makeText(context, "text is empty", Toast.LENGTH_SHORT).show()
            }
            else{
                text= editText.text.toString()
                val activity= activity as CreateBlockActivity
                activity.onFragmentClick(this)
            }

        }


        return view
    }

    fun getText(): String{
        return text
    }

}