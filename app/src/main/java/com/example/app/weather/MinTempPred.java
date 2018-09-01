package com.example.app.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MinTempPred extends AppCompatActivity implements callback {
    static RelativeLayout rel;
    static ProgressBar pb;
    static Spinner s;
    static Spinner s2;
    static String str;
    static TextView txt;
    static double jana, janb, feba, febb, mara, marb, apra, aprb, maya, mayb, juna, junb, jula,
            anna, annb,
            julb, auga, augb, sepa, sepb, octa, octb, nova, novb, deca, decb, janfeba, janfebb, marmaya, marmayb, junsepa, junsepb, octdeca, octdecb;
    ArrayList<String[]> jan = new ArrayList<>();
    ArrayList<String[]> feb = new ArrayList<>();
    ArrayList<String[]> mar = new ArrayList<>();
    ArrayList<String[]> apr = new ArrayList<>();
    ArrayList<String[]> may = new ArrayList<>();
    ArrayList<String[]> jun = new ArrayList<>();
    ArrayList<String[]> jul = new ArrayList<>();
    ArrayList<String[]> aug = new ArrayList<>();
    ArrayList<String[]> sep = new ArrayList<>();
    ArrayList<String[]> oct = new ArrayList<>();
    ArrayList<String[]> nov = new ArrayList<>();
    ArrayList<String[]> dec = new ArrayList<>();
    ArrayList<String[]> annual = new ArrayList<>();
    ArrayList<String[]> jan_feb = new ArrayList<>();
    ArrayList<String[]> mar_may = new ArrayList<>();
    ArrayList<String[]> jun_sep = new ArrayList<>();
    ArrayList<String[]> oct_dec = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictor);
        jan = new ArrayList<>();
        feb = new ArrayList<>();
        mar = new ArrayList<>();
        apr = new ArrayList<>();
        may = new ArrayList<>();
        jun = new ArrayList<>();
        jul = new ArrayList<>();
        aug = new ArrayList<>();
        sep = new ArrayList<>();
        oct = new ArrayList<>();
        nov = new ArrayList<>();
        dec = new ArrayList<>();
        annual = new ArrayList<>();
        jan_feb = new ArrayList<>();
        mar_may = new ArrayList<>();
        jun_sep = new ArrayList<>();
        oct_dec = new ArrayList<>();
        str = " Celcius";
        rel = findViewById(R.id.rel);
        pb = findViewById(R.id.pb);
        rel.setVisibility(View.INVISIBLE);
        TextView tv = findViewById(R.id.label);
        tv.setText("Min Temp Predictor");
        txt = findViewById(R.id.label3);
        library library = new library();
        asynservice asynservice = new asynservice(library.Mintempurl, this);
        asynservice.execute();
        String[] arraySpinner = new String[]{
                "Jannuary",
                "Feburary",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December",
                "Annual",
                "Jan-Feb",
                "Mar-May",
                "Jun-Sep",
                "Oct-Dec"

        };
        String[] arraySpinner2 = new String[]{
                "2018",
                "2019",
                "2020",
                "2021",
                "2022",
                "2023",
                "2024",
                "2025",
                "2026",
                "2027",
                "2028",
                "2029",
                "2030"
        };
        s = findViewById(R.id.spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arraySpinner);
        s.setAdapter(adapter);

        s2 = findViewById(R.id.spin2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arraySpinner2);
        s2.setAdapter(adapter2);
        Button button = findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (s.getSelectedItemPosition()) {
                    case 0: {
                        Double val = jana + Double.parseDouble(s2.getSelectedItem().toString()) * janb;
                        txt.setText(val + str);
                        break;
                    }
                    case 1: {
                        Double val = feba + Double.parseDouble(s2.getSelectedItem().toString()) * febb;
                        txt.setText(val + str);
                        break;
                    }
                    case 2: {
                        Double val = mara + Double.parseDouble(s2.getSelectedItem().toString()) * marb;
                        txt.setText(val + str);
                        break;
                    }
                    case 3: {
                        Double val = apra + Double.parseDouble(s2.getSelectedItem().toString()) * aprb;
                        txt.setText(val + str);
                        break;
                    }
                    case 4: {
                        Double val = maya + Double.parseDouble(s2.getSelectedItem().toString()) * mayb;
                        txt.setText(val + str);
                        break;
                    }
                    case 5: {
                        Double val = juna + Double.parseDouble(s2.getSelectedItem().toString()) * junb;
                        txt.setText(val + str);
                        break;
                    }
                    case 6: {
                        Double val = jula + Double.parseDouble(s2.getSelectedItem().toString()) * julb;
                        txt.setText(val + str);
                        break;
                    }
                    case 7: {
                        Double val = auga + Double.parseDouble(s2.getSelectedItem().toString()) * augb;
                        txt.setText(val + str);
                        break;
                    }
                    case 8: {
                        Double val = sepa + Double.parseDouble(s2.getSelectedItem().toString()) * sepb;
                        txt.setText(val + str);
                        break;
                    }
                    case 9: {
                        Double val = octa + Double.parseDouble(s2.getSelectedItem().toString()) * octb;
                        txt.setText(val + str);
                        break;
                    }
                    case 10: {
                        Double val = nova + Double.parseDouble(s2.getSelectedItem().toString()) * novb;
                        txt.setText(val + str);
                        break;
                    }
                    case 11: {
                        Double val = deca + Double.parseDouble(s2.getSelectedItem().toString()) * decb;
                        txt.setText(val + str);
                        break;
                    }
                    case 12: {
                        Double val = anna + Double.parseDouble(s2.getSelectedItem().toString()) * annb;
                        txt.setText(val + str);
                        break;
                    }
                    case 13: {
                        Double val = janfeba + Double.parseDouble(s2.getSelectedItem().toString()) * janfebb;
                        txt.setText(val + str);
                        break;
                    }
                    case 14: {
                        Double val = marmaya + Double.parseDouble(s2.getSelectedItem().toString()) * marmayb;
                        txt.setText(val + str);
                        break;
                    }
                    case 15: {
                        Double val = junsepa + Double.parseDouble(s2.getSelectedItem().toString()) * junsepb;
                        txt.setText(val + str);
                        break;
                    }
                    case 16: {
                        Double val = octdeca + Double.parseDouble(s2.getSelectedItem().toString()) * octdecb;
                        txt.setText(val + str);
                        break;
                    }
                    default: {
                        txt.setText("");
                        break;
                    }
                }
            }
        });
    }

    @Override
    public String onresponse(String response) throws JSONException {
        String[] val;
        pb.setVisibility(View.INVISIBLE);
        rel.setVisibility(View.VISIBLE);
        JSONObject jsonObject = new JSONObject(response);
        for (int i = 0; i < jsonObject.getJSONArray("records").length() - 4; i++) {
//            Log.d("Band",jsonObject.getJSONArray("records").get(i).toString());
//            Log.d("Band",jsonObject.getJSONArray("records").getJSONObject(i).get("jan").toString());
//            Log.d("Band",jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString());

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("jan").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            jan.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("feb").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            feb.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("mar").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            mar.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("apr").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            apr.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("may").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            may.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("jun").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            jun.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("jul").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            jul.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("aug").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            aug.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("sep").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            sep.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("oct").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            oct.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("nov").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            nov.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("dec").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            dec.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("annual").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            annual.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("jan_feb").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            jan_feb.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("mar_may").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            mar_may.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("jun_sep").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            jun_sep.add(val);

            val = new String[2];
            val[0] = jsonObject.getJSONArray("records").getJSONObject(i).get("oct_dec").toString();
            val[1] = jsonObject.getJSONArray("records").getJSONObject(i).get("year").toString();
            oct_dec.add(val);
        }
        jana = conva(jan);
        janb = convb(jan);
        feba = conva(feb);
        febb = convb(feb);
        mara = conva(mar);
        marb = convb(mar);
        apra = conva(apr);
        aprb = convb(apr);
        maya = conva(may);
        mayb = convb(may);
        juna = conva(jun);
        junb = convb(jun);
        jula = conva(jul);
        julb = convb(jul);
        auga = conva(aug);
        augb = convb(aug);
        sepa = conva(sep);
        sepb = convb(sep);
        octa = conva(oct);
        octb = convb(oct);
        nova = conva(nov);
        novb = convb(nov);
        deca = conva(dec);
        decb = convb(dec);
        anna = conva(annual);
        annb = convb(annual);
        janfeba = conva(jan_feb);
        janfebb = convb(jan_feb);
        marmaya = conva(mar_may);
        marmayb = convb(mar_may);
        junsepa = conva(jun_sep);
        junsepb = convb(jun_sep);
        octdeca = conva(oct_dec);
        octdecb = convb(oct_dec);
        return null;
    }

    private double conva(ArrayList<String[]> jan) {
        double sumx = 0, sumy = 0, sumxsq = 0, sumysq = 0, sumxy = 0, result = 0;
        for (String[] s : jan) {
            sumx = sumx + Double.parseDouble(s[1]);
            sumy = sumy + Double.parseDouble(s[0]);
            sumxsq = sumxsq + Double.parseDouble(s[1]) * Double.parseDouble(s[1]);
            sumysq = sumysq + Double.parseDouble(s[0]) * Double.parseDouble(s[0]);
            sumxy = sumxy + Double.parseDouble(s[0]) * Double.parseDouble(s[1]);
        }

        result = (sumy * sumxsq - sumx * sumxy) / ((jan.size() * sumxsq) - sumx * sumx);
        return result;
    }

    private double convb(ArrayList<String[]> jan) {
        double sumx = 0, sumy = 0, sumxsq = 0, sumysq = 0, sumxy = 0, result = 0;
        for (String[] s : jan) {
            sumx = sumx + Double.parseDouble(s[1]);
            sumy = sumy + Double.parseDouble(s[0]);
            sumxsq = sumxsq + Double.parseDouble(s[1]) * Double.parseDouble(s[1]);
            sumysq = sumysq + Double.parseDouble(s[0]) * Double.parseDouble(s[0]);
            sumxy = sumxy + Double.parseDouble(s[0]) * Double.parseDouble(s[1]);
        }

        result = (jan.size() * sumxy - sumx * sumy) / ((jan.size() * sumxsq) - sumx * sumx);
        return result;
    }
}
