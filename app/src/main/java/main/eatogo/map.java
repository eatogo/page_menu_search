package main.eatogo;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class map extends FragmentActivity implements OnMapReadyCallback {
    // 實作 OnMapReadyCallback 介面並覆寫 onMapReady() 方法，以在可以使用 GoogleMap 物件時設定地圖
    private GoogleMap mMap;
    private UiSettings uiSettings;
    private Marker marker_hotpot;
    private LatLng hotpot_shop;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在活動的 onCreate() 方法中，將版面配置檔案設定為內容檢視。
        // 呼叫 FragmentManager.findFragmentById() 以取得地圖片段的控制代碼。
        // 接著，使用 getMapAsync() 來註冊地圖回傳
        setContentView(R.layout.fragment_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        initPoints();
    }


    //當google map物件（ mMap ）可以使用時，會自動呼叫此方法
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //根據預設值，Google Maps Android API 會在使用者輕按標記時顯示資訊視窗的內容。
        mMap = googleMap;
        setUpMap();


    }
    private void initPoints(){
        hotpot_shop = new LatLng(121.49808, 25.06198);//指定店家（在此為旺角迷你石頭火鍋 經緯度）
    }
    //完成地圖相關設定
    private void setUpMap(){
        mMap.setTrafficEnabled(true);//顯示交通資訊
        //如果使用者同意應用程式取得位置資訊，就可以在地圖上顯示自己的位置
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        uiSettings=mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        CameraPosition cameraPosition=new CameraPosition.Builder()
                .target(hotpot_shop).zoom(4).build();
        CameraUpdate cameraUpdate=CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(cameraUpdate);

        // Add a marker in 指定店家, and move the camera.
        marker_hotpot=mMap.addMarker(new MarkerOptions().position(hotpot_shop)
                .title(getString(R.string.marker_title_hotpot_shop))
                .snippet(getString(R.string.marker_snippet_hotpot_shop))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );
        MyMarkerListener myMarkerListener=new MyMarkerListener();
        mMap.setOnMarkerClickListener(myMarkerListener);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hotpot_shop));
    }
private class MyMarkerListener implements GoogleMap.OnMarkerClickListener{
    @Override
    public boolean onMarkerClick(final Marker marker) {
        return false;
    }
}

}
