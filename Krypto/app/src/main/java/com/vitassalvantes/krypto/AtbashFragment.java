package com.vitassalvantes.krypto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtbashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtbashFragment extends Fragment {
    private String outputMessage = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AtbashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtbashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtbashFragment newInstance(String param1, String param2) {
        AtbashFragment fragment = new AtbashFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atbash, container, false);
    }

    public void onEncryptMessage(View view) {
        final AtbashCipher ac = new AtbashCipher();
        final EditText inputMessage = (EditText) getView().findViewById(R.id.inputMessage);
        ac.setInputMessage(String.valueOf(inputMessage.getText()));

        outputMessage = ac.encryption();

        NavHostFragment navHostFragment =
                (NavHostFragment) FragmentManager.findFragment(getView().findViewById(R.id.nav_host_fragment));
        NavController navController = navHostFragment.getNavController();
    }
}