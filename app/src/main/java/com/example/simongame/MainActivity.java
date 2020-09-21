package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;

import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    int noOfRows=3,noOfColumns=3;

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
        GridLayout gridLayout=findViewById(R.id.gridLayout);

        gridLayout.removeAllViews();
        gridLayout.setRowCount(noOfRows);
        gridLayout.setColumnCount(noOfColumns);
        for(int i=0;i<noOfRows;i++)
        {
            for(int j=0;j<noOfColumns;j++)
            {
                Log.i("Row coloumn:" , i+" "+j);
                ImageView imageView=new ImageView(this);
                imageView.setImageResource(R.drawable.circleorange);
                GridLayout.LayoutParams param=new GridLayout.LayoutParams();
                param.height=320;
                param.width=320;
                param.bottomMargin=3;
                param.rightMargin=3;
                param.leftMargin=3;
                param.topMargin=3;
                param.setGravity(Gravity.CENTER);
                param.columnSpec=GridLayout.spec(j);
                param.rowSpec=GridLayout.spec(i);
                imageView.setLayoutParams(param);
                imageView.setId(i+j);
                gridLayout.addView(imageView);

            }
        }
        BlinkingImages();
    }
    public void BlinkingImages(){

        ImageView[] imageViews=new ImageView[]{};


    }
}