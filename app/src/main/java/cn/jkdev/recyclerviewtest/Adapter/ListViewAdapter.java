package cn.jkdev.recyclerviewtest.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.jkdev.recyclerviewtest.R;
import cn.jkdev.recyclerviewtest.beans.ItemBean;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    public final List<ItemBean> mData;


    public ListViewAdapter(List<ItemBean> data){
        this.mData = data;
    }

    /**
     * 创建条目的View
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //1.拿到View
        //2.创建内部Holder
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        //返回的是item的页面
        return new InnerHolder(view);

    }

    /**
     * 绑定内部holder,一般用来设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        holder.setData(mData.get(position));

    }

    /**
     * 返回条目个数
     * @return
     */
    @Override
    public int getItemCount() {

        if (mData != null) {
            return mData.size();//后面不执行
        }
       return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            //找到条目控件初始化
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);
        }

        public void setData(ItemBean itemBean) {
            //开始设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }

}
