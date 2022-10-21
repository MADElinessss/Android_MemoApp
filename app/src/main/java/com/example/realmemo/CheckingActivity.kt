package com.example.realmemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realmemo.databinding.ActivityCheckingBinding
import kotlinx.android.synthetic.main.activity_checking.*
import kotlinx.android.synthetic.main.activity_main.*
var i : Int = 0
var data1 : String = ""
var data2 : String = ""
var data3 : String = ""
class CheckingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCheckingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCheckingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        i++
        if(i==1){
            text1.text = intent.getStringExtra("Memo")
            viewBinding.btnNewmemo.setOnClickListener{
                startActivity(Intent(this, MainActivity::class.java))
            }
            viewBinding.btnDelete.setOnClickListener{
                text1.text = null
            }
        }
        else if(i==2){
            text2.text = intent.getStringExtra("Memo")
            viewBinding.btnNewmemo.setOnClickListener{
                startActivity(Intent(this, MainActivity::class.java))
            }
            viewBinding.btnDelete.setOnClickListener{
                text2.text = null
            }
        }
        else{
            text3.text = intent.getStringExtra("Memo")
            viewBinding.btnNewmemo.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
            viewBinding.btnDelete.setOnClickListener{
                text3.text = null
            }
        }

    }
}