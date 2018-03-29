package main.eatogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class buy_show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_show);
        Button button = (Button)this.findViewById(R.id.bt_to_likey_page_select);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tst = Toast.makeText(buy_show.this, "進入評價頁面", Toast.LENGTH_SHORT);
                tst.show();
                Intent intent = new Intent(buy_show.this, shopping.class);//在此要更改其他跳轉頁面
                startActivity(intent);
            }
        });
    }
}
