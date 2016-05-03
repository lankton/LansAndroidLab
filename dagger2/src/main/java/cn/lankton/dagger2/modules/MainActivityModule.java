package cn.lankton.dagger2.modules;

import cn.lankton.dagger2.cn.lankton.dagger2.models.Student;
import dagger.Module;
import dagger.Provides;

/**
 * Created by taofangxin on 16/4/27.
 */
@Module
public class MainActivityModule {
    @Provides
    Student provideStudent() {
        return new Student(3, "tom");
    }

}
