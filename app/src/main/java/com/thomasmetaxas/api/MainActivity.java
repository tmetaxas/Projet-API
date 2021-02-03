package com.thomasmetaxas.api;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.ImageView;
import com.android.volley.Request;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    int number = 1;
    String name = "Luke Skywalker";

    TextView nameLabel, genderLabel, heightLabel, weightLabel, birthDateLabel, eyeColourLabel, hairColourLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLabel = findViewById(R.id.nameLabel);
        genderLabel = findViewById(R.id.genderLabel);
        heightLabel = findViewById(R.id.heightLabel);
        weightLabel = findViewById(R.id.weightLabel);
        birthDateLabel = findViewById(R.id.birthDateLabel);
        eyeColourLabel = findViewById(R.id.eyeColourLabel);
        hairColourLabel = findViewById(R.id.hairColourLabel);

        afficher();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recherche, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Write the full name of a Star Wars character.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                name = query;
                if (name.equals("Luke Skywalker") || name.equals("Luke")) {
                    number = 1;
                } else if (name.equals("C-3PO")) {
                    number = 2;
                } else if (name.equals("R2-D2")) {
                    number = 3;
                } else if (name.equals("Darth Vader")) {
                    number = 4;
                } else if (name.equals("Leia Organa") || name.equals("Leia")) {
                    number = 5;
                } else if (name.equals("Owen Lars") || name.equals("Owen")) {
                    number = 6;
                } else if (name.equals("Beru Lars") || name.equals("Beru")) {
                    number = 7;
                } else if (name.equals("R5-D4")) {
                    number = 8;
                } else if (name.equals("Biggs Darklighter") || name.equals("Biggs")) {
                    number = 9;
                } else if (name.equals("Obi-Wan Kenobi") || name.equals("Obi-Wan")) {
                    number = 10;
                } else if (name.equals("Anakin Skywalker") || name.equals("Anakin")) {
                    number = 11;
                } else if (name.equals("Wilhuff Tarkin") || name.equals("Tarkin")) {
                    number = 12;
                } else if (name.equals("Chewbacca") || name.equals("Chewie")) {
                    number = 13;
                } else if (name.equals("Han Solo") || name.equals("Han") || name.equals("Solo")) {
                    number = 14;
                } else if (name.equals("Greedo")) {
                    number = 15;
                } else if (name.equals("Jabba") || name.equals("Jabba the Hutt") || name.equals("Jabba Desilijic Tiure")) {
                    number = 16;
                } else if (name.equals("Wedge Antilles")) {
                    number = 18;
                } else if (name.equals("Yoda")) {
                    number = 20;
                } else if (name.equals("Palpatine") || name.equals("Sheev Palpatine") || name.equals("Sidious") || name.equals("Darth Sidious")) {
                    number = 21;
                } else if (name.equals("Boba Fett") || name.equals("Boba")) {
                    number = 22;
                } else if (name.equals("IG-88")) {
                    number = 23;
                } else if (name.equals("Bossk")) {
                    number = 24;
                } else if (name.equals("Lando Calrissian") || name.equals("Lando")) {
                    number = 25;
                } else if (name.equals("Lobot")) {
                    number = 26;
                } else if (name.equals("Admiral Ackbar") || name.equals("Ackbar")) {
                    number = 27;
                } else if (name.equals("Mon Mothma")) {
                    number = 28;
                } else if (name.equals("Qui-Gon Jinn") || name.equals("Qui-Gon")) {
                    number = 32;
                } else if (name.equals("Nute Gunray") || name.equals("Gunray")) {
                    number = 33;
                } else if (name.equals("Finis Valorum") || name.equals("Valorum")) {
                    number = 34;
                } else if (name.equals("Padme Amidala") || name.equals("Padme")) {
                    number = 35;
                } else if (name.equals("Jar Jar Binks") || name.equals("Jar Jar")) {
                    number = 36;
                } else if (name.equals("Rugor Nass") || name.equals("Boss Nass")) {
                    number = 38;
                } else if (name.equals("Watto")) {
                    number = 40;
                } else if (name.equals("Sebulba")) {
                    number = 41;
                } else if (name.equals("Shmi Skywalker") || name.equals("Shmi")) {
                    number = 42;
                } else if (name.equals("Darth Maul") || name.equals("Maul")) {
                    number = 43;
                } else if (name.equals("Ayla Secura")) {
                    number = 46;
                } else if (name.equals("Mace Windu") || name.equals("Mace") || name.equals("Windu")) {
                    number = 51;
                } else if (name.equals("Ki-Adi Mundi") || name.equals("Ki-Adi")) {
                    number = 52;
                } else if (name.equals("Kit Fisto") || name.equals("Fisto")) {
                    number = 53;
                } else if (name.equals("Eeth Koth")) {
                    number = 54;
                } else if (name.equals("Adi Gallia") || name.equals("Fisto")) {
                    number = 55;
                } else if (name.equals("Plo Koon") || name.equals("Plo")) {
                    number = 58;
                } else if (name.equals("Mas Amedda") || name.equals("Amedda")) {
                    number = 59;
                } else if (name.equals("Count Dooku") || name.equals("Dooku")) {
                    number = 67;
                } else if (name.equals("Bail Organa") || name.equals("Bail")) {
                    number = 68;
                } else if (name.equals("Jango Fett") || name.equals("Jango")) {
                    number = 69;
                } else if (name.equals("Lama Su")) {
                    number = 72;
                } else if (name.equals("Jocasta Nu") || name.equals("Jocasta")) {
                    number = 74;
                } else if (name.equals("General Grievous") || name.equals("Grievous")) {
                    number = 79;
                }

                afficher();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void afficher() {
        String url = "https://swapi.dev/api/people/" + number + "/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = response.getString("name");
                            int cm = response.getInt("height");
                            double inches = cm*0.393701;
                            int feet = (int) (inches / 12);
                            int leftover = (int) (inches % 12);
                            int mass = response.getInt("mass");
                            String hair = response.getString("hair_color");
                            String eye = response.getString("eye_color");
                            String birth = response.getString("birth_year");
                            String gender = response.getString("gender");
                            nameLabel.setText("Name: " + name);
                            genderLabel.setText("Gender: " + gender);
                            heightLabel.setText("Height: " + feet + "'" + leftover + "''");
                            weightLabel.setText("Weight: " + mass + "kg");
                            birthDateLabel.setText("Birth Date: " + birth);
                            eyeColourLabel.setText("Eye Colour: " + eye);
                            hairColourLabel.setText("Hair Colour: " + hair);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }

}