package ${packageName};
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import ${packageName}.R;
import ru.alexbykov.norecyclerviewadapter.NoRecyclerViewAdapter;

public class ${adapterClassName} extends NoRecyclerViewAdapter<String, ${adapterClassName}.${adapterViewHolderClassName}> {

    private static final int LAYOUT = R.layout.${adapterItemLayoutName};

    <#if isGetItemViewTypeOvveride>
     @Override
     public int getItemViewType(int position) {
     return super.getItemViewType(position);
    }
    </#if>


    @Override
    public ${adapterClassName}.${adapterViewHolderClassName} onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflate(parent, LAYOUT);
        return new ${adapterViewHolderClassName}(view);
    }

    @Override
  public void onBindViewHolder(${adapterViewHolderClassName} holder, int position) {

  }

<#if isGetItemsCountOvveride>
       @Override
       public int getItemCount() {
           return super.getItemCount();
       }
</#if>

    public static class ${adapterViewHolderClassName} extends RecyclerView.ViewHolder {

        public ${adapterViewHolderClassName}(View itemView) {
            super(itemView);
        }
    }
}
