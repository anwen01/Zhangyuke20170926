package com.bwie.zhangyuke20170926;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.limxing.xlistview.view.XListView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private XListView xlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xlv = (XListView) findViewById(R.id.xlv);
        xlv.setPullLoadEnable(true);
        xlv.setXListViewListener(this);

        getinfoData();
    }

    public void getinfoData(){
        getData("http://japi.juhe.cn/health_knowledge/infoList?key=fd67edb600c3a063e44559efaf483aeb");
    }
    public void getData(String url){
        new AsyncTask<String,Void,String>(){

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s==null){
                    return;
                }
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,data);
                xlv.setAdapter(myAdapter);

            }

            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    int code = connection.getResponseCode();
                    if (code==200){
                        InputStream is = connection.getInputStream();
                        String s = MyUtil.getStr(is);
                        System.out.println("============"+s);
                        return s;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute(url);
    }

    @Override
    public void onRefresh() {
    }

    @Override
    public void onLoadMore() {

    }

    //修改。。。。。

    //子分支
    //11111


}
