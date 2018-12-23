package com.example.a26316.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public String ddm = "https://qr.alipay.com/00c066334qcl365yxfhbo3e";//点单码
    public String hbm = "7604175";//红包码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ling = findViewById(R.id.kaishi);
        Button yong = findViewById(R.id.shiyong);
        final Button help = findViewById(R.id.help);

        ling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "请按照提示操作", Toast.LENGTH_SHORT).show();
                lhb();

           }
        });


        yong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //扫点单码
                Uri uri = Uri.parse(ddm);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "请允许打开支付宝", Toast.LENGTH_LONG).show();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.a26316.myapplication.help.class);
                startActivity(intent);
            }
        });


    }



//    这种网页直接跳转的方式现在支付宝修复了
// private void lhb() {
//       try {
//            String url = "https://qr.alipay.com/cpx04135fvwhjubor2gzx4d\n";
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(.parse(url));
//            startActivity(intent);
//            Toast.makeText(this, "请允许打开外部应用", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            Toast.makeText(this, "没有检测到支付宝，请确定您已安装", Toast.LENGTH_SHORT).show();
//        }

//   }



// 领红包----------使用设置系统剪切板内容然后自行粘贴的方式
    public void lhb()
    {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage("com.eg.android.AlipayGphone");
        startActivity(intent);


        // 获取系统剪贴板
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）
        ClipData cd = ClipData.newPlainText(null,hbm);
        // 把数据集复制到剪贴板
        if(cm != null)
        {
            cm.setPrimaryClip(cd);
        }else {
            Toast.makeText(this, "错误，检测到剪贴板复制失败，请联系开发者", Toast.LENGTH_SHORT).show();
            }
        Toast.makeText(this, "已复制到剪贴板，请在顶部搜索框直接搜索", Toast.LENGTH_LONG).show();
    }






}