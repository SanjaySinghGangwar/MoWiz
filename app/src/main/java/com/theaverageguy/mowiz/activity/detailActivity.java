package com.theaverageguy.mowiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.squareup.picasso.Picasso;
import com.theaverageguy.mowiz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.theaverageguy.mowiz.database.dataBaseRefs.baseURL;

public class detailActivity extends AppCompatActivity implements View.OnClickListener {
    String url, portrait, name, landscape, description;
    Bundle extras;
    @BindView(R.id.name)
    TextView nameTv;
    @BindView(R.id.description)
    TextView descriptionTV;
    @BindView(R.id.playBT)
    CardView playBT;
    @BindView(R.id.landscape)
    ImageView landscapeIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        extras = getIntent().getExtras();
        initALL();
        initElements();

    }

    private void initElements() {
        playBT.setOnClickListener(this);
    }

    private void initALL() {
        if (extras != null) {
            url = extras.getString("url");
            portrait = extras.getString("portrait");
            name = extras.getString("name");
            landscape = extras.getString("landscape");
            description = extras.getString("description");

            nameTv.setText(name);
            descriptionTV.setText("Description : \n" + description);
            Picasso.get().load(baseURL + landscape).placeholder(R.drawable.movie).into(landscapeIV);

        } else {
            onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playBT:
                Log.d("TAG", "onClick: " + baseURL + url);
                Intent i = new Intent(this, player.class);
                i.putExtra("url", baseURL + url);
                startActivity(i);
                break;
        }
    }
}