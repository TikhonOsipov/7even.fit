package com.tixon.a7evenfit.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tixon.a7evenfit.R;
import com.tixon.a7evenfit.databinding.MealSectionBinding;

/**
 * Created by tikhon.osipov on 16.11.16
 */

public class SectionedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SECTION_TYPE = 1;

    /**
     * Simple adapter that contains list of data without sections
     */
    private RecyclerView.Adapter baseAdapter;

    /**
     * Structure of SparseArray<String> sections:
     * KEY: position of section in recyclerView
     * VALUE: meal order number (e.g. "First meal"),
     */
    private SparseArray<String> sections = new SparseArray<>();

    /**
     * Grouper creates sections with its rules
     * (here, new section is set when meal order changes)
     */
    private IGrouper<SparseArray<String>> grouper;

    public void setGrouper(IGrouper<SparseArray<String>> grouper) {
        this.grouper = grouper;
        sections = this.grouper.group();
        notifyDataSetChanged();
    }

    public SectionedRecyclerAdapter(RecyclerView.Adapter baseAdapter) {
        this.baseAdapter = baseAdapter;
    }

    @Override
    public int getItemViewType(int position) {
        return isSectionPosition(position) ?
                SECTION_TYPE :
                baseAdapter.getItemViewType(getPositionWithoutSections(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == SECTION_TYPE) {
            MealSectionBinding binding = DataBindingUtil.inflate(inflater, R.layout.meal_section,
                    parent, false);
            return new SectionViewHolder(binding.getRoot());
        } else {
            return baseAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isSectionPosition(position)) {
            ((SectionViewHolder) holder).binding.textMealOrder.setText(sections.get(position));
        } else {
            baseAdapter.onBindViewHolder(holder, getPositionWithoutSections(position));
        }
    }

    @Override
    public int getItemCount() {
        return baseAdapter.getItemCount() + sections.size();
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {
        MealSectionBinding binding;
        public SectionViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    private boolean isSectionPosition(int position) {
        return sections.get(position) != null;
    }

    /**
     * Gets raw position for List of data from recycler view with sections
     * @param sectionedPosition position in recycler view with sections
     * @return position in recycler view with sections - sections count before
     * position in recycler view with sections
     */
    public int getPositionWithoutSections(int sectionedPosition) {
        //while first completely visible position corresponds to section
        while(isSectionPosition(sectionedPosition)) {
            //increase the position
            sectionedPosition++;
        }

        int offset = 0;
        for(int i = 0; i < sections.size(); i++) {
            if(sections.keyAt(i) > sectionedPosition) {
                break;
            }
            --offset;
        }
        return sectionedPosition + offset;
    }

    /**
     * Adds section count before raw position to raw position in List of data
     * @param position raw position in List of data
     * @return raw position + section count before raw position
     */
    public int addSectionsToRawPosition(int position) {
        int offset = 0;
        for(int i = 0; i < sections.size(); i++) {
            if(sections.keyAt(i) > position + offset) {
                break;
            }
            ++offset;
        }
        return position + offset;
    }
}