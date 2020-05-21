package com.example.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teams.adapter.TeamAdapter
import com.example.teams.databinding.FragmentTeamItemBinding
import com.example.teams.model.TeamList
import com.example.teams.network.RetrofitInstance
import com.example.teams.network.SoccerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamItemFragment : Fragment() {

    lateinit var  binding: FragmentTeamItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_item, container, false)

        val retrofit = RetrofitInstance.getRetrofitInstance()
        val request = retrofit.create(SoccerService::class.java)
        val call = request.getAllTeams()

        call.enqueue(object : Callback<TeamList> {
            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                Toast.makeText(context, "An error -- ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = TeamAdapter(response.body()!!.teams.take(10))
                    layoutManager = LinearLayoutManager(context)
                }
            }

        })
        return binding.root
    }
}

