package com.example.travelplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelplan.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        initSignupButton()
    }


    private fun initSignupButton() {
        binding.btnRegister.setOnClickListener {
            val email = binding.tvId.text.toString()
            val password = binding.tvPw.text.toString()

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"회원가입에 성공했습니다!",Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, LogInActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this,"이미 존재하는 계정이거나, 회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}