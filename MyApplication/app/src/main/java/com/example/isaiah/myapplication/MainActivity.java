package com.example.isaiah.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Intent;
import android.app.Activity;
import 	android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;


public class MainActivity extends AppCompatActivity {

    TextView petalNumber;
    TextView radiusLength;
    EditText petals;
    EditText radii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
          //  }
       // });


        radii = (EditText) findViewById(R.id.editRadius);

        petals = (EditText) findViewById(R.id.editPetals);

        radiusLength = (TextView) findViewById(R.id.radius);

        petalNumber = (TextView) findViewById(R.id.petals);

        Button graphBtn = (Button) findViewById(R.id.Graph);
        graphBtn.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View view) {

                double radius1;
                double petal1;
                double MAX = 1000;
                double SCALE = 0.5;
                //double DELTA_X = 200;
                //double DELTA_Y = DELTA_X;
                //Color ROSE_COLOR = Color.green;
                // Stroke ROSE_STROKE = new BasicStroke(8f);
                // Path2D path = new Path2D.Double();
                try {


                    radius1 = Double.parseDouble(radii.getText().toString());
                    petal1 = Double.parseDouble(petals.getText().toString());

                }
                catch (NumberFormatException ex ) {
                    Toast.makeText(getApplicationContext(), "Please Enter a Radius/Petal Number!", Toast.LENGTH_SHORT).show();
                    return;

                }

                // Scanner rInput = new Scanner(System.in);
                if (radii == null) {


                }
                else if (petals == null) {

                }
                else
                {


                    GraphView graph = (GraphView) findViewById(R.id.mainGraph);

                    graph.removeAllSeries();

                    for (double i = 0; i < MAX; i++) {
                        // double rInput = Scanner.nextDouble();

                        double placeholder = 2;
                        double theta = i * 2 * Math.PI / MAX;
                        if (petal1 % placeholder == 0) {
                            double r = radius1 * Math.cos((petal1) * theta);
                            double dX = r * Math.cos(theta);
                            double dY = r * Math.sin(theta);

                            // set manual X bounds
                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setMinX(-radius1);
                            graph.getViewport().setMaxX(radius1);

                            // set manual Y bounds
                            graph.getViewport().setYAxisBoundsManual(true);
                            graph.getViewport().setMinY(-radius1);
                            graph.getViewport().setMaxY(radius1);


                            PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[]{
                                    new DataPoint(dX, dY)});

                            graph.addSeries(series);
                            series.setColor(Color.RED);
                            series.setShape(PointsGraphSeries.Shape.RECTANGLE);


                        } else {
                            double r = radius1 * Math.cos(petal1 * theta);
                            double dX = r * Math.cos(theta);
                            double dY = r * Math.sin(theta);


                            // set manual X bounds
                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setMinX(-radius1);
                            graph.getViewport().setMaxX(radius1);

                            // set manual Y bounds
                            graph.getViewport().setYAxisBoundsManual(true);
                            graph.getViewport().setMinY(-radius1);
                            graph.getViewport().setMaxY(radius1);


                            PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[]{
                                    new DataPoint(dX, dY)});
                            graph.addSeries(series);
                            series.setColor(Color.RED);
                            series.setShape(PointsGraphSeries.Shape.RECTANGLE);


                        }

                    }

                    // path.closePath();


                }

            }
            });


                                    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
