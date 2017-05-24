package io.github.hexiangyuan.sharedelementtransitionsdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import io.github.hexiangyuan.sharedelementtransitionsdemo.R;

/**
 * Creator:HeXiangYuan
 * Date  : 17-2-28
 */

public class FragmentA extends Fragment {
    public static final String TAG = FragmentA.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);

        imageView.setImageDrawable(getContext().getDrawable(R.mipmap.ic_launcher));
        getActivity().findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentB = getFragmentManager().findFragmentByTag(TAG);
                if (fragmentB == null) fragmentB = FragmentB.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView,"simple transition name")
                        .addToBackStack(TAG)
                        .replace(R.id.activity_main, fragmentB)
                        .commit();
            }
        });
    }
}