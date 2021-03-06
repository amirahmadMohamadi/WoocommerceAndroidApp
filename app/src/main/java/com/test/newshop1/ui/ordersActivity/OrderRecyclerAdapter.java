package com.test.newshop1.ui.ordersActivity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.newshop1.data.database.order.Order;
import com.test.newshop1.databinding.OrderItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.CustomViewHolder> {

    private List<Order> orders;

    private OnPaymentButtonClicked paymentListener;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CustomViewHolder(OrderItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(orders.get(position));
    }

    @Override
    public int getItemCount() {
        return orders == null ? 0 : orders.size();
    }

    public void setOnPaymentListener(OnPaymentButtonClicked paymentListener) {
        this.paymentListener = paymentListener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        final OrderItemBinding binding;
        CustomViewHolder(OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setPaymentListener(paymentListener);
        }

        public void bind(Order order) {
            binding.setOrder(order);
        }
    }

    public interface OnPaymentButtonClicked{
        void onClicked(Order order);
    }
}
