package user_dash_board;

public class hostelCardDescription {
    private String hostelName;
    private String location;
    private String imageUrl;

    public hostelCardDescription() {
        // Default constructor required for Firebase
    }

    public hostelCardDescription(String hostelName, String location, String imageUrl) {
        this.hostelName = hostelName;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public String getHostelName() {
        return hostelName;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

