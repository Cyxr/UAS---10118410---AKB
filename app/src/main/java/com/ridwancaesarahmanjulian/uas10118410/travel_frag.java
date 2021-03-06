//12 Agustus 2021, 10118410, Ridwan Caesarahman Julian, IF-10
package com.ridwancaesarahmanjulian.uas10118410;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class travel_frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public travel_frag () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment info_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static travel_frag newInstance(String param1, String param2) {
        travel_frag  fragment = new travel_frag ();
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

        View view = inflater.inflate(R.layout.travel_page, container, false);

        Button btnBuat = (Button) view.findViewById(R.id.btnBooking);
        btnBuat.setOnClickListener(v -> {
            Intent in = new Intent(getActivity(),booking_activity.class);
            in.putExtra("some","some data");
            startActivity(in);
        });

        return view;
    }
}