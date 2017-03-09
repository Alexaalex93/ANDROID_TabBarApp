package com.example.alex.tabbbarapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cice on 9/3/17.
 */

//TODOS LOS FRAGMENTS NECESITAN UN FRAGMENT PAGE ADAPTER
public class PageFragment extends Fragment {

    public static String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static PageFragment newInstance(int page){

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) v;
        textView.setText("Fragment #" + mPage);

        return v;

    }
}
