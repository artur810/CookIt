package com.example.cookit;

import static com.example.cookit.ui.home.HomeFragment.cards;
import static com.example.cookit.ui.home.HomeFragment.edittext;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogNewRecipes extends DialogFragment {

    private EditText nameRecipes, Recipes;
    private Button newRecipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_recipes, container, false);

        setCancelable(false);

        nameRecipes = view.findViewById(R.id.nameRecipes);
        Recipes = view.findViewById(R.id.recipes);
        newRecipes = view.findViewById(R.id.newRecipes);

        newRecipes.setOnClickListener( v -> {
            if(nameRecipes.getText().toString().trim().isEmpty()){
                nameRecipes.requestFocus();
                nameRecipes.setError("תכניס שם מתכון");
            }else{
                edittext = String.valueOf(nameRecipes.getText());
                cards.add(new Card(edittext));
                PrefConfig.writeListInPref(getContext(), cards);
                this.dismiss();
            }
        });

        return view;
    }
}
