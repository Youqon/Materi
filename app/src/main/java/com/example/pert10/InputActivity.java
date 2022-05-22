package com.example.pert10;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    protected Cursor cursor;
    Button btnSubmit, btnKembali;
    DataHelper dbHelper;
    EditText inNo, inNama, inTgl, inJK, inAlamat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_input);

        inNo = (EditText) findViewById(R.id.idnomor);
        inNama = (EditText) findViewById(R.id.idnama);
        inTgl = (EditText) findViewById(R.id.idtanggallahir);
        inJK = (EditText) findViewById(R.id.idjeniskelamin);
        inAlamat = (EditText) findViewById(R.id.idalamat);
        btnSubmit = (Button) findViewById(R.id.idsubmit);
        btnKembali = (Button) findViewById(R.id.idkembali);
        dbHelper = new DataHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String nomor = inNo.getText().toString();
                String name = inNama.getText().toString();
                String tgll = inTgl.getText().toString();
                String jkl = inJK.getText().toString();
                String almt = inAlamat.getText().toString();
                db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values('" + nomor + "','" + name + "','" + tgll + "','" + jkl + "','" + almt + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            }
        });
    }
}
