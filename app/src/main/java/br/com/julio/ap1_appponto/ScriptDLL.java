package br.com.julio.ap1_appponto;

import android.util.Log;

public class ScriptDLL {
    public static String getCreateTableClient() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE frequencia (");
        sql.append("        ID          INTEGER    PRIMARY KEY");
        sql.append("        NOT NULL,");
        sql.append("        dataHora TEXT (75)");
        sql.append("        NOT NULL,");
        sql.append("        local     TEXT (75)");
        sql.append("        NOT NULL,");
        sql.append("        matricula     TEXT (15)");
        sql.append("        NOT NULL");
        sql.append(");");

        return sql.toString();
    }

    public static String getFrequencias() {
        StringBuilder sql = new StringBuilder();
        sql.append("Select *");
        sql.append(" from frequencia");
        return sql.toString();
    }
}
