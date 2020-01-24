package com.sabekur2017.allinoneandroid.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sabekur2017.allinoneandroid.R;
import com.sabekur2017.allinoneandroid.adapter.RecyclerAdapter;
import com.sabekur2017.allinoneandroid.models.ItemModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View view;
    Context context;
    String name[] = {"C Programming", "C++", "Java", "Python", "Bootstrap", "ASP.NET", "PHP", "Unix", "Cyber Security", "Operating System"};
    int image[] = {R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6,R.drawable.photo_male_6};
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<ItemModel> arrayList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setName(name[i]);
            itemModel.setImage(image[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        adapter = new RecyclerAdapter(context,arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
