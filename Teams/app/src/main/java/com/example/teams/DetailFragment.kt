package com.example.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.teams.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    lateinit var  binding: FragmentDetailBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

val args=DetailFragmentArgs.fromBundle(requireArguments())
    binding.teamNameDetailTxt.text=args.team.strTeam
    binding.teamDescriptionDetailTxt.text=args.team.strDescriptionEN
    Picasso.get().load(args.team.strTeamBadge).into(binding.teamBadgeDetailImg)
    Picasso.get().load(args.team.strTeamJersey).into(binding.teamJerseyDetailImg)
    return binding.root
}

}