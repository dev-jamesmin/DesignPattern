package com.brandi.mvcsample1.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.brandi.mvcsample1.R
import com.brandi.mvcsample1.model.MainModel

// 메인의 경우 컨트롤러 역활.
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var datas: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>
    private val model = MainModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        val button: Button? = findViewById(R.id.button)
//        button?.setOnClickListener(this)

        // 리소스 가져오는법 변경... 체크 및 학습 필요.
        // null 체크 자연 스럽게 하는법.
        val button: Button? = findViewById(R.id.button)
        button?.setOnClickListener(this)

        datas = model.getListDatas()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datas)

        val listView: ListView? = findViewById(R.id.listView)
        if (listView != null) { listView.adapter = adapter }
    }

    override fun onClick(v: View?) {
        val editView: EditText? = findViewById(R.id.editView)
        val data: String = editView?.text.toString()
        model.addItem(data)
        datas.add(data)
        adapter.notifyDataSetChanged()
        editView?.setText("")
    }

}