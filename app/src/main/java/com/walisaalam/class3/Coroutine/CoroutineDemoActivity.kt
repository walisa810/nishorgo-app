package com.walisaalam.class3.Coroutine

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.walisaalam.class3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineDemoActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var btnAction: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coroutine_demo)
        tvResult = findViewById(R.id.tvResult)
        btnAction = findViewById(R.id.btnAction)

        btnAction.setOnClickListener{
            lifecycleScope.launch(Dispatchers.Main){
                //showUpdate("Loading...")
                val token = fetchLatestToken()
                showUpdate(token)
                val userId = fetchUserId(token)
                showUpdate(userId)
                val profileInfo = fetchProfileInfo(userId)
                showUpdate(profileInfo)
            }
//            fetchLatestToken{ token ->
//                showUpdate(token)
//
//                fetchUserId(token){ userId ->
//                    showUpdate(userId)
//
//                    fetchProfileInfo(userId) { profileInfo ->
//                        showUpdate(profileInfo)
//
//                    }
//                }
//
//            }
        }
    }
    private fun showUpdate( value: String){
        runOnUiThread{ tvResult.text = value }
    }
//    private fun fetchLatestToken(callback: (String) -> Unit){
//        Thread{
//            Thread.sleep(3000)
//            callback("Token Vlue 1sdasdsdsda")
//        }.start()
//    }
//    private fun fetchUserId(token: String, callback: (String) -> Unit){
//        Thread{
//            Thread.sleep(3000)
//            callback("User id 1234")
//        }.start()
//    }
//    private fun fetchProfileInfo(userId: String, callback: (String) -> Unit){
//        Thread{
//            Thread.sleep(3000)
//            callback("This is profile info")
//        }.start()
//    }
    suspend fun fetchLatestToken(): String{
        return withContext(Dispatchers.IO) {
            delay(3000)
            "Token Value 1sdasdsdsda"
        }
    }
    suspend fun fetchUserId(token: String): String {
        return withContext(Dispatchers.IO) {
            delay(3000)
            "User id 1234"
        }
    }
    suspend fun fetchProfileInfo(userId: String): String {
        return withContext(Dispatchers.IO) {
            delay(3000)
            "This is profile Info"
        }
    }
}