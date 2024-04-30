package com.example.basicfragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    TextView dataFrom2;
    EditText fragment1Data;
    Button sendData1btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        dataFrom2 = view.findViewById(R.id.dataFrom2);
        fragment1Data = view.findViewById(R.id.fragment1Data);
        sendData1btn = view.findViewById(R.id.sendData1btn);

        sendData1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = fragment1Data.getText().toString();
                if(getActivity() instanceof MainActivity) {
                    ((MainActivity)getActivity()).setDataToFragment2(data);
                }
            }
        });

        return view;
    }

    public void updateData(String data) {
        dataFrom2.setText(data);
    }
}
