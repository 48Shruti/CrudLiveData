package com.shruti.crudlivedata

import android.app.Dialog
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Insert
import com.shruti.crudlivedata.databinding.ActivityMainBinding
import com.shruti.crudlivedata.databinding.CustomNotesAddBinding

class MainActivity : AppCompatActivity(),RecyclerInterface {
    lateinit var binding : ActivityMainBinding
    lateinit var notesViewModel: NotesViewModel
    lateinit var notesDb: NotesDb
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager
    var item = arrayListOf<NotesEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notesDb = NotesDb.getDatabase(this)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        recyclerAdapter = RecyclerAdapter(item,this)
        binding.recyclerview.adapter = recyclerAdapter

        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        notesViewModel.notesList.observe(this){
            item.clear()
            item.addAll(it)
            recyclerAdapter.notifyDataSetChanged()
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
            dialog.getWindow()?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.btnadd.setOnClickListener {
                if (dialogBinding.ettitle.text.toString().isNullOrEmpty()){
                    dialogBinding.ettitle.error = "Enter title"
                }
                else if (dialogBinding.etdescription.text.toString().isNullOrEmpty())
                { dialogBinding.etdescription.error = "Enter descripation" }
                else{
                    notesViewModel.insertNotes(NotesEntity(title = dialogBinding.ettitle.text.toString(),
                        description = dialogBinding.etdescription.text.toString()))
                    dialog.dismiss()
            }
            }
            dialog.show()
        }
    }
    override fun deleteNotes(entity: NotesEntity, position: Int) {
        notesViewModel.deleteNotes(entity)
    }

    override fun updateNotes(entity: NotesEntity, position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = CustomNotesAddBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialogBinding.btnadd.setOnClickListener {
            if (dialogBinding.ettitle.text.toString().isNullOrEmpty()){
                dialogBinding.ettitle.error = "Enter title"
            }
            else if (dialogBinding.etdescription.text.toString().isNullOrEmpty())
            { dialogBinding.etdescription.error = "Enter descripation" }
            else{
                notesViewModel.updateNotes(NotesEntity(
                    id= item[position].id,
                    title = dialogBinding.ettitle.text.toString(),
                    description = dialogBinding.etdescription.text.toString()))
                dialog.dismiss()
            }
        }
        dialog.show()
    }
}