package com.y;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by zf on 2015/5/12.
 */
public class A extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a);
        this.findViewById(R.id.mybutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent();
                intent.setClass(A.this, B.class);
                User user = new User();
                user.setUserName("小明");
                user.setPassword("abc123");
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}
