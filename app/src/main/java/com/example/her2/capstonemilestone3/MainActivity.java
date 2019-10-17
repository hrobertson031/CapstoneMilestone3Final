package com.example.her2.capstonemilestone3;
//import all the classes needed
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
//all the variables used, each color used in the palette and each element from the app
public class MainActivity extends AppCompatActivity {
    private LinearLayout rootLayout;
    private TextView textViewTitle;
    private TextView PixText;
    private ImageView image;
    private TextView PixNum;
    private Palette.Swatch Vibrant;
    private Palette.Swatch Light_Vibrant;
    private Palette.Swatch Dark_Vibrant;
    private Palette.Swatch Muted;
    private Palette.Swatch Light_Muted;
    private Palette.Swatch Dark_Muted;

    private int switchNum;
//The onCreate is what happens when the app open
    //inside this will get the IDs for the elements in the app
    // the palette will be create during this from the bitmap
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.rootLayout);
        textViewTitle = findViewById(R.id.text_view_title);
        PixText = findViewById(R.id.PixText);
        image = findViewById(R.id.image_view);
        PixNum = findViewById(R.id.PixNum);

        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();

        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Vibrant = palette.getVibrantSwatch();
                Light_Vibrant = palette.getLightVibrantSwatch();
                Dark_Vibrant = palette.getDarkVibrantSwatch();
                Muted = palette.getMutedSwatch();
                Light_Muted = palette.getLightMutedSwatch();
                Dark_Muted = palette.getDarkMutedSwatch();
            }
        });
    }

//function connected to the OnClick

    public void nextColor(View view)
    {
        //variables used to store values to be printed out
        int temp = 0;
        int R;
        int G;
        int B;
        Integer tempPop = 0;
        Palette.Swatch color = null;
        //switch statement, 1 case for each color
        switch(switchNum)
        {
            case 0:
                //the getRgb gets the int number, then converts to get sections red,green,blue
                color = Vibrant;
                temp = Vibrant.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                //set the text to the color value
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Vibrant.getPopulation();
                //after getting the population of pixels, sets the text to the number
                PixNum.setText(tempPop.toString());
                break;
                //repeats the process each color
            case 1:
                color = Muted;
                temp = Muted.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Muted.getPopulation();
                PixNum.setText(tempPop.toString());
                break;
            case 2:
                color = Dark_Muted;
                temp = Dark_Muted.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Dark_Muted.getPopulation();
                PixNum.setText(tempPop.toString());
                break;
            case 3:
                color = Dark_Vibrant;
                temp = Dark_Vibrant.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Dark_Vibrant.getPopulation();
                PixNum.setText(tempPop.toString());
                break;
            case 4:
                color = Light_Muted;
                temp = Light_Muted.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Light_Muted.getPopulation();
                PixNum.setText(tempPop.toString());
                break;
            case 5:
                color = Light_Vibrant;
                temp = Light_Vibrant.getRgb();
                R = (temp & 0xff0000) >> 16;
                G = (temp & 0x00ff00) >> 8;
                B = (temp & 0x0000ff) >> 0;
                textViewTitle.setText("R = "+R+ ",G = "+G+",B= "+B);
                tempPop = Light_Muted.getPopulation();
                PixNum.setText(tempPop.toString());
                break;

        }
        //if the color has been changed, it sets the background, and text color
        if (color != null) {
            rootLayout.setBackgroundColor(color.getRgb());
            textViewTitle.setTextColor(color.getTitleTextColor());
            PixText.setTextColor(color.getBodyTextColor());
            PixNum.setTextColor(color.getBodyTextColor());
        } else {
            //if it is null it was not been changed to a color so it will be blank
            rootLayout.setBackgroundColor(Color.WHITE);
            textViewTitle.setTextColor(Color.RED);
            PixText.setTextColor(Color.RED);
            PixNum.setTextColor(Color.RED);
        }
        //Puts the switch into a loop
        if (switchNum < 5) {
            switchNum++;
        } else {
            switchNum = 0;
        }
    }


}