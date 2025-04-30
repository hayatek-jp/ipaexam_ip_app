package jp.hayatek.ipaexam.ip.ui.learn.exam;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.hayatek.ipaexam.ip.R;

public class ExamQuestionFragment extends Fragment {

    private ExamViewModel mViewModel;

    public static ExamQuestionFragment newInstance() {
        return new ExamQuestionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam_question, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ExamViewModel.class);
        // TODO: Use the ViewModel
    }

}