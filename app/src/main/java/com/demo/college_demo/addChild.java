package com.demo.college_demo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.demo.college_demo.remote.APIService;
import com.demo.college_demo.remote.ApiUtils;
import com.demo.college_demo.remote.RetrofitClient;

import java.io.File;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static java.util.logging.Level.INFO;

public class addChild extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private static int RESULT_LOAD_IMAGE = 1;
    private ImageView imageView;
    private EditText name;
    private EditText surname;
    private Spinner spinner;
    private Button add;
    private Calendar calendar;
    private String pictPath, dateofbirth;
    private int year, month, day;
    APIService mAPIService;
    Logger logger = Logger.getLogger("child");


    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day

                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        spinner = findViewById(R.id.gender);
        imageView = findViewById(R.id.imageView);
        add = findViewById(R.id.add);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Child");
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        checkPermission(READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);

    }

    public void upload(View view) {
        try {
            mAPIService = ApiUtils.getAPIService();
            //Create a file object using file path
            File file = new File(pictPath);
            RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
            // Create MultipartBody.Part using file request-body,file name and part name
            MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);
            //Create request body with text description and text media type
            RequestBody passName = RequestBody.create(MediaType.parse("text/plain"), name.getText().toString());
            RequestBody PassSurname = RequestBody.create(MediaType.parse("text/plain"), surname.getText().toString());
            RequestBody dob = RequestBody.create(MediaType.parse("text/plain"), dateofbirth);
            RequestBody gender = RequestBody.create(MediaType.parse("text/plain"), spinner.getSelectedItem().toString());
            RequestBody userID = RequestBody.create(MediaType.parse("text/plain"), "1");
            mAPIService.uploadImage(part, passName, PassSurname, dob, gender, userID).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
//                        Toast.makeText(getApplicationContext(),
//                                response.raw(),
//                                Toast.LENGTH_LONG)
//                                .show();
                        // logger.log(Level.SEVERE,response.raw().);
                        logger.log(INFO, response.code() + "");
                        logger.log(INFO, response.raw().request().url() + "");
                        if (response.code() == 201) {
                            Toast.makeText(getApplicationContext(),
                                    "Information has been uploade fine",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }

                    } catch (Exception e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),
                            t.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();
                    logger.log(Level.SEVERE, t.getMessage());

                }
            });
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
        }


    }

    public void image(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            pictPath = picturePath;
            cursor.close();


            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {
        dateofbirth = year + "/" + month + "/" + day;
        Toast.makeText(getApplicationContext(), year + "/" + month + "/" + day,
                Toast.LENGTH_SHORT)
                .show();
    }


    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this,
                    new String[]{permission},
                    requestCode);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

}
