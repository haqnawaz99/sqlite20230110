package haqnawaz.org.db038;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etName, etRollNo;
    CheckBox cbEnroll;
    Button btnSave, btnEdit, btnDelete;

    DBHandler db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.et_name);
        etRollNo = findViewById(R.id.et_roll_no);
        cbEnroll = findViewById(R.id.cb_enroll);
        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);

        db = new DBHandler(this);
        listView = findViewById(R.id.list_view);
        RefreshGrid();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String rollNo = etRollNo.getText().toString();
                boolean isEnroll = cbEnroll.isChecked();

                if (name.isEmpty() || rollNo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    return;
                }
                Student student = new Student(name, rollNo, isEnroll);
                db.insertStudent(student);
                RefreshGrid();
            }
        });



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String rollNo = etRollNo.getText().toString();
                boolean isEnroll = cbEnroll.isChecked();

                Student student = new Student(name, rollNo, isEnroll);
                db.updateStudent(student);
                RefreshGrid();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteStudent(etRollNo.getText().toString());
                Toast.makeText(MainActivity.this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etRollNo.setText("");
                RefreshGrid();
            }
        });
    }
    public void RefreshGrid(){
        List<Student> students = db.selectAllStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1,students);
        listView.setAdapter(arrayAdapter);



//        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//                TextView text = (TextView) view.findViewById(android.R.id.text1);
//                text.setText(students.get(position).toString());
//                return view;
//            }
//        };
//        listView.setAdapter(adapter);
    }
}