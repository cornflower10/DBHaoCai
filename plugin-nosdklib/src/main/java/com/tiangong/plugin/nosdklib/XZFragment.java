package com.tiangong.plugin.nosdklib;


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
 * Use the {@link XZFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XZFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridView gv;
    private XZAdapter homeAdapter;
    private int [] mip = {
            R.mipmap.baiyang,R.mipmap.chunv,R.mipmap.jinniu,
            R.mipmap.juxie,R.mipmap.mojie,R.mipmap.shaungyu,R.mipmap.sheshou,
            R.mipmap.shizi,R.mipmap.shuangzi,R.mipmap.shuiping,R.mipmap.tianping,
            R.mipmap.tianxie,};
    private String [] name = {
            "白羊","处女","金牛",
            "巨蟹","摩羯","双鱼","射手",
            "狮子","双子","水瓶","天秤","天蝎",
            };
    public XZFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment XZFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static XZFragment newInstance() {
        XZFragment fragment = new XZFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
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
       View view = inflater.inflate(R.layout.fragment_xz, container, false);
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
        homeAdapter = new XZAdapter(getContext(),list,1);
        gv.setAdapter(homeAdapter);
        return view;
    }

}
