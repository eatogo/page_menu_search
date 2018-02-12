package main.eatogo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, null);
        //在fragment視圖中的按鈕
        Button btn = (Button)view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //在這裡使用getActivity
                Intent intent = new Intent(getActivity(),research_menu.class);
                startActivity(intent);
            }
        });
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        return view;
    }


}
