package com.example.aggoetey.myapplication.pay.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aggoetey.myapplication.R;

public class PayFragment extends Fragment {

    public PayFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pay_fragment, parent, false);

        // kijken of de OrderSelectedFragment ook open staat
        getChildFragmentManager().beginTransaction().replace(R.id.tab_fragment_container, TabFragment.newInstance()).commit();
        if (v.findViewById(R.id.order_detail_fragment_container) != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.order_detail_fragment_container, NoOrderSelectedFragment.newInstance())
                    .commit();
        }

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static PayFragment newInstance() {
        return new PayFragment();
    }

}
