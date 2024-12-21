package com.example.que_2;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    private Switch switchSound, switchVibration, switchLED, switchBanners, switchContent, switchLockScreen;
    private Button saveButton;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchSound = findViewById(R.id.Sound);
        switchVibration = findViewById(R.id.Vibration);
        switchLED = findViewById(R.id.LED);
        switchBanners = findViewById(R.id.Banners);
        switchContent = findViewById(R.id.Content);
        switchLockScreen = findViewById(R.id.Lockscreen);
        saveButton = findViewById(R.id.button);
        preferences = getSharedPreferences("NotificationPrefs", MODE_PRIVATE);
        loadPreferences();
        saveButton.setOnClickListener(view -> . showBottomSheet());


    private void loadPreferences()
    {
        switchSound.setChecked(preferences.getBoolean("Sound", false));
        switchVibration.setChecked(preferences.getBoolean("Vibration", false));
        switchLED.setChecked(preferences.getBoolean("LED", false));
        switchBanners.setChecked(preferences.getBoolean("Banners", false));
        switchContent.setChecked(preferences.getBoolean("Content", false));
        switchLockScreen.setChecked(preferences.getBoolean("LockScreen", false));
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("Sound", switchSound.isChecked());
        editor.putBoolean("Vibration", switchVibration.isChecked());
        editor.putBoolean("LED", switchLED.isChecked());
        editor.putBoolean("Banners", switchBanners.isChecked());
        editor.putBoolean("Content", switchContent.isChecked());
        editor.putBoolean("LockScreen", switchLockScreen.isChecked());
        editor.apply();

        Toast.makeText(this, "Preferences Saved!", Toast LENGTH_SHORT).show();
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout);

        Button confirmButton = bottomSheetDialog.findViewById(R.id.btn_confirm);
        Button cancelButton = bottomSheetDialog.findViewById(R.id.btn_cancel);

        confirmButton.setOnClickListener( -> {
            savePreferences();
            bottomSheetDialog.dismiss();
        });

        cancelButton.setOnClickListener(v -> bottomSheetDialog.dismiss());

        bottomSheetDialog.show();
    }
}
