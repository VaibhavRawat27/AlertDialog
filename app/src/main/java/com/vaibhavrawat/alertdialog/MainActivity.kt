package com.vaibhavrawat.alertdialog

import android.annotation.SuppressLint
import kotlin.random.Random
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vaibhavrawat.alertdialog.databinding.ActivityMainBinding
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    //var ran :String?=""
    //var btnSave : Button?= null

   // var random = Math.random()

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
           // for(i in 0..2) {
              //  var rand = ('A'..'Z').random()
              //  ran+= rand
              //  Toast.makeText(this, "$ran", Toast.LENGTH_SHORT).show()
           // }
            //Toast.makeText(this, "$ran", Toast.LENGTH_SHORT).show()

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_layout)
            //btnSave = findViewById(R.id.btnSave)
            var etName : EditText ?= null
            var etRollNo : EditText ?= null
            var btnSave : Button ?= null
            etName = dialog.findViewById(R.id.etName)
            etRollNo = dialog.findViewById(R.id.etRollNo)
            btnSave = dialog.findViewById(R.id.btnSave)

            btnSave?.setOnClickListener {
               // Toast.makeText(this,"hey",Toast.LENGTH_SHORT).show()
                if (etName.toString().isEmpty()|| etRollNo.toString().isEmpty()) {
                    binding.tvName.text = "Name :"
                    binding.tvRoll.text = "Roll No :"
              } else {
                    binding.tvName.text = etName.text.toString()
                    binding.tvRoll.text = etRollNo.text.toString()
                   dialog.dismiss()

                }

            }
           dialog.show()
        }

        binding.btnDelete.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete name and roll no?")
            //alert.setCancelable(false)
            alert.setPositiveButton("Yes"){_,_ ->
                binding.tvName.text = "Name :"
                binding.tvRoll.text = "Roll No :"
            }
            alert.show()
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, RandomCharacterGenerator::class.java)
            startActivity(intent)
        }


    }
}