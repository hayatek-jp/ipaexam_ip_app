package jp.hayatek.ipaexam.ip.ui.settings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import jp.hayatek.ipaexam.ip.databinding.FragmentSettingsBinding;
import jp.hayatek.ipaexam.ip.ui.settings.SettingsViewModel;

public class SettingsFragment extends Fragment {
    private static final String TAG = SettingsFragment.class.getSimpleName();
    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "SettingsFragment created");
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSettings;
        settingsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.d(TAG, "SettingsFragment destroyed");
    }
}
