package com.techmania.noteapp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.techmania.gradletest.R

class UpdateActivity : AppCompatActivity() {

    lateinit var editTextTitle : EditText
    lateinit var editTextDescription : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button

    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Edit Note"

        editTextTitle = findViewById(R.id.editTextNoteTitleUpdate)
        editTextDescription = findViewById(R.id.editTextNoteDescriptionUpdate)
        buttonCancel = findViewById(R.id.buttonCancelUpdate)
        buttonSave = findViewById(R.id.buttonSaveUpdate)

        getAndSetData()

        buttonCancel.setOnClickListener {

            Toast.makeText(applicationContext,"Nothing changed", Toast.LENGTH_SHORT).show()
            finish()

        }
        buttonSave.setOnClickListener {

            updateNote()

        }
    }

    fun updateNote(){

        val updateTitle = editTextTitle.text.toString()
        val updateDescription = editTextDescription.text.toString()

        val intent = Intent()
        intent.putExtra("updateTitle", updateTitle)
        intent.putExtra("updateDescription", updateDescription)
        if (currentId != -1){

            intent.putExtra("noteId", currentId)
            setResult(RESULT_OK,intent)
            finish()

        }


    }

    fun getAndSetData(){

        //get
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDescription = intent.getStringExtra("currentDescription")
        currentId = intent.getIntExtra("currentId", -1)

        //set
        editTextTitle.setText(currentTitle)
        editTextDescription.setText(currentDescription)
    }
}