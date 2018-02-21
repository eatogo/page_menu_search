package main.eatogo;

import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    // 實作 OnMapReadyCallback 介面並覆寫 onMapReady() 方法，以在可以使用 GoogleMap 物件時設定地圖
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //根據預設值，Google Maps Android API 會在使用者輕按標記時顯示資訊視窗的內容。
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
