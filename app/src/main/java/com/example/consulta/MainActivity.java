package com.example.consulta;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.consulta.dao.pecasDAO;
import com.example.consulta.model.pecas;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {


    EditText txtSerial;
    TextView lbResultado;
    Button btnBuscar;
    Button btnScan;
    TextView Tampa;
    TextView FCBruto;
    TextView FCFinal;
    TextView HoraFinal;
    TextView OperadorFinal;
    TextView OperadorUsinagem;
    TextView HoraUsinagem;
    TextView MaquinaUsinagem;
    TextView OperadorInjecao;
    TextView HoraInjecao;
    TextView MaquinaInjecao;
    TextView SerialUsinagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        txtSerial = findViewById(R.id.txtSerial);//referenciando variavel com campo
        lbResultado = findViewById(R.id.lbResultado);//referenciando variavel com campo
        btnBuscar = findViewById(R.id.btnBuscar);//referenciando variavel com campo
        Tampa = findViewById(R.id.lbTampa);//referenciando variavel com campo
        FCBruto = findViewById(R.id.lbFCBruto);//referenciando variavel com campo
        FCFinal = findViewById(R.id.lbFCFinal);//referenciando variavel com campo
        HoraFinal = findViewById(R.id.lbFCMontagemHora);
        OperadorFinal = findViewById(R.id.lbFCMontagemOperador);
        OperadorUsinagem = findViewById(R.id.lbFCUsinadoOperador);
        HoraUsinagem = findViewById(R.id.lbFCUsinadoHora);
        MaquinaUsinagem = findViewById(R.id.lbFCUsinadoMaquina);
        OperadorInjecao = findViewById(R.id.lbFCBrutoOperador);
        HoraInjecao = findViewById(R.id.lbFCBrutoHora);
        MaquinaInjecao = findViewById(R.id.lbFCBrutoMaquina);
        SerialUsinagem = findViewById(R.id.lbFCUsinado);


        btnScan = findViewById(R.id.btnScan);

        btnScan.setOnClickListener(v ->
                {
                    scanCode();
                }
        );
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume cima para Flash ON");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaucher.launch(options);


    }

    public void buscar(View v) {
        String serial = txtSerial.getText().toString();


        //if(serial !="") {

        pecas pec = new pecasDAO().consulta(serial);
        if (pec != null) {

            lbResultado.setText("Peça Encontrado");
            limpar();
            //9999999999004635099502222L00176001737428461
            //9999999999004635099503091L00773001737420310 reprovada teste

            Tampa.setText(pec.getMainDMCHous());
            FCBruto.setText(pec.getMainDMCCover());
            FCFinal.setText(pec.getMainFinalDMC());
            lbResultado.setText(pec.getAprovado());
            HoraFinal.setText(pec.getHoraFinal());
            OperadorFinal.setText(pec.getOperadorFinal());
            SerialUsinagem.setText(pec.getSerialUsinagem());
            OperadorUsinagem.setText(pec.getOperadorUsinagem());
            HoraUsinagem.setText(pec.getHoraUsinagem());
            MaquinaUsinagem.setText(pec.getMaquinaUsinagem());
            OperadorInjecao.setText(pec.getOperadorInjecao());
            HoraInjecao.setText(pec.getHoraInjecao());
            MaquinaInjecao.setText(pec.getMaquinaInjecao());


        } else {
            lbResultado.setText("Serial Não Encontrado");
            limpar();

        }
    }

    //}
    public void limpar() {
        txtSerial.setText("");
        Tampa.setText("");
        FCBruto.setText("");
        FCFinal.setText("");
        txtSerial.requestFocus();
        Tampa.requestFocus();
        FCBruto.requestFocus();
        FCFinal.requestFocus();
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result ->
    {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            txtSerial.setText(result.getContents());

            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

}