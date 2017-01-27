package homepunk.lesson.first.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.lesson.first.contollers.R;
import homepunk.lesson.first.database.Constants;
import homepunk.lesson.first.model.TVSeries;
import homepunk.lesson.first.view.detailed.DetailedActivity;

public class TVListAdapter extends RecyclerView.Adapter<TVListAdapter.ViewHolder> {
    private TVSeries tvSeries;
    private Context context;
    private LayoutInflater layoutInflater;
    private View root;

    protected static List<TVSeries> tvList;

    public TVListAdapter(Context context, List<TVSeries> tvList) {
        this.tvList = tvList;
        this.context = context;
    }

    @Override
    public TVListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (tvList.size() > 10) {
            layoutInflater = LayoutInflater.from(parent.getContext());
            root = layoutInflater.inflate(R.layout.list_item_tvseries, parent, false);
        } else {
            layoutInflater = LayoutInflater.from(parent.getContext());
            root = layoutInflater.inflate(R.layout.list_item_search, parent, false);
        }
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        tvSeries = tvList.get(position);

        if (!TextUtils.isEmpty(tvSeries.getFullPosterPath(TVSeries.WIDTH_500)))
            Picasso.with(context)
                    .load(tvSeries.getFullPosterPath(TVSeries.WIDTH_500))
                    .placeholder(R.drawable.placeholder_image)
                    .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.item_poster) ImageView poster;
        private TVSeries tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            poster.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Context context = v.getContext();
            Intent intent = new Intent(context, DetailedActivity.class);
            tvItem = tvList.get(getAdapterPosition());

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) v.getContext(), poster, "profile");
            intent.putExtra(Constants.TV_ID, tvItem.id);
            context.startActivity(intent, options.toBundle());
        }
    }
}
