package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditFragment : Fragment(R.layout.fragment_edit) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleText = view.findViewById<EditText>(R.id.titleText)
        val messageText = view.findViewById<EditText>(R.id.messageText)
        val add = view.findViewById<Button>(R.id.addPost)
        val viewButton = view.findViewById<Button>(R.id.viewButton)

        add.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                (requireActivity() as MainActivity).database.getDao().insertPost(
                    Post(0,
                        titleText.text.toString(),
                        messageText.text.toString())
                )
            }
        }
        viewButton.setOnClickListener {
            (requireActivity() as MainActivity).toView()
        }
    }

    companion object {
        fun newInstance() =
            EditFragment()
    }
}