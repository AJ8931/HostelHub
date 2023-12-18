package com.example.projectmobileappdevelopment;

public class HostelOwner {
    private String username;
    private String hostelName;
    private String location;
    private String contactNumber;
    private boolean wifi;
    private boolean parking;
    private boolean laundry;
    private int singleRooms;
    private double singlePrice;
    private int doubleRooms;
    private double doublePrice;
    private int sharedRooms;
    private double sharedPrice;
    private String imageBase64; // Updated field name

    public HostelOwner() {
        // Default constructor required for calls to DataSnapshot.getValue(HostelOwner.class)
    }

    public HostelOwner(String username, String hostelName, String location, String contactNumber,
                       boolean wifi, boolean parking, boolean laundry,
                       int singleRooms, double singlePrice,
                       int doubleRooms, double doublePrice,
                       int sharedRooms, double sharedPrice,
                       String imageBase64) { // Updated parameter name
        this.username = username;
        this.hostelName = hostelName;
        this.location = location;
        this.contactNumber = contactNumber;
        this.wifi = wifi;
        this.parking = parking;
        this.laundry = laundry;
        this.singleRooms = singleRooms;
        this.singlePrice = singlePrice;
        this.doubleRooms = doubleRooms;
        this.doublePrice = doublePrice;
        this.sharedRooms = sharedRooms;
        this.sharedPrice = sharedPrice;
        this.imageBase64 = imageBase64; // Updated field name
    }

    // Add getters and setters for the new field if needed

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public int getSingleRooms() {
        return singleRooms;
    }

    public void setSingleRooms(int singleRooms) {
        this.singleRooms = singleRooms;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public int getDoubleRooms() {
        return doubleRooms;
    }

    public void setDoubleRooms(int doubleRooms) {
        this.doubleRooms = doubleRooms;
    }

    public double getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(double doublePrice) {
        this.doublePrice = doublePrice;
    }

    public int getSharedRooms() {
        return sharedRooms;
    }

    public void setSharedRooms(int sharedRooms) {
        this.sharedRooms = sharedRooms;
    }

    public double getSharedPrice() {
        return sharedPrice;
    }

    public void setSharedPrice(double sharedPrice) {
        this.sharedPrice = sharedPrice;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
