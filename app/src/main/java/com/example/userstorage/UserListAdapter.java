package com.example.userstorage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.fullName.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
        holder.program.setText(users.get(position).getDegreeProgram());
        holder.userIconView.setImageResource(users.get(position).getIcon());

        if (users.get(position).getDegrees().size() >= 1) {
            TextView title = new TextView(context);
            title.setText("Suoritetut tutkinnot");
            title.setTextColor(Color.BLACK);
            holder.userInformation.addView(title);
            for (String degree : users.get(position).getDegrees()) {
                TextView degreeTxt = new TextView(context);
                String text = "- " + degree;
                degreeTxt.setText(text);
                degreeTxt.setTextColor(Color.BLACK);
                holder.userInformation.addView(degreeTxt);
            }
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
