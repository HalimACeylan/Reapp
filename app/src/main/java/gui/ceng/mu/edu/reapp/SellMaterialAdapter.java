package gui.ceng.mu.edu.reapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class SellMaterialAdapter extends RecyclerView.Adapter<SellMaterialAdapter.ViewHolder> implements Serializable {
    List<Material>materials;

    public SellMaterialAdapter(List<Material>materials) {
        this.materials = materials;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.material_card_sell,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Material currentMaterial = materials.get(position);
    holder.title.setText(currentMaterial.getName());
    holder.image.setImageBitmap(currentMaterial.getImageInBitmap());
    holder.counter.setText(Integer.toString(currentMaterial.getCount()));
    holder.btnInc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            currentMaterial.setCount(currentMaterial.getCount()+1);
            notifyItemChanged(holder.getLayoutPosition());
        }
    });
        holder.btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentMaterial.setCount(currentMaterial.getCount()-1);
                notifyItemChanged(holder.getLayoutPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return materials.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements Serializable {
        TextView title;
        ImageView image;
        Button btnInc;
        Button btnDec;
        TextView counter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            image = itemView.findViewById(R.id.imgIcon);
            btnInc = itemView.findViewById(R.id.btnInc);
            btnDec = itemView.findViewById(R.id.btnBut);
            counter = itemView.findViewById(R.id.counter);

        }
    }

    @Override
    public String toString() {
        return "MaterialAdapter{" +
                "materials=" + materials.toString() +
                '}';
    }
}

