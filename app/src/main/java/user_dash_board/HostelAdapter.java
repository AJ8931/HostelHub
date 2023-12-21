package user_dash_board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectmobileappdevelopment.R;

import java.util.List;

public class HostelAdapter extends RecyclerView.Adapter<HostelAdapter.HostelViewHolder> {

    private final List<hostelCardDescription> hostelList;

    public HostelAdapter(List<hostelCardDescription> hostelList) {
        this.hostelList = hostelList;
    }

    @NonNull
    @Override
    public HostelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hostel, parent, false);
        return new HostelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HostelViewHolder holder, int position) {
        hostelCardDescription hostel = hostelList.get(position);
        holder.bind(hostel);
    }

    @Override
    public int getItemCount() {
        return hostelList.size();
    }

    public class HostelViewHolder extends RecyclerView.ViewHolder {
        private final ImageView hostelImageView;
        private final TextView hostelNameTextView;
        private final TextView locationTextView;

        public HostelViewHolder(@NonNull View itemView) {
            super(itemView);
            hostelImageView = itemView.findViewById(R.id.hostelImageView);
            hostelNameTextView = itemView.findViewById(R.id.hostelNameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
        }

        public void bind(hostelCardDescription hostel) {
            Glide.with(itemView.getContext()).load(hostel.getImageUrl()).into(hostelImageView);

            hostelNameTextView.setText(hostel.getHostelName());
            locationTextView.setText(hostel.getLocation());
        }
    }
}