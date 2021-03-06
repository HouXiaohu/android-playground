package info.xudshen.android.playground.cement;

import android.support.annotation.NonNull;
import android.view.View;

//<editor-fold desc="Wrapper Model">
public abstract class CementWrapperViewHolder<VH extends CementViewHolder> extends CementViewHolder {
    @NonNull
    protected final VH childViewHolder;

    @NonNull
    public VH getChildViewHolder() {
        return childViewHolder;
    }

    public CementWrapperViewHolder(View itemView, @NonNull VH childViewHolder) {
        super(itemView);
        this.childViewHolder = childViewHolder;
    }

    @Override
    public boolean shouldSaveViewState() {
        return childViewHolder.shouldSaveViewState();
    }
}