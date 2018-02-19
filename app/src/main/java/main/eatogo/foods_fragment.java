package main.eatogo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class foods_fragment extends Fragment {
    private foods foods;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            foods=(foods)getArguments().getSerializable("foods");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_foods_fragment,container,false);
        ImageView ivfoods=(ImageView) view.findViewById(R.id.vpfoods);
        ivfoods.setImageResource(foods.getImage());
        return view;
    }
}
