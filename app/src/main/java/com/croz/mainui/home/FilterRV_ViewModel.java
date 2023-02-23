package com.croz.mainui.home;

public class FilterRV_ViewModel {
    private int _imageRID;
    private int _titleRID;

    public FilterRV_ViewModel(int imageRID, int titleRID) {
        _imageRID = imageRID;
        _titleRID = titleRID;
    }

    public int getTitleRID() { return _titleRID; }
    public int getImageRID() { return _imageRID; }
}
