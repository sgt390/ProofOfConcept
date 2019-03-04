package com.megalexa.activities


import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.os.Bundle
import android.os.WorkSource
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItem
import android.util.Log
import android.view.View
import android.widget.*
import com.megalexa.R
import com.megalexa.adapters.view.ListArrayAdapter
import com.megalexa.fragments.AlarmClockFragment
import com.megalexa.fragments.RssFragment
import com.megalexa.fragments.TextToSpeechFragment
import com.megalexa.models.MegAlexa
import com.megalexa.models.blocks.Block
import com.megalexa.models.workflow.Workflow
import com.megalexa.util.FragmentClickListener
import com.megalexa.viewModel.ViewModelMain
import kotlinx.android.synthetic.main.activity_create_block.*


class CreateBlockActivity: AppCompatActivity(), View.OnClickListener,FragmentClickListener {

    private lateinit var listView: ListView
    companion object {
        private var viewModel = ViewModelMain()
    }
    private var blockList = ArrayList<Block>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_block)

        listView = findViewById(R.id.view_blocks)
        val blockList = getBlockList()


        listView.adapter = ListArrayAdapter(this, blockList)

        button_cancel_block.setOnClickListener(this)

        var fragment: Fragment

        listView.setOnItemClickListener{

             _ ,_ ,position, _ ->

            when(position){
                0 -> {
                    fragment = RssFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment_container, fragment).addToBackStack("").commit()
                }
                1-> {
                    fragment = TextToSpeechFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment_container, fragment).addToBackStack("").commit()

                }
            }

        }


    }

    override fun onFragmentClick(sender: Fragment) {


        if(sender is RssFragment){
            val url = sender.getUrl()
            val intent = Intent(this,CreateWorkflowActivity::class.java)
            intent.putExtra("block_type", "FeedRss")
            intent.putExtra("feedRss",url)
            setResult(Activity.RESULT_OK, intent)
            finish()


        }else if(sender is TextToSpeechFragment){
            val text= sender.getText()
            val intent = Intent(this,CreateWorkflowActivity::class.java)
            intent.putExtra("block_type", "Text to speech")
            intent.putExtra("text",text)
            setResult(Activity.RESULT_OK,intent)
            finish()

        }
    }

    override fun onClick(view: View) {


    when(view.id){
        R.id.button_cancel_block -> {
            this.finish()
        }
    }


    }


    private fun getBlockList(): List<Pair<String, Int>> {

        val list = getTitlesList()
        //more pairs to be added
        return listOf(
            Pair(list[0], R.drawable.ic_feed_rss),
            Pair(list[1], R.drawable.ic_text)
        )

    }


    private fun getTitlesList(): List<String> {

        return listOf("Add FeedRSS","Add Text Block")

    }

    fun getModel() : ArrayList<Workflow>{
        return viewModel.getWorkflow()
    }



}
