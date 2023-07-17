package com.example.userstorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users;

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.firstName.setText("Etunimi: " + users.get(position).getFirstName());
        holder.lastName.setText("Sukunimi: " + users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
        holder.program.setText(users.get(position).getDegreeProgram());
        holder.userIconView.setImageResource(users.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
