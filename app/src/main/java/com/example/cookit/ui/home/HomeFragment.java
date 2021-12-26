package com.example.cookit.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.cookit.Card;
import com.example.cookit.DialogNewRecipes;
import com.example.cookit.PrefConfig;
import com.example.cookit.R;
import com.example.cookit.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static String edittext = "מתכון";
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    public static List<Card> cards;
    private RecyclerViewAdapter adapter;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if(PrefConfig.readListFromPref(getContext()) != null && !PrefConfig.readListFromPref(getContext()).isEmpty()){
            cards = PrefConfig.readListFromPref(getContext());
        }else {
            cards = new ArrayList<>();
        }

        recyclerView = view.findViewById(R.id.recycler_view);
        fab = view.findViewById(R.id.fab);

        recyclerViewAdapter();

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            recyclerViewAdapter();
            swipeRefreshLayout.setRefreshing(false);
        },500));


        fab.setOnClickListener(v -> {

            DialogNewRecipes dialogFragment = new DialogNewRecipes();
            dialogFragment.show(getParentFragmentManager(), "dialog fragment");

        });

        return view;
    }

    private void recyclerViewAdapter(){

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(), cards);
        recyclerView.setAdapter(adapter);

    }

}