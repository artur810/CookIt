package com.example.cookit.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.cookit.R;

public class NotificationsFragment extends Fragment {

    private TextView text_notifications;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        text_notifications = view.findViewById(R.id.text_notifications);
        text_notifications.setText("This is notifications fragment");

        return view;
    }

}