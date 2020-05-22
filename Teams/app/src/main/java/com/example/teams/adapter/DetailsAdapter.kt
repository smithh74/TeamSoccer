package com.example.teams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.teams.R
import com.example.teams.databinding.FragmentDetailBinding
import com.example.teams.model.SoccerTeam
import com.squareup.picasso.Picasso

class DetailsAdapter (val teamList: SoccerTeam) : RecyclerView.Adapter<DetailsAdapter.TeamHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(layoutInflater, R.layout.fragment_detail, parent, false)
        return TeamHolder(binding)
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList)
    }

    inner class TeamHolder(val binding: FragmentDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team: SoccerTeam){
            binding.teamNameDetailTxt.text = team.strTeam
            binding.teamDescriptionDetailTxt.text =team.strDescriptionEN
            Picasso.get().load(team.strTeamBadge).into(binding.teamBadgeDetailImg)
            Picasso.get().load(team.strTeamJersey).into(binding.teamJerseyDetailImg)
        }
    }
}