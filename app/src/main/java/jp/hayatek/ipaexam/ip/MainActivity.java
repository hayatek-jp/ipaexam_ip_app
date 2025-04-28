package jp.hayatek.ipaexam.ip;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

import jp.hayatek.ipaexam.ip.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    /** @noinspection FieldCanBeLocal*/
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Application launched");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.exam_name);
        }

        initializeAdMob();
    }

    private void initializeAdMob() {
        MobileAds.initialize(this, initializationStatus -> {
            Map<String, AdapterStatus> adapterStatusMap = initializationStatus.getAdapterStatusMap();
            for (Map.Entry<String, AdapterStatus> entry : adapterStatusMap.entrySet()) {
                String adapterClassName = entry.getKey();
                AdapterStatus adapterStatus = entry.getValue();
                Log.v(TAG, String.format("Adapter Name: %s, State: %s, Description: %s, Latency: %d",
                        adapterClassName,
                        adapterStatus.getInitializationState(),
                        adapterStatus.getDescription(),
                        adapterStatus.getLatency()));
            }
            Log.d(TAG, "AdMob initialization completed");
        });
        Log.d(TAG, "AdMob initialization started");
    }
}
