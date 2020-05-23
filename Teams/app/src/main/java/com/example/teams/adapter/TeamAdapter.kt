package com.example.teams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teams.R
import com.example.teams.TeamItemFragmentDirections
import com.example.teams.databinding.TeamItemBinding
import com.example.teams.model.SoccerTeam
import com.squareup.picasso.Picasso

class TeamAdapter (val teamList: List<SoccerTeam>): RecyclerView.Adapter<TeamAdapter.TeamHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TeamItemBinding>(layoutInflater, R.layout.team_item, parent, false)
        return  TeamHolder(binding)
    }
    override fun getItemCount(): Int {
        return  teamList.size
    }
    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList[position])
    }

    inner class TeamHolder(val binding: TeamItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team : SoccerTeam){
            binding.txtTeamName.text=team.strTeam
            binding.txtNameStadium.text=team.strStadium
            Picasso.get().load(team.strTeamBadge).into(binding.teamBadgeImg)
            binding.detailBtn.setOnClickListener{
                it.findNavController().navigate(TeamItemFragmentDirections.actionTeamItemFragmentToDetailFragment(team))
            }
        }
    }


}