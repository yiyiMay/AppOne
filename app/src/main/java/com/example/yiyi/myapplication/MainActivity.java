package com.example.yiyi.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

// View.OnClickListener（） 按钮监听器    View定义的点击事件的监听器接口，并在接口中仅定义了onClick()函数
//   监听事件处理步骤：
//      1、 获取事件源(findViewById)
//      2、 实现事件监听类，该类是一个特殊的Java类，必须实现XxxListener接口
//      3、 将监听器注册到组件上(SetXxxListener,例如SetOnClickListener)

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button); // findViewById 获取事件源
        Button buttonT = (Button) findViewById(R.id.buttonTwo);

        // 为按钮绑定事件监听器。
        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"已取消",Toast.LENGTH_LONG).show();
                    }
                })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create()
                        .show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 接口Dialog Builder ：弹出消息框、确认取消框、文本框......
                layout=(LinearLayout)getLayoutInflater().inflate(R.layout.user,null);
                builder.setTitle("登录")
                        .setView(layout);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"已取消",Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("确定",new ok())
                .create()
                .show();
            }

            class cancel implements DialogInterface.OnClickListener{
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }

            class ok implements DialogInterface.OnClickListener{
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-gengerated method stub
                    EditText username=(EditText)layout.findViewById(R.id.username);
                    EditText password=(EditText)layout.findViewById(R.id.password);
                    String user=username.getText().toString();
                    String pass=password.getText().toString();
                    String a="abc";
                    String b="123";

                    if(user.equals(a)&& pass.equals(b)){
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"用户名密码不正确",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
