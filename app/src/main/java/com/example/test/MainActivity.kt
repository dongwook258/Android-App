package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val id = "MJ"
    private val password = "1234"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var textId = binding.tvId.text.toString()
            var textPw = binding.tvPw.text.toString()
            var inputLogin = binding.tvId.text.trim().toString()
            var inputPassword = binding.tvPw.text.trim().toString()

            if(inputLogin == id && inputPassword == password){
                var intent = Intent(this, AddPlanActivity::class.java)
                Toast.makeText(this, "로그인 되었습니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else {
                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
                    Toast.makeText(this, "아이디와 비밀번호를 입력하세오", Toast.LENGTH_SHORT).show()
                }
                else if (inputLogin != id) {
                    Toast.makeText(this, "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT).show()
                }
                else if (inputPassword != password) {
                    Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}