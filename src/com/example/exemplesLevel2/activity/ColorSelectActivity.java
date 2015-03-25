package com.example.exemplesLevel2.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.exemplesLevel2.R;


public class ColorSelectActivity extends FragmentActivity {

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int color = v.getId();
            setResult(color);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_color);

        findViewById(R.id.placeholder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout topColorsHolder = (LinearLayout) findViewById(R.id.topColorsHolder);
        LinearLayout bottomColorsHolder = (LinearLayout) findViewById(R.id.bottomColorsHolder);
        initColorsBar(topColorsHolder, bottomColorsHolder);
    }

    private void initColorsBar(LinearLayout topColorsHolder, LinearLayout bottomColorsHolder) {
        int[] colors = Util.getColorsArray(this);
        for (int i = 0; i < colors.length; i++) {
            if (i < colors.length / 2) {
                addColorView(topColorsHolder, colors[i]);
            } else {
                addColorView(bottomColorsHolder, colors[i]);
            }
        }
    }

    private void addColorView(LinearLayout parent, int color) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(Color.WHITE);
        ColorDrawable drawable = new ColorDrawable(color);
        imageView.setImageDrawable(drawable);
        int padding = (int) Util.convertDpToPixel(1, this);
        imageView.setPadding(padding, padding, padding, padding);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
        imageView.setLayoutParams(params);
        imageView.setOnClickListener(listener);
        imageView.setId(color);
        parent.addView(imageView);
    }

}
