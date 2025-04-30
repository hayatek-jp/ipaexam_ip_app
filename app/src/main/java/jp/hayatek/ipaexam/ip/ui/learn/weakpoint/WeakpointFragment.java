package jp.hayatek.ipaexam.ip.ui.learn.weakpoint;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.hayatek.ipaexam.ip.R;

public class WeakpointFragment extends Fragment {

    private WeakpointViewModel mViewModel;

    public static WeakpointFragment newInstance() {
        return new WeakpointFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weakpoint, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeakpointViewModel.class);
        // TODO: Use the ViewModel
    }

}