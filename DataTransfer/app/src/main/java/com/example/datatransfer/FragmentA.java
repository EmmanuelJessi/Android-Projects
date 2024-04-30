package com.example.datatransfer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FragmentA extends Fragment {

    private EditText editTextInput;
    private Button buttonSendData;
    private SharedViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Initialize views
        editTextInput = view.findViewById(R.id.edit_text_input);
        buttonSendData = view.findViewById(R.id.button_send_data);

        // Set onClickListener for the button to send data to FragmentB
        buttonSendData.setOnClickListener(v -> sendDataToFragmentB());

        return view;
    }

    private void sendDataToFragmentB() {
        String inputData = editTextInput.getText().toString().trim();
        viewModel.setData(inputData);

        // Navigate to FragmentB
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentB())
                .addToBackStack(null)
                .commit();
    }
}
