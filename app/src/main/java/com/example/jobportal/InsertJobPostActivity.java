package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobportal.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;


public class InsertJobPostActivity extends AppCompatActivity {

     Toolbar toolbar;
     EditText job_title;
     EditText job_description;
     EditText job_skills;
     EditText job_salary;

     Button btn_post_job;

    //Firebase....

     FirebaseAuth mAuth;
     DatabaseReference mJobPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        setContentView(R.layout.activity_insert_job_post);

        job_title=findViewById(R.id.job_title);
        job_description=findViewById(R.id.job_Destriction);
        job_skills=findViewById(R.id.job_skills);
        job_salary=findViewById(R.id.job_salary);

        //toolbar=findViewById(R.id.insert_job_toolbar);
        //setSupportActionBar(toolbar);
        //Objects.requireNonNull(getSupportActionBar()).setTitle("Post job");

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=mAuth.getCurrentUser();
        assert mUser != null;
        String uId=mUser.getUid();

        btn_post_job=findViewById(R.id.btn_job_post);


        mJobPost= FirebaseDatabase.getInstance().getReference().child("Job Post");

        btn_post_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertJob();

            }
        });
    }

    private void InsertJob(){
        String title=job_title.getText().toString().trim();
        String description=job_description.getText().toString().trim();
        String skills=job_skills.getText().toString().trim();
        String salary=job_salary.getText().toString().trim();
        String id=mJobPost.push().getKey();
        String date= DateFormat.getDateInstance().format(new Date());

        Data data =new Data(title,description,skills,salary,id,date);
        mJobPost.push().setValue(data);
        Toast.makeText(InsertJobPostActivity.this,"Data inserted:",Toast.LENGTH_SHORT).show();


    }


}