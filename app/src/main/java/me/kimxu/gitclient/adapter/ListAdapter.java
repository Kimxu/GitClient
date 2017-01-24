package me.kimxu.gitclient.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import me.kimxu.gitclient.R;
import me.kimxu.gitclient.databinding.ItemBinding;
import me.kimxu.gitclient.model.GitSearchResult;

/**
 * Created by kimxu on 2017/1/23.
 */

public class ListAdapter extends BaseAdapter{

    private final LayoutInflater mInflater;

    private List<GitSearchResult.ItemsBean> mItemsBeen = new ArrayList<>();

    public ListAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addContact(List<GitSearchResult.ItemsBean> items) {
        mItemsBeen.clear();
        mItemsBeen.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemsBeen.size();
    }

    @Override
    public GitSearchResult.ItemsBean getItem(int position) {
        return mItemsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, parent, false);
            holder.itemBinding = DataBindingUtil.bind(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemBinding.setItem(getItem(position));

        return convertView;
    }

    class ViewHolder {
        ItemBinding itemBinding;
    }
}
