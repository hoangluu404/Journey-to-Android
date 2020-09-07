package com.example.journeytoandroid

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_events.*


class FragmentStart : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var eventList = mutableListOf<EventAboutMe>()

        val adapter = AdapterEventAboutMe(eventList)

        rvEventList.adapter = adapter
        val layoutManager = LinearLayoutManager(this.getContext())
        rvEventList?.layoutManager = layoutManager
        btnAdd.setOnClickListener {
            val title = etNewEvent.text.toString()
            etNewEvent.text.clear()
            if (title != "") {
                var newEvent = EventAboutMe(false, title)   // create new Event
                eventList.add(newEvent) // add new event
                adapter.notifyItemInserted(eventList.size - 1) // notify the RecyclerView that an item was added to the last position
                etNewEvent.hint = "another todo"
            } else {
                etNewEvent.hint = "todo empty"
            }
        }

        btnNext.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_fragmentStart_to_fragmentFirstProject)
        }


    }

    private fun setFragment(fragment: Fragment) {
        //supportFragmentManager.beginTransaction().apply {
        //    replace(R.id.flFragment, fragment)
            //addToBackStack(null)    // add the previous fragment to the stack


        //    commit()    // apply

        }
}