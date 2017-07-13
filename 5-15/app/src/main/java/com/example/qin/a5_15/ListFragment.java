package com.example.qin.a5_15;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Qin on 7/13/2017.
 */

public class ListFragment extends android.app.ListFragment {
    boolean dualPane;
    int curCheckPosition = 0;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_checked, Data.TITLES));
        View detailFrame = getActivity().findViewById(R.id.detail);
        dualPane = detailFrame != null && detailFrame.getVisibility() == View.VISIBLE;
        if(savedInstanceState != null) {
            curCheckPosition = savedInstanceState.getInt("onSavedChoice", 0);
        }
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        if(dualPane) {
            showDetails(curCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("onSavedChoice", curCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        curCheckPosition = position;
        showDetails(position);
    }

    private void showDetails(int index) {
        if(dualPane) {
            getListView().setItemChecked(index, true);
            DetailFragment details = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail);
            if (details == null || details.getShownIndex() != index) {
                details = DetailFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.detail, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.DetailActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
