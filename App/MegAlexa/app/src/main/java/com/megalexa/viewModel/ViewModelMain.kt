package com.megalexa.viewModel


import android.util.Log
import com.megalexa.models.MegAlexa
import com.megalexa.models.User
import com.megalexa.models.blocks.Block
import com.megalexa.models.workflow.Workflow
import com.megalexa.util.GatewayRequests
import org.json.JSONArray
import org.json.JSONObject


class ViewModelMain{


    companion object {
        private var app: MegAlexa = MegAlexa()

    }

    fun saveUser(userID : String, name: String, email: String){
        app.saveUser(com.megalexa.models.User(userID, name, email))
    }

    fun setUser(user: com.amazon.identity.auth.device.api.authorization.User){
        app.setUser(com.megalexa.models.User(user.userId, user.userName, user.userEmail))
    }

    fun fetchWorkflow() : ArrayList<Workflow>{
        return app.loadWorkflow()
    }

    fun haveUserWorkflowName(name: String) : Boolean{
        app.loadWorkflow()
        return app.isPresentWorkflow(name)
    }

    fun getBlocks(name: String) : ArrayList<String>{
        val blocks = app.getBlock(app.getUser(), name)
        val blocksType : ArrayList<String> = ArrayList<String>()
        for(item in blocks!! ){
            blocksType.add(item.getInformation())
        }
        return blocksType
    }

    fun getUser() : User{
        return app.getUser()
    }
    fun saveWorkflow(workflowName : String, blockList: ArrayList<Block>){
        app.saveWorkflow(workflowName, blockList)

    }
    override fun toString(): String {
        return app.getUser().toJSON().toString()
    }

    fun getWorkflow() : ArrayList<Workflow>{
        return app.getWorkflowList()
    }

    fun isUserPresent(paramID:String):Boolean {
        val jsonObject= GatewayRequests.readUser(paramID)

        if(jsonObject.toString()== "")
            return false

        return true
    }
}