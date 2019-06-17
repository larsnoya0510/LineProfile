package com.example.lineprofile.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.lineprofile.Activity_Empty
import com.example.lineprofile.Model.LineDataSet
import com.example.lineprofile.R

class MultiView_RecycleAdapter(
    private val context: Context,
    private val dataList: MutableList<LineDataSet>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mContext: Context
    val inflater: LayoutInflater = LayoutInflater.from(context)
    val ViewType_Item = 0
    val ViewType_Group = 1
    lateinit var mRecyclerViewHolder: RecyclerView.ViewHolder
    override fun getItemViewType(position: Int): Int {
        if(dataList[position].micon == 0 && dataList[position].mclass==Activity_Empty::class.java){
            Log.d("multi","getItemViewType viewType ViewType_String")
            return ViewType_Group
        }
        else {
            Log.d("multi","getItemViewType viewType ViewType_Img")
            return ViewType_Item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mContext = parent.getContext()
        if (viewType == ViewType_Item) {
            Log.d("multi","viewType ViewType_Img")
            var view = inflater.inflate(R.layout.item_item_rv, parent, false)
            mRecyclerViewHolder= ViewType_Item_ViewHolder(view)
        } else if (viewType == ViewType_Group) {
            Log.d("multi","viewType ViewType_String")
            var view = inflater.inflate(R.layout.item_group_rv, parent, false)
            mRecyclerViewHolder= ViewType_Group_ViewHolder(view)
        }
        return mRecyclerViewHolder
    }

    override fun getItemCount(): Int {
        Log.d("multi","dataList.size "+dataList.size)
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewType_Item_ViewHolder){
            Glide.with(this.context).load(dataList[position].micon).into(holder.iv_icon)
            holder.tv_item.text=dataList[position].mtitle
            if(dataList[position].mclass != Activity_Empty::class.java) {
                holder.ll_item.setOnClickListener {
                    var m_intent =Intent(this.context,(dataList[position].mclass))
                    context.startActivity(m_intent)
                }
            }
        }
        else if (holder is ViewType_Group_ViewHolder){
            holder.tv_text.text=dataList[position].mtitle
        }
    }

    class ViewType_Item_ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ll_item = view.findViewById<LinearLayout>(R.id.ll_item)
        var iv_icon = view.findViewById<ImageView>(R.id.iv_icon)
        var tv_item = view.findViewById<TextView>(R.id.tv_item)
    }
    class ViewType_Group_ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_text = view.findViewById<TextView>(R.id.tv_groupTitle)
        //var Btn_Text = view.findViewById<Button>(R.id.Btn_Money)
    }
}