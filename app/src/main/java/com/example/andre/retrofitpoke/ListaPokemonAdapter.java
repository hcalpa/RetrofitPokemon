package com.example.andre.retrofitpoke;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import com.example.andre.retrofitpoke.models.Pokemon;
import com.example.andre.retrofitpoke.pokeapi.PokeapiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andre on 20/05/2017.
 */

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;
    private Context context;
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";

    public ListaPokemonAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);

    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());

        //USAR GLIDE PARA DESCARGAR LA IMAGEN POR ITEM EN EL ADAPTADOR DEL RECYCLER VIEW
        Glide.with(context).load("http://pokeapi.co/media/sprites/pokemon/"+ p.getNumber() + ".png")
                .centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.fotoImageView);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public int getItemCount(){
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(View itemView){
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);

            fotoImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    obtenerDatosPokemon(getPosition());
                }
            });

        }

    }

    public void onAlertDialog(Pokemon pokemon)
    {
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Información del Pokemon");
        alertDialog.setMessage("Nombre: "+pokemon.getName()+
                "\n"+"Código: "+pokemon.getId()+
                "\n"+"Altura: "+pokemon.getHeight() +" m" +
                "\n"+"Peso: " + pokemon.getWeight()+ " kg" +
                "\n"+"Habilidad: " + pokemon.getAbilities().get(0).getAbility().getName()+
                "\n"+"Habilidad 2: " + pokemon.getAbilities().get(1).getAbility().getName());
        alertDialog.show();
    }

    private void obtenerDatosPokemon(int position) {

         int pos = position+1;
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokemon> pokemonRespuestaCall = service.obtenerDatosPokemon(pos);

        pokemonRespuestaCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()){
                    Pokemon pokemon = response.body();
                    onAlertDialog(pokemon);

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }



}
