package com.example.realmemo

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.example.realmemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_checking.*
import kotlinx.android.synthetic.main.activity_main.*

//import com.example.realmemo.databinding.ActivityMainBinding
var data : String = ""
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ActionBar 숨기기(어플 맨 위)
        val actionbar : ActionBar? = supportActionBar
        actionbar?.hide()

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener{
            data = input_text.text.toString()
            val intent = Intent(this, CheckingActivity::class.java)
            intent.putExtra("Memo",data)
            startActivity(intent)
        }

        Log.d("Lifecycle","onCreate")
    }

    override fun onPause() {
        super.onPause()
        data = input_text.text.toString()
        //전역변수..?
    }

    override fun onResume() {
        super.onResume()
        val text_onresume = data.toString()
    }

    override fun onRestart() {
        super.onRestart()
        //Dialog 팝업창 띄우기!
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Memo")
        builder.setMessage("Would you restart the memo?")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setPositiveButton("YES",DialogInterface.OnClickListener{ dialog, id ->
            //Start Button 클릭 시 수행
            input_text.setText(null)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, id ->
            //Cancel Button 클릭 시 수행
        })
        builder.create()
        builder.show()
    }
}