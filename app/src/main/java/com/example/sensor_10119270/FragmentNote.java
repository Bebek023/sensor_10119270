package com.example.sensor_10119270;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

//10119270
//Albanna Rahmadani Sulistyo
//IF-7

public class FragmentNote extends Fragment implements OnMapReadyCallback {

    GoogleMap map;

    LatLng saiRamen = new LatLng(-6.902036918799413, 107.61564011525813);
    LatLng kupatTahuGempol = new LatLng(-6.9029472098051015, 107.6155207487316);
    LatLng bakmiJowoDU = new LatLng(-6.889670453869958, 107.61591895370825);
    LatLng baguetteBakery = new LatLng(-6.884848581411593, 107.61677451001029);
    LatLng seiSapi = new LatLng(-6.897910543355818, 107.61758656378053);

    private ArrayList<LatLng> locationArrayList;

    private ListView noteListView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationArrayList = new ArrayList<>();
        locationArrayList.add(saiRamen);
        locationArrayList.add(kupatTahuGempol);
        locationArrayList.add(bakmiJowoDU);
        locationArrayList.add(baguetteBakery);
        locationArrayList.add(seiSapi);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        for (int i=0; i < locationArrayList.size(); i++) {
            switch (i) {
                case 0:
                    map.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Sai Ramen"));
                    break;
                case 1:
                    map.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Kupat Tahu Gempol"));
                    break;
                case 2:
                    map.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Bakmi Jowo DU"));
                    break;
                case 3:
                    map.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Baguette Bakery"));
                    break;
                case 4:
                    map.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Sei Sapi"));
                    break;
            }
        }
        map.moveCamera(CameraUpdateFactory.newLatLng(seiSapi));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
}
