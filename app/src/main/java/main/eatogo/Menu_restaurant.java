package main.eatogo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class Menu_restaurant extends AppCompatActivity {
    private List<foods> foodsList;
    private ViewPager vpfoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);
        List<foods> foodsList=getFoodsList();
        FoodAdapter foodAdapter =new FoodAdapter(getSupportFragmentManager(),foodsList);
        vpfoods=(ViewPager)findViewById(R.id.vpfoods);
        vpfoods.setAdapter(foodAdapter);
        Button button = (Button)this.findViewById(R.id.bt_to_menu_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_restaurant.this, Menu_menu.class);
                startActivity(intent);
            }
        });


    }

    public List<foods> getFoodsList() {
        foodsList = new ArrayList<>();
        foodsList.add(new foods(1, R.drawable.a1_1, "旺角迷你石頭火鍋","霜降牛肉"));
        foodsList.add(new foods(2, R.drawable.a1_2, "旺角迷你石頭火鍋","美國牛小排"));
        foodsList.add(new foods(3, R.drawable.a1_3, "旺角迷你石頭火鍋","沙文牛肉"));
        return foodsList;
    }

    private class FoodAdapter extends FragmentStatePagerAdapter{
        List<foods> foodsList;
        private FoodAdapter(FragmentManager fm,List<foods> foodsList){
            super(fm);
            this.foodsList=foodsList;
        }

        @Override
        public int getCount(){
            return foodsList.size();
        }
        @Override
        public Fragment getItem(int position){
            foods food = foodsList.get(position);
            foods_fragment fragment=new foods_fragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("image",food.getImage());
            fragment.setArguments(bundle);
            return fragment;
        }
    }
}
