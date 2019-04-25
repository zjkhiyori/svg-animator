package club.syachiku.svganimator;

import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView imageView = findViewById(R.id.imgView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (checked) {
                        imageView.setImageDrawable(getDrawable(R.drawable.ani_back));
                        checked = false;
                    } else {
                        imageView.setImageDrawable(getDrawable(R.drawable.ani_menu));
                        checked = true;
                    }
                    ((Animatable) imageView.getDrawable()).start();
                } else {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_back));
                }
            }
        });
    }
}
