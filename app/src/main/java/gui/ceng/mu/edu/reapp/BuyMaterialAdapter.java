package gui.ceng.mu.edu.reapp;

import android.app.Activity;
import android.content.Intent;
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

public class BuyMaterialAdapter extends RecyclerView.Adapter<BuyMaterialAdapter.ViewHolder> implements Serializable {
    List<Material> materials;

    public BuyMaterialAdapter(List<Material> materials) {
        this.materials = materials;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.material_card_buy,parent,false);
        return new BuyMaterialAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Material currentMaterial = materials.get(position);
        holder.title.setText(currentMaterial.getName());
        holder.image.setImageBitmap(currentMaterial.getImageInBitmap());
        holder.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pass the clicked material to Product Page
                Activity currentActivity = (Activity) holder.itemView.getContext();
                Intent intent = new Intent(currentActivity,ProductPage.class);
                intent.putExtra("onChosen",currentMaterial);
                currentActivity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return materials.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        Button buyBtn;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            image = itemView.findViewById(R.id.imgIcon);
            buyBtn = itemView.findViewById(R.id.btnBut);
        }
    }
}
