package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;
    private Button btCalcular, btLimpar;
    private TextView valorImc, classificacaoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referenciando os componentes na tela
        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btCalcular = findViewById(R.id.bt_calcular);
        btLimpar = findViewById(R.id.bt_limpar);
        valorImc = findViewById(R.id.valor_imc);
        classificacaoImc = findViewById(R.id.classificacao_imc);

        btCalcular.setOnClickListener(view -> {
           // identifica se o campo está vazio ou não e calcula o IMC
            if (editPeso.getText().toString().isEmpty()){
                editPeso.setError(getString(R.string.valida_peso));
                Toast.makeText(getBaseContext(), R.string.valida_peso, Toast.LENGTH_SHORT).show();
            }else if (editAltura.getText().toString().isEmpty()) {
                editAltura.setError(getString(R.string.valida_altura));
                Snackbar.make(editAltura, R.string.valida_altura, Snackbar.LENGTH_SHORT).show();
            }else{
                double peso, altura, imc;
                peso = Double.parseDouble(editPeso.getText().toString());
                altura = Double.parseDouble(editAltura.getText().toString());
                imc = peso / (altura * altura);
                //calcular o IMC
                //exibir o valor do IMC
                //exibir a classificação do IMC (puxando do strings.xml)
                //para cada classificação do IMC, uma cor diferente
                //no background da textView de classificação
                //criar a ação do botão limpar
                if (imc < 18.5){
                    classificacaoImc.setText(R.string.classificacao1);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.laranja));
                }else if (imc <= 24.9) {
                    classificacaoImc.setText(R.string.classificacao2);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.alaranjado));
                }else if (imc <= 29.9){
                    classificacaoImc.setText(R.string.classificacao3);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.vermelho));
                }else if (imc <= 34.9){
                    classificacaoImc.setText(R.string.classificacao4);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.roxoclaro));
                }else if (imc <= 39.9){
                    classificacaoImc.setText(R.string.classificacao5);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.roxomedio));
                }else{
                    classificacaoImc.setText(R.string.classificacao6);
                    classificacaoImc.setBackgroundColor(getResources().getColor(R.color.roxoescuro));
                }
                valorImc.setText(getString(R.string.imc, imc));
            }
        });

        btLimpar.setOnClickListener(view -> {
            editPeso.setText("");
            editAltura.setText("");
            valorImc.setText("");
            classificacaoImc.setText("");
            classificacaoImc.setBackgroundColor(getResources().getColor(R.color.rosa));
        });
    }
}