package com.example.manthole.delihamper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Submit extends AppCompatActivity {


    android.support.v4.app.NotificationCompat.Builder builder;
    int price = 0;
    double Total = 0;
    public static String TotalMessage = null;

    String email, subject, message, attachmentFile;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    int columnIndex;

    Profile profile = new Profile();


    DatabaseReference db;
    FirebaseAuth auth;

//    HamperA orderDetails = new HamperA();


    TextView txtPriceSubmit, txtquantitySubmit, txtTotal, txtName, txtLastName, txtClientAddress, txtContactNo,txtItemNames;
    Button btnSubmit;
    double totalCost;
    int quantityTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        txtName = (TextView) findViewById(R.id.txtClientName);
        txtLastName = (TextView) findViewById(R.id.txtLastNameClient);
        txtClientAddress = (TextView) findViewById(R.id.txtClientAddress);
        txtContactNo = (TextView) findViewById(R.id.txtContactNo);
        txtItemNames = findViewById(R.id.txtItemNames);


        txtPriceSubmit = (TextView) findViewById(R.id.txtPriceSubmit);
        txtquantitySubmit = (TextView) findViewById(R.id.txtQuantitySubmit);


        Intent in = getIntent();
        totalCost = in.getDoubleExtra("total", 0);
        quantityTotal = in.getIntExtra("quantity", 0);


        txtPriceSubmit.setText(String.valueOf(totalCost));
        txtquantitySubmit.setText(String.valueOf(quantityTotal));



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent home = new Intent(getApplicationContext(), Content.class);
//                startActivity(home);


            }
        });

        auth = FirebaseAuth.getInstance();
        String key = auth.getCurrentUser().getUid();
        db = FirebaseDatabase.getInstance().getReference().child("Register").child(auth.getCurrentUser().getUid());


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                profile = dataSnapshot.getValue(Profile.class);
                String name = profile.getName();
                txtName.setText(name);

                String surname = profile.getLastname();
                txtLastName.setText(surname);

                String address = profile.getAddress();
                txtClientAddress.setText(address);

                String contactNo = profile.getContactNumber();
                txtContactNo.setText(contactNo);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
//
//                db.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            profile = snapshot.getValue(Profile.class);
//
//                            String name = profile.getName();
//                            txtName.setText(name);
//
//                            String surname = profile.getLastname();
//                            txtLastName.setText(surname);
//
//                            String address = profile.getAddress();
//                            txtClientAddress.setText(address);
//
//                            String contactNo = profile.getContactNumber();
//                            txtContactNo.setText(contactNo);
//
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//    }
//}
////
//    private void sendEmail() {
//
//
//        try {
//
//
//            email = txtName.getText().toString();
//            subject = txtLastName.getText().toString();
//            message = txtClientAddress.getText().toString();
//
//            final Intent mailClient = new Intent(
//                    Intent.ACTION_VIEW);
//            mailClient.setType("plain/text");
//            mailClient.putExtra(android.content.Intent.EXTRA_EMAIL,
//                    new String[]{email});
//            mailClient.putExtra(android.content.Intent.EXTRA_SUBJECT,
//                    subject);
//            if (URI != null) {
//                mailClient.putExtra(Intent.EXTRA_STREAM, URI);
//            }
////            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
////            this.startActivity(Intent.createChooser(emailIntent,
////                    "Sending email..."));
////            Intent mailClient = new Intent(Intent.ACTION_VIEW);
//            mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail;l");
//            startActivity(mailClient);
//        } catch (
//                Throwable t)
//
//        {
//            Toast.makeText(this, "Request failed try again: " + t.toString(),
//                    Toast.LENGTH_LONG).show();
//        }
//
//
//    }
//
//
//    public void submit() {
//
//
//        int NOTIFICATION_ID = 1;
//        NotificationCompat.Builder builder =
//                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle("Notify Notification")
//                        .setContentText("No Geofence Detected")
//                        .setAutoCancel(true)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
//                        .setPriority(NotificationCompat.PRIORITY_HIGH);
//
//        Intent intent = new Intent(getApplicationContext(), Content.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//
//        Intent buttonIntent = new Intent(getBaseContext(), NotificationReceiver.class);
//        buttonIntent.putExtra("notificationId", NOTIFICATION_ID);
//        PendingIntent dismissIntent = PendingIntent.getBroadcast(getBaseContext(), 0, buttonIntent, 0);
//
//        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent);
//        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent);
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
//
//    }
//
//    private void buildNotification(int NOTIFICATION_ID) {
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        // Will display the notification in the notification bar
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
//    }
//
//}
