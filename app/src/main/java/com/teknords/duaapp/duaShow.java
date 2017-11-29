package com.teknords.duaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class duaShow extends AppCompatActivity {
    int[] duas={R.drawable.dua15,R.drawable.dua1,R.drawable.dua2,R.drawable.dua3,R.drawable.dua4,R.drawable.dua5,R.drawable.dua6,R.drawable.dua7,R.drawable.dua8,R.drawable.dua9,R.drawable.dua10,R.drawable.dua11,R.drawable.dua12,R.drawable.dua13,R.drawable.dua14,R.drawable.dua};
    int[] audios={R.raw.audio,R.raw.audio1,R.raw.audio2,R.raw.audio3,R.raw.audio4,R.raw.audio5,R.raw.audio6,R.raw.audio7,R.raw.audio8,R.raw.audio9,R.raw.audio10,R.raw.audio11,R.raw.audio12,R.raw.audio13,R.raw.audio14,R.raw.audio15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_show);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("selectedDua", 0);

        ImageView imageViewDua =(ImageView)findViewById(R.id.imageViewDua);

        imageViewDua.setImageResource(duas[intValue]);

        Button btnPlay = (Button)findViewById(R.id.buttonPlay);
        Button btnPause = (Button)findViewById(R.id.buttonPause);
        Button btnStop = (Button)findViewById(R.id.buttonStop);
        Button btnshare = (Button)findViewById(R.id.share);


        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });




        final MediaPlayer mp = MediaPlayer.create(duaShow.this,audios[intValue]);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });




        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });




        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                duaShow.this.finish();
            }
        });





    }
}