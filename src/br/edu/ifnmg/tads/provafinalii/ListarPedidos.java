package br.edu.ifnmg.tads.provafinalii;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifnmg.tads.provafinalii.DataAccess.PedidoDAO;
import br.edu.ifnmg.tads.provafinalii.DomainModel.Pedido;
import br.edu.tads.ifnmg.provafinalii.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListarPedidos extends Activity {
	
	ListView lista;
	ArrayAdapter<String> adapter;
	int adapterlayout = android.R.layout.simple_list_item_1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_pedidos);
		
		PedidoDAO pedidodao = new PedidoDAO(ListarPedidos.this);
		 
		lista = (ListView) findViewById(R.id.listaPedidos);
		
		List<Pedido> pedidos = pedidodao.listarpedidos();
		
		ArrayList<String> listapedidos = new ArrayList<String>();
		
		for(Pedido p : pedidos){
			
			listapedidos.add(p.toString());
			
		}
		
		adapter = new ArrayAdapter<String>(this, adapterlayout, listapedidos);
		lista.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listar_pedidos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void voltar (View view){
		
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();
	
	}
}
