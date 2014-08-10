package com.michaldabski.panoramiotest.photo_activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.michaldabski.panoramiotest.models.Photo;

import java.util.Locale;

/**
 * Created by Michal on 10/08/2014.
 */
public class PhotoDetailsDialogFragment extends DialogFragment
{
    public static final String TAG = "photo_details_dialog";
    public static final String ARG_PHOTO = "photo";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Photo photo = getArguments().getParcelable(ARG_PHOTO);
        return new AlertDialog.Builder(getActivity())
                .setTitle("Photo details")
                .setMessage(getPhotoDetails(photo))
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    CharSequence getPhotoDetails(Photo photo)
    {
        return String.format(Locale.ENGLISH, "Title: %s\n" +
                "Owner: %s\n" +
                "Location: %f %f\n" +
                "Size: %d x %d px\n" +
                "Upload date: %s",
                photo.getPhotoTitle(), photo.getOwnerName(),
                photo.getLatitude(), photo.getLongitude(),
                photo.getWidth(), photo.getHeight(),
                photo.getUploadDate());
    }

    public static PhotoDetailsDialogFragment newInstance(Photo photo)
    {
        Bundle args = new Bundle(1);
        args.putParcelable(ARG_PHOTO, photo);
        PhotoDetailsDialogFragment fragment = new PhotoDetailsDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
