package com.example.chatgptify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView chatRecyclerView;
    private TextView welcomeTextView;
    private EditText messageEditText;
    private ImageButton sendButton;
    private ArrayList<Message> messageArrayList;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Initialization
        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendImageButton);

        //Data Holder Initialization
        messageArrayList = new ArrayList<Message>();

        //Recycler View Setup
        messageAdapter = new MessageAdapter(messageArrayList);
        chatRecyclerView.setAdapter(messageAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setStackFromEnd(true);
        chatRecyclerView.setLayoutManager(layoutManager);

        //Send Button On Click Listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = messageEditText.getText().toString();
                addToChat(question, Message.SENT_BY_ME);
                messageEditText.setText("");
                welcomeTextView.setVisibility(View.GONE);
            }
        });
    }

    private void addToChat(String message, String sender){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageArrayList.add(new Message(message,sender));
                messageAdapter.notifyDataSetChanged();
                chatRecyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });

    }
}