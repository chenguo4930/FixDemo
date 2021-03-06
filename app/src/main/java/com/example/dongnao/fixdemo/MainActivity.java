package com.example.dongnao.fixdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        findViewById(R.id.caculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calutor calutor = new Calutor();
                result.setText("" + calutor.caculator());
            }
        });
        findViewById(R.id.fix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fix();
            }
        });
    }

    private void fix() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/out.apatch";
        Log.e("tag", "------------路径：" + path);
        PatchManager patchManager = new PatchManager(this);
        patchManager.loadPatch(path);
    }
}
