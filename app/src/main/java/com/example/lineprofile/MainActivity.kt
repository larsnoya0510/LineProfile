package com.example.lineprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.example.lineprofile.Adapter.MultiView_RecycleAdapter
import com.example.lineprofile.Model.GroupData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar =  findViewById(R.id.toolbar_this) as Toolbar
        setSupportActionBar(toolbar)
        this.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        this.getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        var mgroupData= GroupData()
        rv_line.layoutManager = LinearLayoutManager(this)
        val adapter = MultiView_RecycleAdapter(this, mgroupData.m_returnList)
        rv_line.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
