package com.altimetrik.donorschoose.ui.main;

import com.altimetrik.donorschoose.api.ApiClient;
import com.altimetrik.donorschoose.api.Constants;
import com.altimetrik.donorschoose.api.FilterDataContract;
import com.altimetrik.donorschoose.api.IDonorsChooseClient;
import com.altimetrik.donorschoose.data.Proposal;
import com.altimetrik.donorschoose.data.SearchFilter;
import com.altimetrik.donorschoose.data.SearchResponse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
public class MainPresenter {
    private final MainView view;
    private SearchFilter filter;
    private List<Proposal> proposals;
    private LinkedList<Disposable> disposables = new LinkedList<>();

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void doSearch() {

        IDonorsChooseClient client = ApiClient.getClient();

        Map<String, Object> map = new HashMap<>();
        map.put(FilterDataContract.SUBJECT_1, filter.getSubject());
        map.put(FilterDataContract.API_KEY, Constants.APIKEY);

        Disposable disposable = client.search(map)
//                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchResponse>() {
                    @Override
                    public void accept(SearchResponse searchResponse) {
                        proposals = searchResponse.getProposals();
                        view.showResults(proposals);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                        view.showError(throwable.getMessage());
                    }
                });

        disposables.add(disposable);

    }

    public void setFilter(SearchFilter filter) {

        this.filter = filter;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void dispose() {
        try {
            for (Disposable disposable : disposables) {
                disposable.dispose();
            }
            disposables.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getTotalProposals() {

        return proposals != null ? proposals.size() : 0;
    }
}
