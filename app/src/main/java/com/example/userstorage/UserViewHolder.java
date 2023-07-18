package com.example.userstorage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userIconView;
    TextView fullName, email, program;
    LinearLayout userInformation;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userIconView = itemView.findViewById(R.id.userIconView);
        fullName = itemView.findViewById(R.id.txtName);
        email = itemView.findViewById(R.id.txtEmail);
        program = itemView.findViewById(R.id.txtProgram);
        userInformation = itemView.findViewById(R.id.linUserInformation);


    }
}
