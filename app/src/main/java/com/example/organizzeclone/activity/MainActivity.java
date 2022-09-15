package com.example.organizzeclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.View;

import com.example.organizzeclone.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //Activity Main desabilitado


        //BLOCO INTRO FRAGMENT
        setButtonBackVisible(false);  //Removendo Botão Back
        setButtonNextVisible(false);  //Removendo Botão Next


        //Intro 1 Fragment
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_bright)
                .fragment(R.layout.intro_1)
                .build());

        //Intro 2 Fragment
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_bright)
                .fragment(R.layout.intro_2)
                .build());

        //Intro 3 Fragment
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_bright)
                .fragment(R.layout.intro_3)
                .build());

        //Intro 4 Fragment
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_bright)
                .fragment(R.layout.intro_4)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_bright)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .build());

        //FIM DO BLOCO INTRO FRAGMENT



        /*
        //BLOCO SLIDER SIMPLICADO ----- Bloco desabilitado
        setButtonBackVisible(false);  //Removendo Botão Back
        setButtonNextVisible(false);  //Removendo Botão Next

        //Intro 1 SimpleSlider
        addSlide(new SimpleSlide.Builder()
                                .title("Titulo")
                                .description("Descrição")
                                .image(R.drawable.um)
                                .background(android.R.color.holo_orange_light)
                                .build()
        );
        //Intro 2 SimpleSlider
        addSlide(new SimpleSlide.Builder()
                                .title("Titulo2")
                                .description("Descrição2")
                                .image(R.drawable.dois)
                                .background(android.R.color.holo_orange_light)
                                .build()
        );
        //Intro 3 SimpleSlider
        addSlide(new SimpleSlide.Builder()
                                .title("Titulo3")
                                .description("Descrição3")
                                .image(R.drawable.tres)
                                .background(android.R.color.holo_orange_light)
                                .build()
        );
        //Intro 4 SimpleSlider
        addSlide(new SimpleSlide.Builder()
                                .title("Titulo4")
                                .description("Descrição4")
                                .image(R.drawable.quatro)
                                .background(android.R.color.holo_orange_light)
                                .build()
        );
        //FIM DO BLOCO SLIDER SIMPLIFICADO
        */

    }


    //START TELA DE LOGIN
    public void btEntrar(View view) {
       startActivity(new Intent(this, LoginActivity.class));
    }
    //START TELA DE CADASTRO
    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }
}