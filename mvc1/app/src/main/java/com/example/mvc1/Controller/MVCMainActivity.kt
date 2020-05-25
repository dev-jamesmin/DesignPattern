package com.example.mvc1.Controller

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc1.Model.MainModel
import com.example.mvc1.R
import kotlinx.android.synthetic.main.activity_main.*

//Controller
class MVCMainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var datas: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>
    private val model = MainModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)

        datas = model.getListDatas()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datas)
        listView.adapter = adapter
    }
    
    override fun onClick(v: View?) {

        val data: String = editView.text.toString()
        model.addItem(data)
        datas.add(data)
        adapter.notifyDataSetChanged()
        editView.setText("")
    }

}
