package hk.hku.cs.tutorial5

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
class PersonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)
        val studentList = intent.getStringArrayListExtra("data")
        val list = arrayListOf<MutableMap<String, Any>>()
        for (i in studentList!!.indices) {
            val map: MutableMap<String, Any> = HashMap()
            val count = i+1
            map["Role"] = "Student $count"
            map["Name"] = studentList[i]
            list.add(map)
        }
        val adapter = SimpleAdapter(this, list, R.layout.person_list_item,
            arrayOf("Role", "Name"), intArrayOf(R.id.role, R.id.name))
        val list_view:ListView = findViewById(R.id.list_view)
        list_view.adapter = adapter
    }
}
