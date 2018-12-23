package com.example.a26316.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class help extends AppCompatActivity {
    public Button zhifubao;
    public Button koukuanshunxu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        zhifubao = findViewById(R.id.lianxi_zhifubao);
        koukuanshunxu = findViewById(R.id.koukuan);

        koukuanshunxu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "1.请您登录手机客户端，点击【我的】—【设置】—【支付设置】\n" +
                        "2.点击【扣款顺序】查看，顺序从上至下排序，若您需要调整该付款顺序，您直接按住右边拖动至您想要的顺序即可。";
                koukuanshunxu.setText(str);
                Toast.makeText(help.this, "由于支付宝没有开放此接口，无法一键跳转，请手动前往", Toast.LENGTH_LONG).show();
            }
        });

        zhifubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage("com.eg.android.AlipayGphone");
                startActivity(intent);

                // 获取系统剪贴板
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）
                ClipData cd = ClipData.newPlainText(null,"#吱口令#长按复制此条消息，打开支付宝即可添加我为好友IfJq8B754i");
                // 把数据集复制到剪贴板
                cm.setPrimaryClip(cd);


            }
        });


    }





}