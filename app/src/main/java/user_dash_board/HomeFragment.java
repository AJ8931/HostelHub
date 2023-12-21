package user_dash_board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileappdevelopment.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView hostelRecyclerView;
    private HostelAdapter hostelAdapter;
    private List<hostelCardDescription> hostelList;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        hostelRecyclerView = view.findViewById(R.id.hostelRecyclerView);
        progressBar = view.findViewById(R.id.progressBar);

        // Set up RecyclerView and its adapter
        hostelList = new ArrayList<>();
        hostelAdapter = new HostelAdapter(hostelList);
        hostelRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        hostelRecyclerView.setAdapter(hostelAdapter);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("hostelOwners");

        // Fetch hostels from Firebase
        fetchHostelsFromFirebase();

        return view;
    }

    private void fetchHostelsFromFirebase() {
        progressBar.setVisibility(View.VISIBLE);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hostelList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    hostelCardDescription hostel = snapshot.getValue(hostelCardDescription.class);
                    hostelList.add(hostel);
                }

                hostelAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                // Handle database error
            }
        });
    }
}
