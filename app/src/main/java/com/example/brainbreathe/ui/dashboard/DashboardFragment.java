package com.example.brainbreathe.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        Button btnAction = view.findViewById(R.id.btnAction);

        // Botón: Feliz
        ImageButton emojiHappy = view.findViewById(R.id.emojiHappy);
        emojiHappy.setOnClickListener(v ->
                mostrarBoton(btnAction, "1"));

        // Botón: Triste
        ImageButton emojiSad = view.findViewById(R.id.emojiSad);
        emojiSad.setOnClickListener(v ->
                mostrarBoton(btnAction, "2"));

        // Botón: Enfadado
        ImageButton emojiAngry = view.findViewById(R.id.emojiGood);
        emojiAngry.setOnClickListener(v ->
                mostrarBoton(btnAction, "3"));


        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void mostrarBoton(Button boton, String texto){

        String link = "";
        switch (texto){
            case "1":
                link = "https://www.youtube.com/watch?v=ZbZSe6N_BXs";
                boton.setText("I can see that you are having a great day, here you have a video to keep it like that");
                break;
            case "2":
                link = "https://www.youtube.com/watch?v=thcEuMDWxoI";
                boton.setText("I can see that today is not your best day, we recommend you to do this meditation");
                break;
            default:
                link = "https://www.youtube.com/watch?v=mk48xRzuNvA";
                boton.setText("I can see that today is not your best day neither your worst, here you have a motivational video");
                break;
        }

        boton.setOnClickListener(v -> {
            // URL del video de
            String link1 = "";
            switch (texto){
                case "1":
                    link1 = "https://www.youtube.com/watch?v=ZbZSe6N_BXs";
                    boton.setText("I can see that you are having a great day, here you have a video to keep it like that");
                    break;
                case "2":
                    link1 = "https://www.youtube.com/watch?v=thcEuMDWxoI";
                    boton.setText("I can see that today is not your best day, we recommend you to do this meditation");
                    break;
                default:
                    link1 = "https://www.youtube.com/watch?v=mk48xRzuNvA";
                    boton.setText("I can see that today is not your best day neither your worst, here you have a motivational video");
                    break;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link1));
            intent.setPackage("com.google.android.youtube"); // Forzar YouTube App si está instalada

            // Fallback: si YouTube no está instalada, abrir con navegador
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Abrir con cualquier navegador
                Intent fallback = new Intent(Intent.ACTION_VIEW, Uri.parse(link1));
                startActivity(fallback);
            }
        });


        boton.setVisibility(View.VISIBLE);
    }
}