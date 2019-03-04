package com.megalexa.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.amazon.identity.auth.device.AuthError
import com.amazon.identity.auth.device.api.Listener
import com.amazon.identity.auth.device.api.authorization.User
import com.megalexa.R
import com.megalexa.adapters.view.BlockViewAdapter
import com.megalexa.adapters.view.WorkflowViewAdapter
import com.megalexa.viewModel.ViewModelMain
import kotlinx.android.synthetic.main.activity_create_workflow.*
import kotlinx.android.synthetic.main.activity_view_block.*

class ViewBlockActivity:AppCompatActivity(), View.OnClickListener {
    companion object {
        private var viewModel : ViewModelMain = ViewModelMain()
    }
    private lateinit var block_names:ArrayList<String>
    private lateinit var rec_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_block)
        val title: String?

        if(savedInstanceState == null){

            val extras :Bundle? = intent.extras
            if(extras==null){
                title="EXTRAS NULLI"
            } else {
                title= extras.getString("WORKFLOW_NAME")
            }

        }else{

            title= savedInstanceState.getSerializable("WORKFLOW_NAME") as String
        }
        workflow_title.text= title

        button_add_blockView.setOnClickListener(this)
        button_cancel_workflow_creationView.setOnClickListener(this)
        User.fetch(this, object: Listener<User, AuthError> {
            override fun onSuccess(p0: User) {
                viewModel.setUser(p0)
                block_names = viewModel.getBlocks(intent.getStringExtra("workflowName"))
                runOnUiThread{
                    rec_view = findViewById(R.id.recyclerView_addedBlocksView)
                    rec_view.layoutManager = LinearLayoutManager(applicationContext)
                    rec_view.adapter = BlockViewAdapter(block_names, applicationContext)
                }
            }
            override fun onError(p0: AuthError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

    override fun onClick(v: View?) {
        when(v) {
            button_continue -> startActivity(Intent(this, CreateBlockActivity::class.java))
            button_cancel_workflow_creation -> startActivity(Intent(this, GeneralLoggedActivity::class.java))
        }
    }

}