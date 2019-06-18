package com.example.lineprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import com.example.lineprofile.Parameter.Global
import kotlinx.android.synthetic.main.activity_display_name.*
import java.text.DecimalFormat

class Activity_DisplayName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_name)

        var toolbar =  findViewById(R.id.toolbar_this) as Toolbar
        setSupportActionBar(toolbar)
        this.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        tv_CountWords.text = "0" + "/20"
        et_InputName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                tv_CountWords.text = s!!.length.toString() + "/20"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //tv_CountWords.text = count.toString() + "/20"
            }
        })
        et_InputName.setText(intent.getStringExtra("Name"))
        Btn_Save.setOnClickListener {
            intent.putExtra("Name", et_InputName.text.toString())
            setResult(Global.RESULT_NAME,intent)
            finish()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
