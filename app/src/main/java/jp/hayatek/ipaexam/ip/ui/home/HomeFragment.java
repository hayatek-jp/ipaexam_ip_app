package jp.hayatek.ipaexam.ip.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.ads.AdRequest;

import jp.hayatek.ipaexam.ip.R;
import jp.hayatek.ipaexam.ip.databinding.FragmentHomeBinding;
import jp.hayatek.ipaexam.ip.learn.BookmarkActivity;
import jp.hayatek.ipaexam.ip.learn.ExamActivity;
import jp.hayatek.ipaexam.ip.learn.QaActivity;
import jp.hayatek.ipaexam.ip.learn.QfieldActivity;
import jp.hayatek.ipaexam.ip.learn.QselectActivity;
import jp.hayatek.ipaexam.ip.learn.QtermActivity;
import jp.hayatek.ipaexam.ip.learn.WeakpointActivity;

public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "HomeFragment created");
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // load ad
        final TextView textView = binding.textCountdown;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        binding.homeAdView.loadAd(new AdRequest.Builder().build());

        // add button listeners
        binding.buttonQa.setOnClickListener(this::onButtonClick);
        binding.buttonQfield.setOnClickListener(this::onButtonClick);
        binding.buttonQterm.setOnClickListener(this::onButtonClick);
        binding.buttonQselect.setOnClickListener(this::onButtonClick);
        binding.buttonExam.setOnClickListener(this::onButtonClick);
        binding.buttonWeakpoint.setOnClickListener(this::onButtonClick);
        binding.buttonBookmark.setOnClickListener(this::onButtonClick);

        return root;
    }

    private void onButtonClick(@NonNull View view) {
        if (view.getId() == R.id.button_qa) {
            Intent intent = new Intent(getActivity(), QaActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.QaActivity");
        } else if (view.getId() == R.id.button_qfield) {
            Intent intent = new Intent(getActivity(), QfieldActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.QfieldActivity");
        } else if (view.getId() == R.id.button_qterm) {
            Intent intent = new Intent(getActivity(), QtermActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.QtermActivity");
        } else if (view.getId() == R.id.button_qselect) {
            Intent intent = new Intent(getActivity(), QselectActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.QselectActivity");
        } else if (view.getId() == R.id.button_exam) {
            Intent intent = new Intent(getActivity(), ExamActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.ExamActivity");
        } else if (view.getId() == R.id.button_weakpoint) {
            Intent intent = new Intent(getActivity(), WeakpointActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.WeakpointActivity");
        } else if (view.getId() == R.id.button_bookmark) {
            Intent intent = new Intent(getActivity(), BookmarkActivity.class);
            startActivity(intent);
            Log.d(TAG, "Moved to .learn.BookmarkActivity");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        Log.d(TAG, "HomeFragment destroyed");
    }
}
