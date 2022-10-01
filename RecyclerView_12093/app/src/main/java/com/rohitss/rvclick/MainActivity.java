package com.rohitss.rvclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TestItem> languages;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            TestItem thisItem = languages.get(position);
            Toast.makeText(MainActivity.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        languages = new ArrayList<>();
        TestItem item;

        item = new TestItem("Python", "This is a programming language");
        languages.add(item);

        item = new TestItem("C", "This is a programming language");
        languages.add(item);

        item = new TestItem("C++", "This is a programming language");
        languages.add(item);

        item = new TestItem("Objective C", "This is a programming language");
        languages.add(item);

        item = new TestItem("Java", "This is a programming language");
        languages.add(item);

        item = new TestItem("Kotlin", "This is a programming language");
        languages.add(item);

        item = new TestItem("Ruby on Rails", "This is a programming language");
        languages.add(item);

        item = new TestItem("Swift", "This is a programming language");
        languages.add(item);

        item = new TestItem("Scala", "This is a programming language");
        languages.add(item);

        item = new TestItem("SQL", "This is used for writing queries");
        languages.add(item);

        item = new TestItem("PHP", "This is a programming language");
        languages.add(item);

        item = new TestItem("JavaScript", "This is a programming language");
        languages.add(item);

        item = new TestItem("HTML", "This is a markup language");
        languages.add(item);

        item = new TestItem("CSS", "This is used for designing websites");
        languages.add(item);

        MyRecyclerAdapter recyclerViewAdapter = new MyRecyclerAdapter(languages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(onItemClickListener);

    }
}
