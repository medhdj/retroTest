package com.medhdj.retrotest.app;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.medhdj.retrotest.R;
import com.medhdj.retrotest.bean.User;
import com.medhdj.retrotest.uiAdapter.UsersAdapter;
import com.medhdj.retrotest.ws.RestClient;
import com.medhdj.retrotest.ws.RestDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.usersList)
    ListView usersListView;

    UsersAdapter usersListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        usersListAdapter = new UsersAdapter(this);
        usersListView.setAdapter(usersListAdapter);

        RestClient restClient = new RestClient();
        final ProgressDialog progressDialog = ProgressDialog.show(this,"Loading","",true);
        restClient.getUsers(new RestDelegate() {
            @Override
            public void onSuccess(Object o) {
                List<User> users = (List<User>) o;
                usersListAdapter.updateData(users);
                progressDialog.dismiss();
            }

            @Override
            public void onError() {
                progressDialog.dismiss();
            }
        });
    }
}
