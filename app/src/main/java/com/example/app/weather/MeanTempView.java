package com.example.app.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MeanTempView extends AppCompatActivity implements callback {
    static ProgressBar pb;
    LineChart jan, feb, march, april, may, june, july, august, september, october, november, december, annual, jan_feb, mar_may, jun_sep, oct_dec;
    ArrayList<Entry> janent, febent, marchent, aprilent, mayent, juneent, julyent, augustent, sepent, octent, novent, decent, annualent, jan_febent, mar_mayent, jun_sepent, oct_decent;
    ArrayList<String> janlab, feblab, marchlab, aprillab, maylab, junelab, julylab, augustlab, seplab, octlab, novlab, declab, annuallab, jan_feblab, mar_maylab, jun_seplab, oct_declab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainfall_view);
        library library = new library();
        TextView tv = findViewById(R.id.tview);
        pb = findViewById(R.id.progressbar);
        tv.setText("Mean Temp Data");
        asynservice asynservice = new asynservice(library.Meantempurl, this);
        asynservice.execute();
        janlab = new ArrayList<>();
        janent = new ArrayList<>();
        jan = findViewById(R.id.jan);

        feblab = new ArrayList<>();
        febent = new ArrayList<>();
        feb = findViewById(R.id.feb);

        marchlab = new ArrayList<>();
        marchent = new ArrayList<>();
        march = findViewById(R.id.march);

        aprillab = new ArrayList<>();
        aprilent = new ArrayList<>();
        april = findViewById(R.id.april);

        maylab = new ArrayList<>();
        mayent = new ArrayList<>();
        may = findViewById(R.id.may);

        junelab = new ArrayList<>();
        juneent = new ArrayList<>();
        june = findViewById(R.id.june);

        julylab = new ArrayList<>();
        julyent = new ArrayList<>();
        july = findViewById(R.id.july);

        augustlab = new ArrayList<>();
        augustent = new ArrayList<>();
        august = findViewById(R.id.august);

        seplab = new ArrayList<>();
        sepent = new ArrayList<>();
        september = findViewById(R.id.september);

        octlab = new ArrayList<>();
        octent = new ArrayList<>();
        october = findViewById(R.id.october);

        novlab = new ArrayList<>();
        novent = new ArrayList<>();
        november = findViewById(R.id.november);

        declab = new ArrayList<>();
        decent = new ArrayList<>();
        december = findViewById(R.id.december);

        annuallab = new ArrayList<>();
        annualent = new ArrayList<>();
        annual = findViewById(R.id.annual);

        jan_feblab = new ArrayList<>();
        jan_febent = new ArrayList<>();
        jan_feb = findViewById(R.id.jan_feb);

        mar_maylab = new ArrayList<>();
        mar_mayent = new ArrayList<>();
        mar_may = findViewById(R.id.mar_may);

        jun_seplab = new ArrayList<>();
        jun_sepent = new ArrayList<>();
        jun_sep = findViewById(R.id.jun_sep);

        oct_declab = new ArrayList<>();
        oct_decent = new ArrayList<>();
        oct_dec = findViewById(R.id.oct_dec);

    }

    @Override
    public String onresponse(String response) throws JSONException {
        pb.setVisibility(View.INVISIBLE);
        jan.invalidate();
        feb.invalidate();
        march.invalidate();
        april.invalidate();
        may.invalidate();
        june.invalidate();
        july.invalidate();
        august.invalidate();
        september.invalidate();
        october.invalidate();
        november.invalidate();
        december.invalidate();
        annual.invalidate();
        jan_feb.invalidate();
        mar_may.invalidate();
        jun_sep.invalidate();
        oct_dec.invalidate();
        JSONObject jsonObject = new JSONObject(response);
        for (int i = 0; i < jsonObject.getJSONArray("records").length(); i++) {
            janent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("jan").toString()), i));
            janlab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            febent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("feb").toString()), i));
            feblab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            marchent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("mar").toString()), i));
            marchlab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            aprilent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("apr").toString()), i));
            aprillab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            mayent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("may").toString()), i));
            maylab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            juneent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("jun").toString()), i));
            junelab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            julyent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("jul").toString()), i));
            julylab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            augustent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("aug").toString()), i));
            augustlab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            sepent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("sep").toString()), i));
            seplab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            octent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("oct").toString()), i));
            octlab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            novent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("nov").toString()), i));
            novlab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            decent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("dec").toString()), i));
            declab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            annualent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("annual").toString()), i));
            annuallab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            jan_febent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("jan_feb").toString()), i));
            jan_feblab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            mar_mayent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("mar_may").toString()), i));
            mar_maylab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            jun_sepent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("jun_sep").toString()), i));
            jun_seplab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            oct_decent.add(new BarEntry(Float.parseFloat(jsonObject.getJSONArray("records").getJSONObject(i).get("oct_dec_").toString()), i));
            oct_declab.add(jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

        }
        LineDataSet janset = new LineDataSet(janent, "Jannuary");
        janset.setDrawCubic(true);
        LineData jandata = new LineData(janlab, janset);
        jan.setData(jandata);

        LineDataSet febset = new LineDataSet(febent, "February");
        febset.setDrawCubic(true);
        LineData febdata = new LineData(feblab, febset);
        feb.setData(febdata);

        LineDataSet marchset = new LineDataSet(marchent, "March");
        marchset.setDrawCubic(true);
        LineData marchdata = new LineData(marchlab, marchset);
        march.setData(marchdata);

        LineDataSet aprilset = new LineDataSet(marchent, "April");
        aprilset.setDrawCubic(true);
        LineData aprildata = new LineData(aprillab, aprilset);
        april.setData(aprildata);

        LineDataSet mayset = new LineDataSet(marchent, "May");
        mayset.setDrawCubic(true);
        LineData maydata = new LineData(maylab, mayset);
        may.setData(maydata);

        LineDataSet juneset = new LineDataSet(juneent, "June");
        juneset.setDrawCubic(true);
        LineData junedata = new LineData(junelab, juneset);
        june.setData(junedata);

        LineDataSet julyset = new LineDataSet(julyent, "July");
        aprilset.setDrawCubic(true);
        LineData julydata = new LineData(julylab, julyset);
        july.setData(julydata);

        LineDataSet augset = new LineDataSet(augustent, "August");
        augset.setDrawCubic(true);
        LineData augdata = new LineData(augustlab, augset);
        august.setData(augdata);

        LineDataSet septemberset = new LineDataSet(sepent, "September");
        septemberset.setDrawCubic(true);
        LineData sepdata = new LineData(seplab, septemberset);
        september.setData(sepdata);

        LineDataSet octoberset = new LineDataSet(octent, "October");
        octoberset.setDrawCubic(true);
        LineData octoberdata = new LineData(octlab, octoberset);
        october.setData(octoberdata);

        LineDataSet novset = new LineDataSet(novent, "November");
        novset.setDrawCubic(true);
        LineData novdata = new LineData(novlab, novset);
        november.setData(novdata);

        LineDataSet decset = new LineDataSet(decent, "December");
        decset.setDrawCubic(true);
        LineData decemberdata = new LineData(declab, decset);
        december.setData(decemberdata);

        LineDataSet annualset = new LineDataSet(annualent, "Annual");
        annualset.setDrawCubic(true);
        LineData annualdata = new LineData(annuallab, annualset);
        annual.setData(annualdata);

        LineDataSet jan_febset = new LineDataSet(jan_febent, "Jan To Feb");
        jan_febset.setDrawCubic(true);
        LineData jan_febdata = new LineData(jan_feblab, jan_febset);
        jan_feb.setData(jan_febdata);

        LineDataSet mar_mayset = new LineDataSet(mar_mayent, "March to May");
        mar_mayset.setDrawCubic(true);
        LineData march_maydata = new LineData(mar_maylab, mar_mayset);
        mar_may.setData(march_maydata);

        LineDataSet june_sepset = new LineDataSet(jun_sepent, "June to Sep");
        june_sepset.setDrawCubic(true);
        LineData jun_sepdata = new LineData(jun_seplab, june_sepset);
        jun_sep.setData(jun_sepdata);

        LineDataSet oct_decset = new LineDataSet(oct_decent, "Oct to Dec");
        oct_decset.setDrawCubic(true);
        LineData oct_decdata = new LineData(oct_declab, oct_decset);
        oct_dec.setData(oct_decdata);


        return null;
    }
}