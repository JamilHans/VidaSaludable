package com.example.vidasaludable.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vidasaludable.R;

import java.lang.reflect.Array;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageViewPage, imageViewFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageViewPage = (ImageView) findViewById(R.id.imageViewPage);
        imageViewFacebook = (ImageView) findViewById(R.id.imageViewFacebook);

        imageViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gob.pe/minsa"));
                startActivity(intent);
            }
        });

        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/minsaperu"));
                startActivity(intent);
            }
        });

    }
}