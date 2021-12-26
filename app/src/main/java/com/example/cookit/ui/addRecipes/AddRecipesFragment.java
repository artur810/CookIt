package com.example.cookit.ui.addRecipes;

import static com.example.cookit.ui.home.HomeFragment.cards;
import static com.example.cookit.ui.home.HomeFragment.edittext;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.cookit.Card;
import com.example.cookit.PrefConfig;
import com.example.cookit.R;

public class AddRecipesFragment extends Fragment {

    private EditText nameRecipes;
    private Button newRecipes, cancelNewRecipes;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_recipes, container, false);
        
        nameRecipes = view.findViewById(R.id.nameRecipes);
        newRecipes = view.findViewById(R.id.newRecipes);
        cancelNewRecipes = view.findViewById(R.id.cancelNewRecipes);

        newRecipes.setOnClickListener( v -> {
            if(nameRecipes.getText().toString().trim().isEmpty()){
                nameRecipes.requestFocus();
                nameRecipes.setError("תכניס שם מתכון");
            }else{
                edittext = String.valueOf(nameRecipes.getText());
                cards.add(new Card(edittext));
                PrefConfig.writeListInPref(getContext(), cards);
                nameRecipes.setText("");
            }
        });

        cancelNewRecipes.setOnClickListener(v -> {
            nameRecipes.setText("");
            nameRecipes.setFocusable(false);
        });

        return view;
    }

}