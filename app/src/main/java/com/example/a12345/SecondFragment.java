package com.example.a12345;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    ArrayList<Book> bookModel = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rvRecycle2);
        setUpAminoAcidModels();

        // Initialize adapter and set it to the RecyclerView
        RecycleViewAdapter adapter = new RecycleViewAdapter(getContext(), bookModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // Set layout manager
        return rootView;
    }

    private void setUpAminoAcidModels(){
        bookModel.add(new Book("1","AA", "AAA", "AAAA", R.drawable.img));
        bookModel.add(new Book("2","BB", "BBB", "BBBB", R.drawable.img));
        bookModel.add(new Book("3","AA", "AAA", "AAAA", R.drawable.img));
        bookModel.add(new Book("4","BB", "BBB", "BBBB", R.drawable.img));
        bookModel.add(new Book("5","AA", "AAA", "AAAA", R.drawable.img));
        bookModel.add(new Book("6","BB", "BBB", "BBBB", R.drawable.img));
    }
}