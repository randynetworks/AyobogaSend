package randyramadhan.ayoboga.ayobogasend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormInput extends AppCompatActivity {

    String strJumlah;
    String diterima;
    String asuransi;
    String Kurir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_input);

        // EDIT TEXT
        EditText input_pengirim = findViewById(R.id.input_pengirim);
        EditText input_alamat = findViewById(R.id.input_alamat);
        EditText input_telp = findViewById(R.id.input_telp);
        EditText input_email = findViewById(R.id.input_email);
        EditText input_barang = findViewById(R.id.input_barang);
        EditText berat_barang = findViewById(R.id.berat_barang);
        EditText harga_barang = findViewById(R.id.harga_barang);
        EditText input_penerima = findViewById(R.id.input_penerima);
        EditText input_alamat_penerima = findViewById(R.id.input_alamat_penerima);
        EditText input_telp_penerima = findViewById(R.id.input_telp_penerima);
        EditText input_kode_pengiriman = findViewById(R.id.input_kode_pengiriman);

        RadioGroup radioKurir = findViewById(R.id.kurir);

        RadioButton kurir = findViewById(radioKurir.getCheckedRadioButtonId());

        // ===================== SWITCH =============================
        Switch s_asuransi = findViewById(R.id.s_asuransi);

        s_asuransi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                asuransi = (isChecked) ? "Di Asuransikan" : "Tidak Asuransikan";
                Toast.makeText(FormInput.this, "Kamu Memilih " + diterima, Toast.LENGTH_SHORT).show();

            }
        });


        // ===================== CHECKBOX =============================

        CheckBox cb_diterima = findViewById(R.id.cb_diterima);

        cb_diterima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                diterima = (isChecked) ? "Diterima" : "Tidak Diterima";
                Toast.makeText(FormInput.this, "Kamu Memilih " + diterima, Toast.LENGTH_SHORT).show();
            }
        });


        // ===================== SPINNER =============================
        Spinner jumlah_barang = findViewById(R.id.jumlah_barang);

        jumlah_barang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(jumlah_barang.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strJumlah = (item.equals(jumlah_barang.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
                Toast.makeText(FormInput.this, "Kamu Memilih " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ===================== SUBMIT FORM =============================

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ===================== ALERT DIALOG YES NO =============================
                AlertDialog.Builder dialog = new AlertDialog.Builder(FormInput.this);
                dialog.setTitle("Yakin disimpan?");
                dialog.setMessage("Hi! Apakah data yang dimasukan Valid?");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("Heem Valid!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Engga valid", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FormInput.this, "Data Gagal Disimpan.", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
    }
}
