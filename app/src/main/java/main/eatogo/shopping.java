package main.eatogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class shopping extends AppCompatActivity {
    private Spinner spinner_select_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Button button = (Button)this.findViewById(R.id.bt_confirm_order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tst = Toast.makeText(shopping.this, "確認後不得更改", Toast.LENGTH_SHORT);
                tst.show();
                Intent intent = new Intent(shopping.this, buy_show.class);//在此要更改其他跳轉頁面
                startActivity(intent);
            }
        });

    }
}
