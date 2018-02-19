package main.eatogo;

import android.content.Intent;
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
                        ", name = " + food.getName()+", name2 ="+food.getName2();
                Toast.makeText(research_menu.this, text, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(research_menu.this,Menu_restaurant.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", food.getId());
                bundle.putInt("image",food.getImage());
                bundle.putString("name",food.getName());
                bundle.putString("name2",food.getName2());
                intent.putExtras(bundle);
                startActivity(intent);
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

            foods food = foodsList.get(position);//提供food物件
            ImageView ivImage = (ImageView) itemView
                    .findViewById(R.id.ivMenu);
            ivImage.setImageResource(food.getImage());

            TextView tvId = (TextView) itemView
                    .findViewById(R.id.tvId);
            tvId.setText(String.valueOf(food.getId()));

            TextView tvName = (TextView) itemView
                    .findViewById(R.id.tvName);
            tvName.setText(food.getName());

            TextView tvName2 = (TextView) itemView
                    .findViewById(R.id.tvName2);
            tvName2.setText(food.getName2());
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
        foodsList.add(new foods(1, R.drawable.a1_1, "旺角迷你石頭火鍋","霜降牛肉"));
        foodsList.add(new foods(2, R.drawable.a1_2, "旺角迷你石頭火鍋","美國牛小排"));
        foodsList.add(new foods(3, R.drawable.a1_3, "旺角迷你石頭火鍋","沙文牛肉"));
        foodsList.add(new foods(4, R.drawable.a2_1, "金山肉包王","魯肉包"));
        foodsList.add(new foods(5, R.drawable.a2_2, "金山肉包王","酸菜包"));
        foodsList.add(new foods(6, R.drawable.a2_3, "金山肉包王","鮮蔥肉包"));
        foodsList.add(new foods(7, R.drawable.a3_1, "泰味廚房","椒麻雞"));
        foodsList.add(new foods(8, R.drawable.a3_2, "泰味廚房","辣炒豬肉"));
        foodsList.add(new foods(9, R.drawable.a3_3, "泰味廚房","蝦醬高麗菜"));
        foodsList.add(new foods(10, R.drawable.a4_1, "淡水可口魚丸店","魚丸湯"));
        foodsList.add(new foods(11, R.drawable.a4_2, "淡水可口魚丸店","餛飩湯"));
        foodsList.add(new foods(12, R.drawable.a4_3, "淡水可口魚丸店","肉包"));
        foodsList.add(new foods(13, R.drawable.a5_1, "海堤竹筍餐廳","竹筍扣肉"));
        foodsList.add(new foods(14, R.drawable.a5_2, "海堤竹筍餐廳","南瓜米粉"));
        foodsList.add(new foods(15, R.drawable.a5_3, "海堤竹筍餐廳","和風竹筍"));
        return foodsList;
    }


}
