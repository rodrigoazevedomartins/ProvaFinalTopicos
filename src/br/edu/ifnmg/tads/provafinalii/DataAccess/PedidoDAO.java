package br.edu.ifnmg.tads.provafinalii.DataAccess;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifnmg.tads.provafinalii.DomainModel.Pedido;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PedidoDAO {
	
	private Context context;
	
	
	public PedidoDAO(Context context) {
		this.context = context;
	}
	
	public void inserir(Pedido pedido){
		BDUtil bdUtil = new BDUtil(this.context);
		
		ContentValues contentValues = new ContentValues();
		contentValues.put("nomeloja", pedido.getNomeloja());
		contentValues.put("nomeproduto", pedido.getNomeproduto());
		contentValues.put("quantidade", pedido.getQuantidade());
		
		bdUtil.getWritableDatabase().insert("PEDIDO", null, contentValues);
	}
	
	public List<Pedido> listarpedidos(){
		
		BDUtil bdUtil = new BDUtil(this.context);
		
		String[] colunas = {"idpedido", "nomeloja", "nomeproduto", "quantidade"};
		
		SQLiteDatabase db = bdUtil.getReadableDatabase();
		
		Cursor c = db.query("PEDIDO", colunas, null, null, null, null, "idpedido");
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		while(c.moveToNext()){
			Pedido pedido = new Pedido();
			
			pedido.setIdpedido(c.getInt(0));
			pedido.setNomeloja(c.getString(1));
			pedido.setNomeproduto(c.getString(2));
			pedido.setQuantidade(c.getInt(3));
			pedidos.add(pedido);
			
		}
		
		return pedidos;
	}
}
