package com.example.lineprofile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.lineprofile.Parameter.Global
import kotlinx.android.synthetic.main.activity__myprofile.*

class Activity_Myprofile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__myprofile)

        Glide.with(this).load(R.drawable.view01).into(iv_background)

        var toolbar = findViewById(R.id.toolbar_this) as Toolbar
        setSupportActionBar(toolbar)
        this.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        fl_name.setOnClickListener {
            var mIntent = Intent(this, Activity_DisplayName::class.java)
            mIntent.putExtra("Name",tv_nameValue.text)
            startActivityForResult(mIntent, Global.REQUEST_NAME)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Global.REQUEST_NAME && resultCode == Global.RESULT_NAME) {
            tv_nameValue.text = data?.getStringExtra("Name")
        }
    }
}