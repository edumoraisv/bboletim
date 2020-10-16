package com.example.boletimescolar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MateriaActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //private ListView listV_dados;

    private Button buttonSalvar, buttonCancelar;

    //private List<Materia> listaMaterias = new ArrayList<Materia>();
    //private ArrayAdapter<Materia> arrayAdapterMateria;

    private TextView textView_preenchaCampo;
    private EditText editText_nomeMateria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_materia);
        inicializarFirebase();


        buttonSalvar =  (Button) findViewById(R.id.button_Salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
        buttonCancelar = (Button) findViewById(R.id.button_Cancelar);

        textView_preenchaCampo = (TextView) findViewById(R.id.textView_preenchaCampo);
        editText_nomeMateria = (EditText) findViewById(R.id.editTextInput_nomeMateria);

    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(MateriaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void salvar(){
        Materia materia = new Materia();
        materia.setId(UUID.randomUUID().toString());
        materia.setNome(editText_nomeMateria.getText().toString());
        databaseReference.child("Materia").child(materia.getId()) .setValue(materia);
        limparCampos();
    }
    public void limparCampos(){
        editText_nomeMateria.setText("");
    }

    //Metodo para voltar para a tela inicial dos cadastros
    public void voltarMainActivity(View view) {
       finish();
    }

}