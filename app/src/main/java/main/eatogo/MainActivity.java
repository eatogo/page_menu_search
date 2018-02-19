package main.eatogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_area,spinner_city;
    ArrayAdapter<String> adapter_area,adapter_city;//在此使用簡易的ArrayAdapter放入值，到spinner_area,spinner_city
    private List<String> list_area;

    String   citys[][]=
            {{"中正區","大同區","中山區","松山區","大安區","萬華區","信義區"},
            {"新莊區","大同區","板橋區","汐止區","深坑區","永和區","中和區","三重區"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,new BlankFragment())
                .addToBackStack(null)
                .commit();
        spinner_area=(Spinner)findViewById(R.id.spinner_area);
        spinner_city=(Spinner)findViewById(R.id.spinner_city);
        spinner_area.setPrompt("請選擇地區");
        initDatas();
        adapter_area=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_area);
        spinner_area.setAdapter(adapter_area);
        spinner_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter_city=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,citys[position]);//通過二維陣列及position的值動態決定下一個選單內容
                adapter_city.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);//設置下拉式選單樣式
                spinner_city.setAdapter(adapter_city);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, " 您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initDatas() {
        list_area=new ArrayList<String>();
        list_area.add("台北市");
        list_area.add("新北市");


    }
}


