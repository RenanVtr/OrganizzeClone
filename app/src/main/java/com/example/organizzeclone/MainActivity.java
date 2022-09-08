package com.example.organizzeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSlide((Slide) new SimpleSlide.Builder()
                                .title("Titulo")
                                .description("Descrição")

        );
    }
}