package com.vaibhavrawat.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.vaibhavrawat.alertdialog.databinding.ActivityRandomCharacterGeneratorBinding

class RandomCharacterGenerator : AppCompatActivity() {
    lateinit var binding: ActivityRandomCharacterGeneratorBinding
    var ran: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomCharacterGeneratorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGenerate.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Generate Characters")
            alertDialog.setMessage("Select to generate characters...")
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Generate/Add 3") { _, _ ->
                for (i in 0..2) {
                    var rand1 = ('A'..'Z').random()
                    ran += rand1
                    //val rand2 = ('A'..'Z').random()
                    //val rand3 = ('A'..'Z').random()
                    // var ran : String ?= ""
                    // ran="$rand1 $rand2 $rand3"
                    binding.tvData.text = ran.toString()
                }
            }
            alertDialog.setNegativeButton("Generate/Add 4") { _, _ ->
                for (i in 0..3) {
                    val rand2 = ('A'..'Z').random()
                    ran += rand2
                    //  Toast.makeText(this,"$rand",Toast.LENGTH_SHORT).show()
                    binding.tvData.text = ran.toString()
                }
            }
            alertDialog.setNeutralButton("Clear") { _, _ ->
                binding.tvData.text = "NULL"
                ran = ""
            }
            alertDialog.show()
        }
    }
}
