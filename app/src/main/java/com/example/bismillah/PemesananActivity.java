package com.example.bismillah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PemesananActivity extends AppCompatActivity {

    Spinner spinKelamin, spinAsal, spinTujuan, spinMaskapai;
    EditText edtnama, edtnik, edtjmlhpenumpang;
    FloatingActionButton fab;
    String nama, nik, jmlhpenumpang, kelamin, asal, tujuan, Maskapai;
    TextView username;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id = "";

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.onSubmit)
            nama = edtnama.getText().toString();
        nik = edtnik.getText().toString();
        jmlhpenumpang = edtjmlhpenumpang.getText().toString();
        kelamin = spinKelamin.getSelectedItem().toString();
        asal = spinAsal.getSelectedItem().toString();
        tujuan = spinTujuan.getSelectedItem().toString();
        Maskapai = spinMaskapai.getSelectedItem().toString();

        if (edtnama.getText().toString().length()==0){
            edtnama.setError("Task Diperlukan!!");
        }
        if (edtnik.getText().toString().length()==0){
            edtnik.setError("Jenis Task Diperlukan!!");
        }
        if (edtjmlhpenumpang.getText().toString().length()==0){
            edtjmlhpenumpang.setError("Time Task Diperlukan!!");
        }
        if (nama.isEmpty() || nik.isEmpty() || jmlhpenumpang.isEmpty() || kelamin.isEmpty() || asal.isEmpty() || tujuan.isEmpty() || Maskapai.isEmpty()) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Isi semua data!!!", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Berhasil", Toast.LENGTH_LONG);
            t.show();

            Bundle b = new Bundle();

            b.putString("a", nama.trim());
            b.putString("b", nik.trim());
            b.putString("c", jmlhpenumpang.trim());
            b.putString("d", kelamin.trim());
            b.putString("e", asal.trim());
            b.putString("f", tujuan.trim());
            b.putString("g", Maskapai.trim());

            Intent i = new Intent(getApplicationContext(), com.example.bismillah.TampilanTiketActivity.class);
            i.putExtras(b);
            startActivity(i);
        }
        if (item.getItemId() == R.id.mnLogout) {
            Intent l = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(l);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        edtnama = findViewById(R.id.namaPenumpang);
        edtnik = findViewById(R.id.nik);
        edtjmlhpenumpang = findViewById(R.id.jmlPenumpang);
        username = findViewById(R.id.tvusername);
        spinKelamin = findViewById(R.id.spnkelamin);
        spinAsal = findViewById(R.id.spnasal);
        spinTujuan = findViewById(R.id.spntujuan);
        spinMaskapai = findViewById(R.id.spnmaskapai);

        progressDialog = new ProgressDialog(PemesananActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setTitle("Menyimpan");


        Bundle bundle = getIntent().getExtras();

        String user = bundle.getString("a");
        username.setText(user);

        fab = findViewById(R.id.faButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtnama.getText().toString();;
                nik = edtnik.getText().toString();
                jmlhpenumpang = edtjmlhpenumpang.getText().toString();
                kelamin = spinKelamin.getSelectedItem().toString();
                asal = spinAsal.getSelectedItem().toString();
                tujuan = spinTujuan.getSelectedItem().toString();
                Maskapai = spinMaskapai.getSelectedItem().toString();

                if (nama.isEmpty() || nama.isEmpty() || nama.isEmpty() || kelamin.isEmpty() || asal.isEmpty() || tujuan.isEmpty() || Maskapai.isEmpty())
                {
                    Snackbar.make(view,"Isi Semua Data", Snackbar.LENGTH_LONG).show();
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", nama.trim());
                    b.putString("b", nik.trim());
                    b.putString("c", jmlhpenumpang.trim());
                    b.putString("d", kelamin.trim());
                    b.putString("e", asal.trim());
                    b.putString("f", tujuan.trim());
                    b.putString("g", Maskapai.trim());

                    Intent i = new Intent(getApplicationContext(), TampilanTiketActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }

            }
        });
    }
    private void saveData(String nama, String nik, String jmlhpenumpang, String kelamin, String asal, String tujuan, String Maskapai){
        Map<String, Object> user = new HashMap<>();
        user.put("task", nama);
        user.put("jenis", nik);
        user.put("time", jmlhpenumpang);
        user.put("kelamin", kelamin);
        user.put("asal", asal);
        user.put("tujuan", tujuan);
        user.put("maskapai", Maskapai);

        progressDialog.show();
        if (id!=null){
            db.collection("users").document(id).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });
        }
    }
}