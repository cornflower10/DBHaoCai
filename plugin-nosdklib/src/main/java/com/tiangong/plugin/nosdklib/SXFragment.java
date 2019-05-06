package com.tiangong.plugin.nosdklib;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SXFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SXFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SXFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private GridView gv;
    private HomeAdapter homeAdapter;
    private int [] mip = {
            R.mipmap.rat,R.mipmap.cattle,R.mipmap.tiger,
            R.mipmap.rabbit,R.mipmap.dragon,R.mipmap.snake,R.mipmap.hourse,
            R.mipmap.sheep,R.mipmap.monkey,R.mipmap.chicken,R.mipmap.dog,
            R.mipmap.pig,};
    private String [] name = {
            "鼠","牛","虎",
            "兔","龙","蛇","马",
            "羊","猴","鸡","狗",
            "猪",};
    private String mParam1;
    private String mParam2;



    public SXFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SXFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SXFragment newInstance() {
        SXFragment fragment = new SXFragment();
        Bundle args = new Bundle();
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
       View view = inflater.inflate(R.layout.fragment_sx, container, false);
        gv = view.findViewById(R.id.gv);
        gv.setNumColumns(2);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i <mip.length ; i++) {
            Item item = new Item();
            item.setId(i);
            item.setImg(mip[i]);
            item.setName(name[i]);
            list.add(item);
        }
        homeAdapter = new HomeAdapter(getContext(),list);
        gv.setAdapter(homeAdapter);

        return view;

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
