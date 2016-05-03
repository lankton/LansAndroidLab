package cn.lankton.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import cn.lankton.dagger2.cn.lankton.dagger2.models.Student;
import cn.lankton.dagger2.modules.MainActivityModule;

public class MainActivity extends AppCompatActivity {
    private MainActivityComponent mainActivityComponent;

    @Inject
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityComponent = DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule()).build();
        mainActivityComponent.inject(this);
        ((TextView) findViewById(R.id.tv)).setText("No: "
                + student.getNumber()
                + "\nName: " + student.getName());
    }
}
