package com.example.brainbreathe.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.brainbreathe.R;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.Nullable;

import com.example.brainbreathe.databinding.FragmentDashboardBinding;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.brainbreathe.databinding.ActivityMainBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

        */






        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Botón: Feliz
        ImageButton emojiHappy = view.findViewById(R.id.emojiHappy);
        emojiHappy.setOnClickListener(v ->
                Toast.makeText(getContext(), "Te sientes feliz 😊", Toast.LENGTH_SHORT).show());

        // Botón: Triste
        ImageButton emojiSad = view.findViewById(R.id.emojiSad);
        emojiSad.setOnClickListener(v ->
                Toast.makeText(getContext(), "Te sientes triste 😢", Toast.LENGTH_SHORT).show());

        // Botón: Enfadado
        ImageButton emojiAngry = view.findViewById(R.id.emojiGood);
        emojiAngry.setOnClickListener(v ->
                Toast.makeText(getContext(), "Te sientes enfadado 😠", Toast.LENGTH_SHORT).show());

        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}