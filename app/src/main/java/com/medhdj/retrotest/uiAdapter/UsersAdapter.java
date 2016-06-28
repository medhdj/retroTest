package com.medhdj.retrotest.uiAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.medhdj.retrotest.R;
import com.medhdj.retrotest.bean.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by youness on 26/06/16.
 */
public class UsersAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    List<User> users;

    public void updateData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    static class ViewHolder {
       @BindView(R.id.userName) TextView userName;

        ViewHolder(View v) {
            ButterKnife.bind(this,v);
        }
    }

    public UsersAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        users = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        User user = getItem(i);
        holder.userName.setText(user.name + " -> " + user.company.siege);
        return view;
    }
}
