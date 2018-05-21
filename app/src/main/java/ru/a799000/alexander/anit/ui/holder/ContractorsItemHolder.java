package ru.a799000.alexander.anit.ui.holder;


import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.anit.App;
import ru.a799000.alexander.anit.R;
import ru.a799000.alexander.anit.ui.model.view.ContractorItemViewModel;


public class ContractorsItemHolder extends BaseViewHolder<ContractorItemViewModel> {

    @BindView(R.id.tv_contractor_name)
    public TextView tvName;

    @BindView(R.id.tv_contractor_code)
    public TextView tvCode;



    public ContractorsItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ContractorItemViewModel item) {
        tvName.setText(item.getName());
        tvCode.setText(item.getCode());
    }

    @Override
    public void unbindViewHolder() {
        tvName.setText(null);
        tvCode.setText(null);
    }
}
