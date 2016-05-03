package cn.lankton.dagger2;

import cn.lankton.dagger2.modules.MainActivityModule;
import dagger.Component;

/**
 * Created by taofangxin on 16/4/27.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
