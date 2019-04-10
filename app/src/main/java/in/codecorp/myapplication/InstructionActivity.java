package in.codecorp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {
    TextView tIns;
    Button bStart;
    public   String  tid, mtid, ins, dur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        tIns = findViewById(R.id.textView4);
        bStart = findViewById(R.id.button3);
        Intent rcv = getIntent();

        tid = rcv.getStringExtra("tid");
        mtid = rcv.getStringExtra("mtid");
        ins = rcv.getStringExtra("ins");
        dur = rcv.getStringExtra("dur");
        tIns.setText(Html.fromHtml(ins));
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionActivity.this, QuestionsActivity.class);
                intent.putExtra("tid", tid);
                intent.putExtra("mtid", mtid);
                intent.putExtra("ins", ins);
                intent.putExtra("dur", dur);
                startActivity(intent);
            }
        });
    }
}
