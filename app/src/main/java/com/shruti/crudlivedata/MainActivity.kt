package com.shruti.crudlivedata

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Insert
import com.shruti.crudlivedata.databinding.ActivityMainBinding
import com.shruti.crudlivedata.databinding.CustomNotesAddBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        notesViewModel.notesList.observe(this){
            for (liveDataEntity in it){
                System.out.println("notes entity ${liveDataEntity.id}")
                System.out.println("notes entity ${liveDataEntity.title}")
                System.out.println("notes entity ${liveDataEntity.description}")
            }
        }
        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = CustomNotesAddBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.show()
        }
    }
}