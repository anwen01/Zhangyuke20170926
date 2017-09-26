package com.bwie.zhangyuke20170926;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import imageloader.bwie.com.imageloaderlibrary.UtilImage;

/**
 * 作者：张玉轲
 * 时间：2017/9/26
 */

public class MyAdapter extends BaseAdapter{
    Context context;
    List<Bean.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view=View.inflate(context,R.layout.item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv=view.findViewById(R.id.iv);
            viewHolder.tv=view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else{
             viewHolder= (ViewHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getImg(),viewHolder.iv,UtilImage.getOptions());
        viewHolder.tv.setText(list.get(i).getTitle());
        return view;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }

}
