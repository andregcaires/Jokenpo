package com.andregcaires.jokenpo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[] opcoes = {"pedra", "papel", "tesoura"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String comparaEscolhas(String escolhaUsuario, int num){
        String result = "";
        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        switch(escolhaUsuario){
            case "pedra":{
                if(opcoes[num] == "pedra"){
                    imagemResultado.setImageResource(R.drawable.pedra);
                    result = "empate";
                }
                else if(opcoes[num] == "papel"){
                    imagemResultado.setImageResource(R.drawable.papel);
                    result = "perdeu";
                }
                else if(opcoes[num] == "tesoura"){
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    result = "ganhou";
                }
                break;
            }
            case "papel":{
                if(opcoes[num] == "pedra"){
                    imagemResultado.setImageResource(R.drawable.pedra);
                    result = "ganhou";
                }
                else if(opcoes[num] == "papel"){
                    imagemResultado.setImageResource(R.drawable.papel);
                    result = "empate";
                }
                else if(opcoes[num] == "tesoura"){
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    result = "perdeu";
                }
                break;
            }
            case "tesoura":{
                if(opcoes[num] == "pedra"){
                    imagemResultado.setImageResource(R.drawable.pedra);
                    result = "perdeu";
                }
                else if(opcoes[num] == "papel"){
                    imagemResultado.setImageResource(R.drawable.papel);
                    result = "ganhou";
                }
                else if(opcoes[num] == "tesoura"){
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    result = "empate";
                }
                break;
            }
        }
        return result;
    }

    public void exibeResultado(String resultado){

        TextView txt = findViewById(R.id.txtMensagem);
        switch (resultado){

            case "empate":{
                txt.setText("Empate!");
                break;
            }
            case "perdeu":{
                txt.setText("Você perdeu!");
                break;
            }
            case "ganhou":{
                txt.setText("Você ganhou!");
                break;
            }

        }

    }

    public void opcaoSelecionada(View view){

        int opcaoMaquina = new Random().nextInt(3);
        String opcaoUsuario = getResources().getResourceEntryName(view.getId());

        String resultado = comparaEscolhas(opcaoUsuario, opcaoMaquina);

        exibeResultado(resultado);



    }
}
