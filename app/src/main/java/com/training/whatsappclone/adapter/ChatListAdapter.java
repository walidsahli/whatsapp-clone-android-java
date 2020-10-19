package com.training.whatsappclone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.training.whatsappclone.R;
import com.training.whatsappclone.models.ChatListItem;

import java.util.ArrayList;

public class ChatListAdapter  extends androidx.recyclerview.widget.RecyclerView.Adapter<ChatListAdapter.ChatViewHolder> {

    private ArrayList<ChatListItem> chatList;

    public ChatListAdapter(ArrayList<ChatListItem> data) {
        this.chatList = data;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_list_item, parent, false);
        return new ChatViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.name.setText(chatList.get(position).getPersons()[0]);
        holder.message.setText(chatList.get(position).getLastMessage());
        holder.time.setText(chatList.get(position).getLastMessageTime());
        holder.numberMessages.setText("1");
        holder.profileImage.setImageResource(R.drawable.profile);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView message;
        TextView time;
        TextView numberMessages;
        ImageView profileImage;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);;
            this.message = itemView.findViewById(R.id.message);;
            this.numberMessages = itemView.findViewById(R.id.nb_messages);
            this.time = itemView.findViewById(R.id.time);;
            this.profileImage = itemView.findViewById(R.id.profile_image);
        }
    }
}
