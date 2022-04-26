package com.example.kotlian_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var network_click : Button
    lateinit var view_text : TextView
    val Restult1 = "Result  #1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        network_click = findViewById<View>(R.id.network_click) as Button





        network_click.setOnClickListener {
            // apply coroutine scope after apply suspanse function
            CoroutineScope(IO).launch {
                TestResult()
            }
        }


    }

    private suspend fun TestResult ()
    {
        val result = getResult_fromApi()
        print("debug: $Restult1")
    }
    // to disoplay the corotuine I need to use suspend function

    private suspend fun getResult_fromApi () : String
    {
        logThreat("getResult_fromApi")
        delay(1000)
        return "Result  #1"
    }

    private fun logThreat (string : String)
    {
        print("dubag: ${string} : ${Thread.currentThread().name}")
    }
}