package br.edu.ifnmg.tads.provafinalii;

import br.edu.ifnmg.tads.provafinalii.DataAccess.PedidoDAO;
import br.edu.ifnmg.tads.provafinalii.DomainModel.Pedido;
import br.edu.tads.ifnmg.provafinalii.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovoPedido extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_pedido);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.novo_pedido, menu);
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
	
	public void cadastrar(View view){
		
		EditText editnomeloja = (EditText) findViewById(R.id.edtNomeLoja);
		EditText editnomeproduto = (EditText) findViewById(R.id.edtNomeProduto);
		EditText editquantidade = (EditText) findViewById(R.id.edtQuantidade);
		
		String nomeloja = editnomeloja.getText().toString().trim();
		String nomeproduto = editnomeproduto.getText().toString().trim();
		String quantidade = editquantidade.getText().toString().trim();
		
		if(quantidade.length() > 7){
			Toast toast = Toast.makeText(this, "Quantidade deve possuir tamanho máximo de 7 caracteres!", Toast.LENGTH_LONG);
			toast.show();
		} else if(quantidade.length() == 0 || nomeloja.length() == 0 || nomeproduto.length() == 0){
			Toast toast = Toast.makeText(this, "Todos os campos devem ser preenchidos!", Toast.LENGTH_LONG);
			toast.show();
		} else {
			
			Pedido pedido = new Pedido();
			PedidoDAO pedidodao = new PedidoDAO(NovoPedido.this);
			pedido.setNomeloja(nomeloja);
			pedido.setNomeproduto(nomeproduto);
			pedido.setQuantidade(Integer.parseInt(quantidade));
			
			pedidodao.inserir(pedido);
			
			Toast toast = Toast.makeText(this, "Pedido cadastrado com sucesso!", Toast.LENGTH_LONG);
			toast.show();
			
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	public void voltar(View view){
		
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();
	
	}
}
