package in.codecorp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {

    String a;
    TextView amount, apply, famount;
    EditText coupon;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        init();
    }

    void init(){
        Intent rcv = getIntent();
        a = rcv.getStringExtra("PRICE");
        amount = findViewById(R.id.textViewAmount);
        apply = findViewById(R.id.textView14);
        famount = findViewById(R.id.textView15);
        coupon = findViewById(R.id.editText);
        pay = findViewById(R.id.button2);
        amount.setText( a);
        famount.setText(a);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = coupon.getText().toString().trim();
                if(f.equalsIgnoreCase("SSCGC4") ||
                        f.equalsIgnoreCase("SSCGC3") ||
                        f.equalsIgnoreCase("SSCGC2") ||
                        f.equalsIgnoreCase("SSCGC1") ||
                        f.equalsIgnoreCase("RRBNTPC3") ||
                        f.equalsIgnoreCase("RRBNTPC2") ||
                        f.equalsIgnoreCase("RRBNTPC1") ||
                        f.equalsIgnoreCase("SSCCGL2017") ){

                    Toast.makeText(getApplicationContext(),"Coupon Applied", Toast.LENGTH_LONG).show();
                    famount.setText("Amount is 0");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Coupon Invalid", Toast.LENGTH_LONG).show();
                    famount.setText("Amount is"+ a);
                }
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
