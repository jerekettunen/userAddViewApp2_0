package com.example.userstorage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userIconView;
    TextView firstName, lastName, email, program;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userIconView = itemView.findViewById(R.id.userIconView);
        firstName = itemView.findViewById(R.id.txtFirsName);
        lastName = itemView.findViewById(R.id.txtLastName);
        email = itemView.findViewById(R.id.txtEmail);
        program = itemView.findViewById(R.id.txtProgram);

    }
}
