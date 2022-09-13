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
        //setContentView(R.layout.activity_main);

        addSlide((Slide) new SimpleSlide.Builder()
                                        .title("Titulo")
                                        .description("Descrição")
                                        .image(R.drawable.um)
                                        .background(android.R.color.holo_orange_light)
                                        .build()
        );
        addSlide((Slide) new SimpleSlide.Builder()
                                        .title("Titulo2")
                                        .description("Descrição2")
                                        .image(R.drawable.dois)
                                        .background(android.R.color.holo_orange_light)
                                        .build()
        );

        addSlide((Slide) new SimpleSlide.Builder()
                                        .title("Titulo3")
                                        .description("Descrição3")
                                        .image(R.drawable.tres)
                                        .background(android.R.color.holo_orange_light)
                                        .build()
        );

        addSlide((Slide) new SimpleSlide.Builder()
                                        .title("Titulo4")
                                        .description("Descrição4")
                                        .image(R.drawable.quatro)
                                        .background(android.R.color.holo_orange_light)
                                        .build()
        );
    }
}