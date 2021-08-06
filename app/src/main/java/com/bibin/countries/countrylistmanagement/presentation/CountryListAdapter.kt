package com.bibin.countries.countrylistmanagement.presentation

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bibin.countries.countrylistmanagement.domain.entity.CountryListEntity
import com.bibin.countries.databinding.ListItemCountryBinding
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


internal class CountryListAdapter(
    private var list: List<CountryListEntity>,
    private val listItemClickCallback: ListItemClickCallback
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryItemViewHolder(
            ListItemCountryBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CountryItemViewHolder
        viewHolder.bind(list[position])
        viewHolder.cardView.setOnClickListener {
            listItemClickCallback.onItemClick(list[position])
        }
    }

    class CountryItemViewHolder(private val binding: ListItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val cardView = binding.cardView
        fun bind(country: CountryListEntity) {
            binding.country = country
            binding.executePendingBindings()
            val uri = Uri.parse(country.flag)
            GlideToVectorYou.justLoadImage(
                binding.imageCountry.context as Activity?,
                uri,
                binding.imageCountry
            )
        }
    }

    fun updateList(newList: List<CountryListEntity>) {
        this.list = newList
        notifyDataSetChanged()
    }
}