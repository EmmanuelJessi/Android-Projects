package com.example.basicfragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment2 extends Fragment {
    EditText fragment2Data;
    Button sendData2btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        fragment2Data = view.findViewById(R.id.fragment2Data);
        sendData2btn = view.findViewById(R.id.sendData2btn);

        sendData2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = fragment2Data.getText().toString();
                if(getActivity() instanceof MainActivity) {
                    ((MainActivity)getActivity()).setDataToFragment1(data);
                }
            }
        });

        return view;
    }
}
