package br.com.julio.ap1_appponto;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static br.com.julio.ap1_appponto.ListViewDados.teste;

public class FrequenciaDAO {

    SQLiteDatabase conexao;

    public FrequenciaDAO(SQLiteDatabase conexao) {
        this.conexao = conexao;

    }

    public void insert(Frequencia frequencia){

        ContentValues contentValues = new ContentValues();
//        contentValues.put("Id", frequencia.getId());
        contentValues.put("Matricula", frequencia.getMatricula());
        contentValues.put("Local", "Latitude: " + frequencia.getLatitude() + " Longitude: " + frequencia.getLongitude());
        contentValues.put("dataHora", frequencia.getTimeStamp());
        conexao.insertOrThrow("frequencia",null, contentValues);

    }
    public void remove(int id){

        String[] params = new String[1];
        params[0] = String.valueOf(id);

        conexao.delete("frequencia","ID = ?", params);
    }
    public void alter(Frequencia frequencia){
        //Apenas implementado para efeitos didáticos, já que na aplicação não será utilizado
        ContentValues contentValues = new ContentValues();
        contentValues.put("Matricula", frequencia.getMatricula());
        contentValues.put("Local", "Latitude: " + frequencia.getLatitude() + "Longitude: " + frequencia.getLongitude());
        contentValues.put("dataHora", frequencia.getTimeStamp());
        String[] params = new String[1];
        params[0] = String.valueOf(frequencia.getId());
        conexao.update("frequencia",contentValues,"ID = ?", params);

    }
    public List<Frequencia> listFrequencias(){

        List<Frequencia> frequencias = new ArrayList<Frequencia>();
        Cursor result = conexao.rawQuery(ScriptDLL.getFrequencias(),null);
        if(result.getCount()>0){
            result.moveToFirst();
            do{
                Frequencia frequencia = new Frequencia();
                frequencia.setMatricula(result.getString(result.getColumnIndexOrThrow("Matricula")));
                frequencia.setLatitude(result.getString(result.getColumnIndexOrThrow("Local")));
                frequencia.setTimeStamp(result.getString(result.getColumnIndexOrThrow("dataHora")));
                frequencias.add(frequencia);
            }
            while(result.moveToNext());
            }
        return frequencias;

    }
}
