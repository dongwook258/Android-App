package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivityAddPlanBinding
import java.util.Date

class AddPlanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPlanBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityAddPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var planList = ArrayList<Plan>()
        planList.add(Plan("a", "일본", Date(), Date()))
        planList.add(Plan("b", "일본", Date(), Date()))
        planList.add(Plan("c", "일본", Date(), Date()))

        var adapter = PlanAdapter(planList)
        adapter.planList = planList

        binding.planListRv.adapter = adapter
        binding.planListRv.layoutManager = LinearLayoutManager(this)

        binding.addPlanBtn.setOnClickListener {
            val intent = Intent(this, AddPlanlast::class.java)
            startActivity(intent)
        }
    }
}