//13 Agustus 2021, 10118410, Ridwan Caesarahman Julian, IF-10
package com.ridwancaesarahmanjulian.uas10118410;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class booking_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }


    public void simpan(View view) {
        Button btnSimpan = findViewById(R.id.btnSimpan);
//instansiasi edittext
        EditText text1 = (EditText) findViewById(R.id.nama);
        EditText text2 = (EditText) findViewById(R.id.kota);
        EditText text3 = (EditText) findViewById(R.id.kontak);


//instansiasi database firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();

//Referensi database yang dituju
        DatabaseReference myRef = database.getReference("Nama").child(text1.getText().toString());

//memberi nilai pada referensi yang dituju
        myRef.child("Asal Kota").setValue(text2.getText().toString());
        myRef.child("Kontak").setValue(text3.getText().toString());


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(booking_activity.this, MainActivity.class);
                intent.putExtra("Data Tersimpan", "Mohon Tunggu Dikontak Tim Kami");
                startActivity(intent);
            }});



    }




}


