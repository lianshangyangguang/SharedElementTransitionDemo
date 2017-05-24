package io.github.hexiangyuan.sharedelementtransitionsdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = FragmentA.class.getSimpleName();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setImageDrawable(getDrawable(R.mipmap.ic_launcher));
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentB = getSupportFragmentManager().findFragmentByTag(TAG);
                if (fragmentB == null) fragmentB = FragmentB.newInstance();
                getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView,"simple transition name")
                        .addToBackStack(TAG)
                        .replace(R.id.fragment, fragmentB)
                        .commit();
            }
        });


//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FragmentA.class.getName());
//        if (fragment == null) {
//            fragment = FragmentA.newInstance();
//        }
//        getSupportFragmentManager().beginTransaction().add(R.id.activity_main,
//                fragment,
//                FragmentA.class.getName())
//                .commit();
    }
}