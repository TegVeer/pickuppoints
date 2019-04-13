package com.example.pickuppoints;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText epic_number;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.pwd_pickup_point_recycler_view);
        epic_number = (EditText)findViewById(R.id.pwd_epic_number_edit_text);
        String[] pickup_names = {"pickup 1","pickup 2","pickup 3","pickup 4","pickup 5","pickup 6"};
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(pickup_names);
        recyclerView.setAdapter(mAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private String[] data;

        public MyAdapter(String[] data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View view = inflater.inflate(R.layout.pwd_recycler_layout,null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
            String name = data[i];
            holder.pickupName.setText(name);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView pickupName,pickupTime;
            private Button pickupLocation;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                pickupName = (TextView)itemView.findViewById(R.id.pickup_point_name);
                pickupTime = (TextView)itemView.findViewById(R.id.pickup_time);
                pickupLocation = (Button)itemView.findViewById(R.id.pickup_location_button);

            }
        }
    }

}
