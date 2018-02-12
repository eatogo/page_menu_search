package main.eatogo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.ImageView;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class research_menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_menu);
        ListView lvMenu = (ListView) findViewById(R.id.lvMenu);
        List<foods> foodsList = getFoodsList();
        lvMenu.setAdapter(new FoodAdapter(this, foodsList));
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                foods food = (foods) parent.getItemAtPosition(position);
                String text = "ID = " + food.getId() +
                        ", name = " + food.getName();
                Toast.makeText(research_menu.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class FoodAdapter extends BaseAdapter {
        Context context;
        List<foods> foodsList;

        FoodAdapter(Context context, List<foods> foodsList) {
            this.context = context;
            this.foodsList = foodsList;
        }

        @Override
        public int getCount() {
            return foodsList.size();
        }

        @Override
        public View getView(int position, View itemView, ViewGroup parent) {
            if (itemView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                itemView = layoutInflater.inflate(R.layout.item_view, parent, false);
            }

            foods food = foodsList.get(position);
            ImageView ivImage = (ImageView) itemView
                    .findViewById(R.id.ivMenu);
            ivImage.setImageResource(food.getImage());

            TextView tvId = (TextView) itemView
                    .findViewById(R.id.tvId);
            tvId.setText(String.valueOf(food.getId()));

            TextView tvName = (TextView) itemView
                    .findViewById(R.id.tvName);
            tvName.setText(food.getName());
            return itemView;
        }

        @Override
        public Object getItem(int position) {
            return foodsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return foodsList.get(position).getId();
        }
    }

    public List<foods> getFoodsList() {
        List<foods> foodsList = new ArrayList<>();
        foodsList.add(new foods(23, R.drawable.a1_1, "John"));
        foodsList.add(new foods(75, R.drawable.a1_2, "Jack"));
        foodsList.add(new foods(65, R.drawable.a1_3, "Mark"));
        foodsList.add(new foods(12, R.drawable.a2_1, "Ben"));
        foodsList.add(new foods(92, R.drawable.a2_2, "James"));
        foodsList.add(new foods(103, R.drawable.a2_3, "David"));
        foodsList.add(new foods(45, R.drawable.a3_1, "Ken"));
        foodsList.add(new foods(78, R.drawable.a3_2, "Ron"));
        foodsList.add(new foods(234, R.drawable.a3_3, "Jerry"));
        foodsList.add(new foods(35, R.drawable.a4_1, "Maggie"));
        foodsList.add(new foods(57, R.drawable.a4_2, "Sue"));
        foodsList.add(new foods(61, R.drawable.a4_3, "Cathy"));
        return foodsList;
    }


}
