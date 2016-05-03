package cn.lankton.retrofit;

import java.util.List;

import cn.lankton.retrofit.bean.Repo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by taofangxin on 16/5/3.
 */
public interface GithubService {
    @GET("users/{user}/repos")
    Call<ResponseBody> getReposBody(@Path("user") String user);
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
