package com.test.newshop1.ui.homeActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.newshop1.data.database.product.Product;
import com.test.newshop1.databinding.ProductItemBinding;
import com.test.newshop1.databinding.ProductItemGridBinding;
import com.test.newshop1.databinding.ProductItemGridFixBinding;
import com.test.newshop1.databinding.ProductItemSmallBinding;
import com.test.newshop1.ui.OnItemClickListener;
import com.test.newshop1.ui.productListActivity.ProductListAdapter;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class HomeProductListAdapter extends PagedListAdapter<Product, HomeProductListAdapter.ItemHolder> {

    private OnItemClickListener onItemClickListener;

    public HomeProductListAdapter() {
        super(DIFF_CALLBACK);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        return new ItemHolder(ProductItemSmallBinding.inflate(inflater, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        Product product = getItem(position);
        holder.bind(product);

    }



    class ItemHolder extends RecyclerView.ViewHolder {

        private final ProductItemSmallBinding binding;

        ItemHolder(ProductItemSmallBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.setProduct(product);
            binding.setListener(onItemClickListener);
        }
    }


    private static DiffUtil.ItemCallback<Product> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Product>() {

                @Override
                public boolean areItemsTheSame(Product oldConcert, Product newConcert) {
                    return oldConcert.getId().equals(newConcert.getId());
                }

                @Override
                public boolean areContentsTheSame(Product oldConcert,
                                                  @NonNull Product newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };

}
