package com.example.conversormoedas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.conversormoedas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TextureView resultado;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //INICIA AQUI

        resultado = findViewById(R.id.txt_resultado);

        Button botaoConverter = findViewById(R.id.btn_converter);
        botaoConverter.setOnClickListener(new View.OnClickListener() { // Estrutura para funcionalidade do botão converter
            @Override
            public void onClick(View v) {
                converter();
            }

            private void converter() {
                RadioGroup opcoes = findViewById(R.id.radio_opcoes);
                int selecionada = opcoes.getCheckedRadioButtonId(); //armazenar a opção selecionada
                EditText valor = findViewById(R.id.input_valor);

                double valorConvertido = 0.0; //armazenamento do valor já convertido

                if (selecionada == R.id.radio_USD) {
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    valorConvertido = valorCalculado * 4.87;
                } else if (selecionada == R.id.radio_EUR) {
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    valorConvertido = valorCalculado * 5.35;
                } else {
                    double valorCalculado = Double.parseDouble(valor.getText().toString());
                    valorConvertido = valorCalculado * 0.0054;
                }
            }
        });

    }
}