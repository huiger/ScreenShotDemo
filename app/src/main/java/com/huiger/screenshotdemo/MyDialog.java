package com.huiger.screenshotdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by <lzh> on 2017/8/3.
 */

public class MyDialog {
    private Dialog dialog;
    private Context context;
    private static MyDialog MyDialog = null;
    private View rootView;

    public static MyDialog getInstance() {
        if (MyDialog == null) {
            synchronized (MyDialog.class) {
                if (MyDialog == null) {
                    MyDialog = new MyDialog();
                }
            }
        }

        return MyDialog;
    }

    private MyDialog() {
    }


    public MyDialog init(Context context, @LayoutRes int resId){
        this.context = context;
        rootView = LayoutInflater.from(context).inflate(resId, null);
        dialog = new AlertDialog.Builder(context).create();
        dialog.show();
        dialog.setContentView(rootView);
        return this;
    }


    public MyDialog setPositiveButton(String str, final OnClickListener listener) {
        Button button = (Button) rootView.findViewById(R.id.btn1);
        button.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    dialog.dismiss();
                } else {
                    listener.OnClick(v);
//                    dialog.dismiss();
                }
            }
        });
        return this;
    }

    public MyDialog setCancelButton(String str, final OnClickListener listener) {
        Button button = (Button) rootView.findViewById(R.id.btn2);
        button.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    dialog.dismiss();
                } else {
                    listener.OnClick(v);
                    dialog.dismiss();
                }
            }
        });
        return this;
    }



    public View getView(@IdRes int resId){
        return rootView.findViewById(resId);
    }

    public interface OnClickListener {
        void OnClick(View view);
    }
}
