package cn.lankton.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv = (TextView) this.findViewById(R.id.tv);
        findViewById(R.id.btn_responsebody).setOnClickListener(this);
        findViewById(R.id.btn_gson_converter).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_responsebody:
                intent = new Intent(this, ResponseBodyActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_gson_converter:
                intent = new Intent(this, RepoGsonActivity.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
