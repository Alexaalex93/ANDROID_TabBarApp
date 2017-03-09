package com.example.alex.tabbbarapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cice on 9/3/17.
 */

public class SampleFragmentPageAdapter extends FragmentPagerAdapter {

    //Para cambiar el color de las pestañas podrías detectar aqui donde estas y cambiarlo
    final int PAGE_COUNT = 3;
    private String tabTitle[] = new String[]{"Tab 1", "Tab 2", "Tab 3"};

    private int [] imageResID = {R.drawable.ic_3d_rotation_black_24dp,
            R.drawable.ic_assignment_turned_in_black_24dp, R.drawable.ic_cast_connected_black_24dp};
    private Context context;



    public SampleFragmentPageAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;

    }
    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable image = ContextCompat.getDrawable(context, imageResID[position]);
        image.setBounds(0,0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString st = new SpannableString("  ");//String que se puede ampliar, lo hacemos para que no quede tan pegado
        ImageSpan imageSpan = new ImageSpan(image,ImageSpan.ALIGN_BOTTOM);
        st.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return st;
        //Generamos titulo en funcion de la posicion
        //return tabTitle[position];
    }

    public View getTabView (int position){

        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(tabTitle[position]);

        ImageView iv = (ImageView) v.findViewById(R.id.imageView);

        iv.setImageResource(imageResID[position]);

        return v;

    }
}
