private boolean loading = true;
private int pastVisibleItems, visibleItemCount, totalItemCount;

mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener({
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        visibleItemCount = mLayoutManager.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        int[] firstVisibleItems = null;
        firstVisibleItems = mLayoutManager.findFirstVisibleItemPositions(firstVisibleItems);
        if(firstVisibleItems != null && firstVisibleItems.length > 0) {
            pastVisibleItems = firstVisibleItems[0];
        }

        if (loading) {
            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                loading = false;
                Log.d("tag", "LOAD NEXT ITEM");
            }
        }
    }
});