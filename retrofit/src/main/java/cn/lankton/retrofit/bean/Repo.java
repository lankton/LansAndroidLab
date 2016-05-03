package cn.lankton.retrofit.bean;

/**
 * Created by taofangxin on 16/5/3.
 */
public class Repo {
    String name;
    String html_url;
    String description;
    int stargazers_count;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + "\n");
        sb.append("url: " + html_url + "\n");
        sb.append("description: " + description + "\n");
        sb.append("stars: " + stargazers_count);
        return sb.toString();
    }
}
