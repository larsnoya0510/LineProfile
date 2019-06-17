package com.example.lineprofile.Model

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.lineprofile.Activity_Empty
import com.example.lineprofile.Activity_Myprofile
import com.example.lineprofile.R

class GroupData {
    var type="group"
    var m_returnList: MutableList<LineDataSet>
    private val groupArray = arrayOf(
        "我的資訊",
        "商店",
        "基本設定",
        "詳細資訊"
    )

    init {
        var data = LineDataSet(" ", 0, Activity_Empty::class.java)

        m_returnList= arrayListOf(data)
        m_returnList = getItem()
    }

    fun getsubItem(m_String: String): MutableList<LineDataSet> {
        when (m_String) {
            groupArray[0] -> {
                var mDataModel = DataModel()
                mDataModel.mtitleList = MyInfo.Info.toMutableList()
                mDataModel.miconList = MyInfo.InfoIcon.toMutableList()
                mDataModel.mclassList = MyInfo.mappingActivity.toMutableList()
                m_returnList.addAll(mDataModel.GetData())
            }
            groupArray[1] -> {
                var mDataModel = DataModel()
                mDataModel.mtitleList = ShopInfo.Info.toMutableList()
                mDataModel.miconList = ShopInfo.InfoIcon.toMutableList()
                mDataModel.mclassList = ShopInfo.mappingActivity.toMutableList()
                m_returnList.addAll(mDataModel.GetData())
            }
            groupArray[2] -> {
                var mDataModel = DataModel()
                mDataModel.mtitleList = BasicSetting.Info.toMutableList()
                mDataModel.miconList = BasicSetting.InfoIcon.toMutableList()
                mDataModel.mclassList = BasicSetting.mappingActivity.toMutableList()
                m_returnList.addAll(mDataModel.GetData())
            }
            groupArray[3] -> {
                var mDataModel = DataModel()
                mDataModel.mtitleList = DetialInfo.Info.toMutableList()
                mDataModel.miconList = DetialInfo.InfoIcon.toMutableList()
                mDataModel.mclassList = DetialInfo.mappingActivity.toMutableList()
                m_returnList.addAll(mDataModel.GetData())
            }
        }
        return m_returnList
    }

    fun getItem(): MutableList<LineDataSet> {
        for (i in 0 until groupArray.size) {
            Log.d("watch","groupArray[i] "+groupArray[i])
            var data = LineDataSet(groupArray[i], 0, Activity_Empty::class.java)
            Log.d("watch","m_returnList "+m_returnList)
            m_returnList.add(data)
            getsubItem(groupArray[i])
        }
        return m_returnList
    }
}

class MyInfo {
    companion object {
        val Info = arrayOf(
            "個人檔案", "我的帳號", "隱私設定", "移動帳號設定", "Keep"
        )
        val InfoIcon = intArrayOf(
            R.drawable.personprofile,
            R.drawable.myaccount,
            R.drawable.privatesetting,
            R.drawable.moveaccount,
            R.drawable.keep
        )
        val mappingActivity = arrayOf(
            Activity_Myprofile::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java
        )
    }
}

class ShopInfo {
    companion object {
        val Info = arrayOf(
            "貼圖", "主題", "代幣"
        )
        val InfoIcon = intArrayOf(
            R.drawable.picpaste,
            R.drawable.theme,
            R.drawable.coin
        )
        val mappingActivity = arrayOf(
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java
        )
    }
}
class BasicSetting {
    companion object {
        val Info = arrayOf(
            "提醒", "照片、影片", "聊天", "通話", "好友","群組","貼文串","語言"
        )
        val InfoIcon = intArrayOf(
            R.drawable.remind,
            R.drawable.picandvideo,
            R.drawable.talking,
            R.drawable.phone,
            R.drawable.friends,
            R.drawable.groups,
            R.drawable.post,
            R.drawable.language
        )
        val mappingActivity = arrayOf(
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java
        )
    }
}
class DetialInfo {
    companion object {
        val Info = arrayOf(
            "最新資訊", "常見問題", "關於LINE"
        )
        val InfoIcon = intArrayOf(
            R.drawable.news,
            R.drawable.questions,
            R.drawable.about
        )
        val mappingActivity = arrayOf(
            Activity_Empty::class.java,
            Activity_Empty::class.java,
            Activity_Empty::class.java
        )
    }
}
data class LineDataSet(val mtitle: String, val micon: Int, val mclass: Class<out AppCompatActivity>) {}
class DataModel() {
    lateinit var mtitleList: MutableList<String>
    lateinit var miconList: MutableList<Int>
    lateinit var mclassList: MutableList<Class<out AppCompatActivity>>

    fun GetData(): MutableList<LineDataSet> {
        var dataList = mutableListOf<LineDataSet>()
        for (i in 0 until mtitleList.size) {
            dataList.add(LineDataSet(mtitleList[i], miconList[i], mclassList[i]))
        }
        return dataList
    }
}


