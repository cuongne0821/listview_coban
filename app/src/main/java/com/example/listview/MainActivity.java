package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonan;
    ArrayList<String> arraylist;
    EditText edt_nhap;
    Button btn_them, btn_capnhat;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arraylist=new ArrayList<>();
        arraylist.add("Cá chiên");
        arraylist.add("Canh chua");
        arraylist.add("Trứng chiên");
        arraylist.add("Cơm chiên");
        arraylist.add("Thịt luộc");
        arraylist.add("Rau xào");
        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                arraylist);
        lvMonan.setAdapter(adapter);

        // sự kiện click trong listview
        lvMonan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // biến i trả về vị trí trên listview bắt đầu =0
                Toast.makeText(MainActivity.this, arraylist.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        // su kien them su xoa

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monan=edt_nhap.getText().toString();
                arraylist.add(monan);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_nhap.setText(arraylist.get(i));
                vitri=i;
            }
        });
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arraylist.set(vitri,edt_nhap.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
    public  void  anhxa(){
        lvMonan=(ListView) findViewById(R.id.listview_monan);
        edt_nhap=(EditText) findViewById(R.id.editText);
        btn_them=(Button) findViewById(R.id.btn_them);
        btn_capnhat=(Button) findViewById(R.id.btn_capnhat);
    }
}