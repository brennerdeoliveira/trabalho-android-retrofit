package br.eti.urbano.mobile.androidretrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.eti.urbano.mobile.androidretrofit2.R;
import br.eti.urbano.mobile.androidretrofit2.model.Posts;

public class PostsAdapter extends BaseAdapter {


        Context context;
        List<Posts> colecao;
        LayoutInflater inflter;

        public PostsAdapter(final Context applicationContext,
                             final List<Posts> colecao) {
            this.context = applicationContext;
            this.colecao = colecao;

        }

        @Override
        public int getCount() {
            return this.colecao != null ? this.colecao.size() : 0;
        }

        @Override
        public Object getItem(int i) {
            return this.colecao.get(i);
        }

        private Posts parsetItem(int i){
            return this.colecao.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            // inflate the layout for each list row
            //'Infla' o layout(pega a referencia) para ser trabalhada
            //no método
            if (view == null) {
                view = LayoutInflater.from(context).
                        inflate(R.layout.item_posts,
                                viewGroup, false);
            }

            // pega o objeto corrente da lista
            Posts posts = parsetItem(i);

            //Neste ponto vc ira popular os dados do seu layout,
            //utilizando JAVA.

            TextView textViewUserId, textViewId, textViewTitle, textViewBody;

            //CASO não queria declarar um campo
            //((TextView)view.findViewById(R.id.txtItemNome)).setText(pessoa.getNome());

            textViewUserId = view.findViewById(R.id.txtUserId);
            textViewId = view.findViewById(R.id.txtId);
            textViewTitle = view.findViewById(R.id.txtTitle);
            textViewBody = view.findViewById(R.id.txtBody);

            textViewUserId.setText(String.valueOf(posts.getUserId()));
            textViewId.setText(String.valueOf(posts.getId()));
            textViewTitle.setText(posts.getTitle());
            textViewBody.setText(posts.getBody());

            return view;
        }
}
