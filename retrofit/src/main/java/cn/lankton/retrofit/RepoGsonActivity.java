package cn.lankton.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import cn.lankton.retrofit.bean.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by taofangxin on 16/5/3.
 */
public class RepoGsonActivity extends Activity{
    private TextView tv;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        initView();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubService service = retrofit.create(GithubService.class);

        Call<List<Repo>> call = service.listRepos("lankton");

        tv.append(retrofit.baseUrl() + "users/lankton/repos\n");
        pd.show();
        call.enqueue(new Callback<List<Repo>>() {

            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                pd.dismiss();
                tv.append("success");
                tv.append("\n" + response.code());
//                tv.append("\n" + response.body().toString());
                List<Repo> list = response.body();
                for (Repo repo : list) {
                    tv.append("\n" + repo.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                pd.dismiss();
            }
        });
    }

    private void initView() {
        tv = (TextView) this.findViewById(R.id.tv);
        tv.append("GSON方式解析body转换为bean\n");
        pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setTitle("loading");
    }
}
