package oh.hell.cmt;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ContentMain extends AppCompatActivity {
    AlertDialog dialog;
    AlertDialog.Builder builder;
    String [] items={"easy","noob","normal","hard","insane"};
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.contant_main);

        Button btn = findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ContentMain.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        Button btndiff = findViewById(R.id.difficulty);
        btndiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    builder = new AlertDialog.Builder(ContentMain.this);


                    builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            result = items[i];
                        }
                    });

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    dialog = builder.create();

                    dialog.show();
                } catch (Exception e) {
                }
            }
        });
        Button btnhs=findViewById(R.id.highscores);
        btnhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent=new Intent(ContentMain.this,HighScores.class);
                    startActivity(intent);
                    finish();}catch (Exception e){}

            }
        });
    }

}
