package com.training.whatsappclone.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.whatsappclone.R;
import com.training.whatsappclone.adapter.ChatListAdapter;
import com.training.whatsappclone.models.ChatListItem;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ViewGroup header;

    String [] persons  = {"Hello", "World"};

    ArrayList<ChatListItem> fakeData = new ArrayList<ChatListItem>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fakeData.add(new ChatListItem("1" , persons , "Today", "Hey"));
        fakeData.add(new ChatListItem("2" , persons , "Yesterday", "You there?!"));
        fakeData.add(new ChatListItem("3" , persons , "1st Oct", "I ll call you in moment so please answer me later"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.chat_tab, container, false);
        recyclerView = fragmentView.findViewById(R.id.my_recycler_view);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ChatListAdapter(fakeData);
        recyclerView.setAdapter(mAdapter);

        return fragmentView;
    }
}
