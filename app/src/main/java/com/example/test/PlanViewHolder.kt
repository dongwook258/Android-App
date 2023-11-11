package com.example.test

import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemPlanBinding

class PlanViewHolder(val binding: ItemPlanBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(plan: Plan) {
        binding.destinationTv.setText(plan.destination)
        //todo date
    }
}