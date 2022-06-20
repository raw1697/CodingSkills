package com.example.riderlog;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ordersToTakeFragment extends Fragment {

    private View v;
    private RecyclerView myrecyclerview;
    private List<orders> listOrders;

    private DatabaseReference ordersRef, UsersRef;
    private FirebaseAuth mAuth;
    private String currentUserID;


    public ordersToTakeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // regular recyclerView

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_orders_to_take, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.unassigned_orders_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listOrders);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);


        return v;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //normal array recycleView.......

        listOrders = new ArrayList<>();

        //listOrders.add(new orders("Food department","Food item name"));

        listOrders.add(new orders("From our Bakery","Tesco Tomato Cheese And Garlic Swirly"));
        listOrders.add(new orders("Food Cupboard","Aleyna Roasted Red Peppers 480G"));
    }

    





}

// commented work that could still be used.

/*
    private View v;
    private RecyclerView myrecyclerview;
    //private List<orders> listOrders;

    private DatabaseReference ordersRef, UsersRef;
    private FirebaseAuth mAuth;
    private String currentUserID;


    public ordersToTakeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_orders_to_take, container, false);

        mAuth = FirebaseAuth.getInstance();

        currentUserID = mAuth.getCurrentUser().getUid();

        ordersRef = FirebaseDatabase.getInstance().getReference().child("orders").child("basket").child(currentUserID);
        UsersRef = FirebaseDatabase.getInstance().getReference().child("users").child("orders").child("basket");

        myrecyclerview = (RecyclerView) v.findViewById(R.id.unassigned_orders_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));


        // regular recyclerView
*/
/*
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_orders_to_take, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.unassigned_orders_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listOrders);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
*//*


        return v;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<orders>()
                        .setQuery(ordersRef, orders.class)
                        .build();

        FirebaseRecyclerAdapter<orders, OrdersViewHolder> adapter = new FirebaseRecyclerAdapter<orders, OrdersViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final OrdersViewHolder holder, int position, @NonNull orders model) {

                String userIDs = getRef(position).getKey();

                UsersRef.child(userIDs).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        if(dataSnapshot.hasChild("basket")){
                            String profileTitle = dataSnapshot.child("title").getValue().toString();
                            String profileDescription = dataSnapshot.child("description").getValue().toString();

                            holder.depart.setText(profileDescription);
                            holder.title.setText(profileTitle);


                        }
                        else
                        {
                            String profileTitle = dataSnapshot.child("title").getValue().toString();
                            String profileDescription = dataSnapshot.child("description").getValue().toString();

                            holder.depart.setText(profileDescription);
                            holder.title.setText(profileTitle);

                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

            @NonNull
            @Override
            public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
            {


                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_unassigned, viewGroup, false);
                OrdersViewHolder viewHolder = new OrdersViewHolder(view);

                return viewHolder;
            }
        };

        myrecyclerview.setAdapter(adapter);
        adapter.startListening();
    }

public static class OrdersViewHolder extends RecyclerView.ViewHolder
{
    TextView depart, superDepart, title;

    public OrdersViewHolder(@NonNull View itemView) {
        super(itemView);

        depart = itemView.findViewById(R.id.text_view_description);
        title = itemView.findViewById(R.id.text_view_title);
    }
}
*/
