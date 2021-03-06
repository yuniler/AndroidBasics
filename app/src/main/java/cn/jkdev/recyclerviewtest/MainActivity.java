package cn.jkdev.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cn.jkdev.recyclerviewtest.Adapter.ListViewAdapter;
import cn.jkdev.recyclerviewtest.beans.Datas;
import cn.jkdev.recyclerviewtest.beans.ItemBean;

/**
 * 1.找到控件
 * 2准备数据
 * 3.设置管理器
 * 4.设置适配器
 * 5.数据--》
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mList;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dada
        setContentView(R.layout.activity_main);
        //找到控件
        mList = findViewById(R.id.recyclerView);
        //准备数据
        /**
         * 模拟数据
         */

        initData();
        //设置recyclerView样式显示
        showList();
    }

    /**
     * 初始化数据
     */
    private void initData() {

        //数据是一个list --> List<DataBea> --Adapter -- setAdapter --显示数据
        //创建数据集合 2.
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++){
            //创建数据对象 1.
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第" + i + "个条目";
            //将数据添加到集合 3.
            mData.add(data);
//            //创建Manager -- 给recyclerView 设置管理器--->也就是样式
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//            mList.setLayoutManager(linearLayoutManager);
//
//            //创建Adapter
//            ListViewAdapter adapter = new ListViewAdapter(mData);
//            //设置到listview里面--绑定
//            mList.setAdapter(adapter);
        }

    }

    private void showList() {
        //创建Manager -- 给recyclerView 设置管理器--->也就是样式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mList.setLayoutManager(linearLayoutManager);

        //创建Adapter
        ListViewAdapter adapter = new ListViewAdapter(mData);
        //设置到listview里面--绑定
        mList.setAdapter(adapter);
    }

    /**
     * 二级菜单，使用menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mennu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    /**
     * 找到控件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){
            //ListView
            case R.id.list_view_vertical_stander:
                Log.d(TAG,"点击了View的垂直标准");
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG,"点击了View的垂直标准");
                break;
            case R.id.list_view_horizontal_stander:
                break;
            case  R.id.list_view_horizontal_reverse:
                break;

            //Grid
            case R.id.grid_view_vertical_stander:
                break;
            case R.id.grid_view_vertical_reverse:
                break;
            case R.id.grid_view_horizontal_stander:
                break;
            case R.id.grid_view_horizontal_reverse:
                break;
            //stagger
            case R.id.stagger_view_vertical_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_horizontal_reverse:
                break;
        }
        return true;
    }

}
