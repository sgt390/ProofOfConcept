package com.megalexa.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.amazon.identity.auth.device.AuthError
import com.amazon.identity.auth.device.api.Listener
import com.amazon.identity.auth.device.api.authorization.User
import com.megalexa.R
import com.megalexa.adapters.view.BlockViewAdapter
import com.megalexa.models.blocks.Block
import com.megalexa.models.blocks.BlockFeedRss
import com.megalexa.models.blocks.BlockTextBox
import com.megalexa.viewModel.ViewModelMain
import kotlinx.android.synthetic.main.activity_create_workflow.*
import kotlinx.android.synthetic.main.activity_view_block.*
import java.io.Serializable
import kotlin.concurrent.thread

class CreateWorkflowActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var block_names:ArrayList<String>
    private lateinit var rec_view: RecyclerView

    companion object {
        private var viewModel : ViewModelMain = ViewModelMain()
    }
    var blockList : ArrayList<Block> = ArrayList()
    var blocknames: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workflow)

        val buttonContinue : View=  findViewById(R.id.button_continue)

        buttonContinue.setOnClickListener(this)
        button_cancel_workflow_creation.setOnClickListener(this)
        button_save_workflow.setOnClickListener(this)
        User.fetch(this, object: Listener<User, AuthError> {
            override fun onSuccess(p0: User) {
                viewModel.setUser(p0)
                runOnUiThread {
                    rec_view = findViewById(R.id.recyclerView_addedBlocksOnCreation)
                    rec_view.layoutManager = LinearLayoutManager(applicationContext)
                    rec_view.adapter = BlockViewAdapter(blocknames, applicationContext)
                }

            }
            override fun onError(p0: AuthError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

    override fun onClick(v: View?) {
        when(v) {
            button_continue -> {
                thread (start = true) {
                    val workflowTitle=findViewById<TextView>(R.id.input_title_workflow).text.toString()
                    val isPresent = viewModel.haveUserWorkflowName(workflowTitle)
                    runOnUiThread {
                        if (isPresent) {
                           Toast.makeText(this,"workflow name must be unique",Toast.LENGTH_SHORT).show()
                        } else {
                            val newIntent = Intent(this, CreateBlockActivity::class.java)
                            newIntent.putExtra("blockList", blockList as Serializable)
                            startActivityForResult(newIntent,1)
                        }
                    }
                }
            }
            button_save_workflow -> {
                thread (start = true) {

                    viewModel.saveWorkflow(findViewById<TextView>(R.id.input_title_workflow).text.toString(), blockList)
                    runOnUiThread{
                        startActivity(Intent(this, GeneralLoggedActivity::class.java))
                    }
                }
            }
            button_cancel_workflow_creation -> startActivity(Intent(this, GeneralLoggedActivity::class.java))

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1) {
            if(resultCode==Activity.RESULT_OK) {
                val blockType:String?
                blockType = data!!.extras!!.getString("block_type")

                when(blockType){

                    "Text to speech" -> {
                        val block= BlockTextBox(data!!.extras!!.get("text").toString())
                        blockList.add(block)
                        blocknames.add(block.getInformation())
                    }

                    "FeedRss" -> {

                        val block=BlockFeedRss(data!!.extras!!.get("feedRss").toString())
                        blockList.add(block)
                        blocknames.add(block.getInformation())
                    }

                }
            }


        }

    }

    fun getDebugBlocks(): ArrayList<String>{
        return arrayListOf("Block1","Block2","Block3","Block4","Block5")

    }


}