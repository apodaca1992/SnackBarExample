package com.example.adrian.snackbarexample;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.showSnackbar();

        this.showCustomSnackbar();

        this.showCustomViewSnackbar();

        this.showSnackbarHere();
    }

    // A standard usage of android Snackbar.
    private void showSnackbar()
    {
        Button showSnackbarButton = (Button)findViewById(R.id.showSnackbarButton);

        showSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Snackbar instance, the message is displayed at the left side.
                Snackbar snackbar = Snackbar.make(view, "A short message is comming!", Snackbar.LENGTH_LONG);
                // Set button with text Open at right side..
                snackbar.setAction("Open", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // When user click Open button, an AlertDialog will be displayed.
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setMessage("Hello, welcome to use snackbar.");
                        alertDialog.show();
                    }
                });


                // Set the Callback function.
                snackbar.setCallback(new Snackbar.Callback(){
                    @Override
                    public void onShown(Snackbar sb) {
                        Toast.makeText(MainActivity.this, "Snackbar has been shown.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        Toast.makeText(MainActivity.this, "Snackbar is dismessed.", Toast.LENGTH_SHORT).show();
                    }
                });

                // Show it at screen bottom.
                snackbar.show();
            }
        });
    }

    // Custom Snackbar.
    private void showCustomSnackbar()
    {
        Button showCustomSnackbarButton = (Button)findViewById(R.id.showCustomSnackbarButton);

        showCustomSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "A friend send a message!", Snackbar.LENGTH_LONG);
                snackbar.setAction("Show", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setMessage("Hello, i am from dev2qa.com.");
                        alertDialog.show();
                    }
                });

                // Set action text color.
                snackbar.setActionTextColor(Color.RED);

                // Get Snackbar view.
                Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout)snackbar.getView();

                // Set background color.
                snackbarView.setBackgroundColor(Color.BLUE);

                // Set message text color.
                TextView messageTextView = snackbarView.findViewById(R.id.snackbar_text);
                messageTextView.setTextColor(Color.GREEN);
                messageTextView.setTextSize(20);

                snackbar.show();
            }
        });
    }

    // Custom Snackbar view content from a layout xml file.
    private void showCustomViewSnackbar()
    {
        Button showCustomViewSnackbarButton = (Button)findViewById(R.id.showCustomViewSnackbarButton);

        showCustomViewSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance.
                Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
                snackbar.setAction("Show", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setMessage("Hello custom snackbar.");
                        alertDialog.show();
                    }
                });

                // Get the view object.
                Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();

                // Get custom view from external layout xml file.
                View customView = getLayoutInflater().inflate(R.layout.activity_snack_bar_custom_view, null);

                snackbarView.addView(customView, 0);

                snackbar.show();
            }
        });
    }

    // Open a snackbar near the source widget..
    private void showSnackbarHere()
    {
        // The source widget need to be wrapped in a CoordinatorLayout xml element in layout xml file.
        Button showSnackbarHereButton = (Button)findViewById(R.id.showSnackbarHereButton);

        showSnackbarHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance.
                Snackbar snackbar = Snackbar.make(view, "Snack bar is shown near source widget", Snackbar.LENGTH_LONG);
                snackbar.setAction("Show", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setMessage("dev2qa.com --- Learn java, android easy and simple.");
                        alertDialog.show();
                    }
                });

                snackbar.show();
            }
        });
    }
}
