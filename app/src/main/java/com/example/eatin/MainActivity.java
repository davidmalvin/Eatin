package com.example.eatin;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import com.yelp.fusion.client.models.AutoComplete;
import com.yelp.fusion.client.models.Business;
import com.yelp.fusion.client.models.Category;
import com.yelp.fusion.client.models.Coordinates;
import com.yelp.fusion.client.models.Reviews;
import com.yelp.fusion.client.models.SearchResponse;
import java.io.*;

import java.lang.ref.Reference;
import java.util.*;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity<Yelpdata> extends AppCompatActivity {


    TextView MyRestaurantTitle, MyRateCat;
    ImageView MyMainImage;
    Map<String, String> Myparams;
    OkHttpClient MyClient;
    public Reference call;
    public String PhoneSearch;
    public String Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRestaurantTitle = (TextView) findViewById(R.id.titleLabel);
        MyRateCat = (TextView) findViewById(R.id.rateCatLabel);
        MyMainImage = (ImageView) findViewById(R.id.main_image);
        MyClient= new OkHttpClient();

        Picasso
                .get()
                .load("http://i.imgur.com/DvpvklR.png")
                .into(MyMainImage);

        MyMainImage.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }


        });
        String apiKey = "tQ8hzd-ABX6MvPBpMqCTec3TBtOx74LFJ4Pu1ALlCGhVAbq7Sn8YVBm3fkCCC9iDOGnV6lYG5UFv8uNjAyBRR1-BdBSrWCxWNcOykvkBbpg_trtJYlaK-abN9piKXHYx";
        YelpFusionApiFactory apiFactory = new YelpFusionApiFactory();
        YelpFusionApi yelpFusionApi = null;
        try {
            yelpFusionApi = apiFactory.createAPI(apiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }


        final Map<String, String> Myparams = new HashMap<>();

// general params
        Myparams.put("term", "indian food");
        Myparams.put("latitude", "40.581140");
        Myparams.put("longitude", "-111.914184");

        Call<SearchResponse> call = yelpFusionApi.getBusinessSearch(Myparams);

        try {
            Response<SearchResponse> response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Call<Business> call1 = (Call<Business>) yelpFusionApi.getBusiness("saffron-valley-south-jordan");
        try {
            Response<Business> response = call1.execute();
        } catch (IOException e) {
            e.printStackTrace();

        }
        Call<SearchResponse> call2 = yelpFusionApi.getPhoneSearch("+18014384823");
        try {
            Response<SearchResponse> response = call2.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Call<SearchResponse> call3 = yelpFusionApi.getBusinessSearch(Myparams);
        SearchResponse searchResponse = null;
        try {
            searchResponse = call3.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalNumberOfResult = searchResponse.getTotal();  // 3

        ArrayList<Business> businesses = searchResponse.getBusinesses();
        String BusinessName = businesses.get(0).getName();  // "JapaCurry Truck"
        Double rating = businesses.get(0).getRating();
        Call<Business> call4 = yelpFusionApi.getBusiness("japacurry-truck-san-francisco");
        Response<Business> response = null;
        try {
            response = call4.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Business business = response.body();

        String businessName = business.getName();  // "JapaCurry Truck"
        Double Rating = business.getRating();


        final YelpFusionApi finalYelpFusionApi = yelpFusionApi;
        final Response<Business> finalResponse = response;
        @TargetApi(Build.VERSION_CODES.CUPCAKE)
        class FetchPictures extends AsyncTask<String, String, String> {

            @SuppressLint("WrongThread")
            @Override
            protected String doInBackground(String... strings) {
                Coordinates Coordinate = null;
                double lattitude;
                double longitude;
                return null;
            }



            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
            }
        }


        {
            Callback<SearchResponse> callback = new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    SearchResponse searchResponse = response.body();
                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {

                }
            };


            YelpFusionApi YelpFusion = new YelpFusionApi() {
                @Override
                public Call<SearchResponse> getBusinessSearch(Map<String, String> params) {
                    return null;
                }

                @Override
                public Call<SearchResponse> getPhoneSearch(String phone) {
                    return null;
                }

                @Override
                public Call<SearchResponse> getTransactionSearch(String transactionType, Map<String, String> params) {
                    return null;
                }

                @Override
                public Call<Business> getBusiness(String id) {
                    return null;
                }

                @Override
                public Call<Reviews> getBusinessReviews(String id, String locale) {
                    return null;
                }

                @Override
                public Call<AutoComplete> getAutocomplete(Map<String, String> Myparams) {
                    return null;
                }
            };        }


        }


    }

