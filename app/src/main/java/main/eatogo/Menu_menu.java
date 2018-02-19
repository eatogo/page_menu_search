package main.eatogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_menu);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name2");
        TextView textView = (TextView)this.findViewById(R.id.tv_foodresult);
        textView.setText("I love " + name + " !!!");
        Button button = (Button)this.findViewById(R.id.bt_shopping);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_menu.this, shopping.class);
                startActivity(intent);

            }
        });
    }
}
