package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import static java.lang.Thread.*;


public class MainActivity extends AppCompatActivity {

    int noOfRows=3,noOfColumns=3;
    int[] myImageList;
    ArrayList<Integer> list;
    ImageView[] imageViews;
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        levelcheck();

    }
    public void levelcheck() {
        generateImages();
    }
    public void generateImages(){

        myImageList = new int[]{R.drawable.circleorange, R.drawable.circlegreen, R.drawable.circleyellow,R.drawable.circleorange, R.drawable.circlegreen, R.drawable.circleyellow,R.drawable.circleorange, R.drawable.circlegreen, R.drawable.circleyellow};
        list=new ArrayList<>();
        for(int i=0;i<myImageList.length;i++)
        {
            list.add(myImageList[i]);
        }
        Collections.shuffle(list);
        imageViews=new ImageView[]{findViewById(R.id.v0),findViewById(R.id.v1),findViewById(R.id.v2),findViewById(R.id.v3),findViewById(R.id.v4),findViewById(R.id.v5),findViewById(R.id.v6),findViewById(R.id.v7),findViewById(R.id.v8)};
        for(int i =0;i<9; i++)
        {
            imageViews[i].setImageResource(list.get(i));
        }
            BlinkingImages();
    }
    public void BlinkingImages()  {
        int a=4;
        for(int i=0;i<a;i++){
            Random randomNum = new Random();
            final int num = randomNum.nextInt(8);
            Log.i("Image", String.valueOf(num));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blink(num);
                }
            }, 3000);


        }
    }

    public void blink(final int num) {


        ImageView image=imageViews[num];
        image.setAlpha(0);

    }
}