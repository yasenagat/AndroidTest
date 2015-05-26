package com.y;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by zf on 2015/5/12.
 */
public class B extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.b);

        User user = getIntent().getParcelableExtra("user");
        TextView textView = (TextView) this.findViewById(R.id.mytext);
        textView.setText(user.getUserName() + user.getPassword());
    }
}
