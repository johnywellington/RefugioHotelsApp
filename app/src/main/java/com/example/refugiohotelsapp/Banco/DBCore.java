package com.example.refugiohotelsapp.Banco;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DBCore extends SQLiteOpenHelper {
    private static final String NomeBanco= "RefugioHotelsDatabase";
    private static final int VersaoBanco = 1;

    public DBCore(Context ctx){
        super(ctx, NomeBanco, null, VersaoBanco);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table Usuario" +
                "(idUsuario Long primary key autoincrement, nome text not null, email text not null," +
                " senha text not null)");
        bd.execSQL("create table Reserva"+
                "(idReserva intenger primary key autoincrement," +
                "dataInicio date not null, dataFim date not null, quantidadeAdultos int not null, quantidadeCriancas int not null,"+
                "valorReserva float not null, metodoPagamento varchar not null, reservaAtiva boolean not null,"+
                "idUsuario intenger not null,FOREIGN KEY (\"+idUsuario+\") REFERENCES \"+usuario+\"(\"+idUsuario+\"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table Usuario;");
        bd.execSQL("drop table Reserva;");
        onCreate(bd);

    }

}
