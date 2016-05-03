package cn.lankton.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by taofangxin on 16/5/3.
 */
public class ResponseBodyActivity extends Activity{
    private TextView tv;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        initView();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        GithubService service = retrofit.create(GithubService.class);

        Call<ResponseBody> call = service.getReposBody("lankton");

        tv.append(retrofit.baseUrl() + "users/lankton/repos\n");
        pd.show();
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                pd.dismiss();
                tv.append("success");
                tv.append("\n" + response.code());
                try {
                    tv.append("\n" + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pd.dismiss();
            }
        });
    }

    private void initView() {
        tv = (TextView) this.findViewById(R.id.tv);
        tv.append("直接以字符串形式输出response的body\n");
        pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setTitle("loading");
    }
}
