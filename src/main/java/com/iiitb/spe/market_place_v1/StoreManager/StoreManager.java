package com.iiitb.spe.market_place_v1.StoreManager;

import com.iiitb.spe.market_place_v1.Store.Store;
import com.iiitb.spe.market_place_v1.User.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
public class StoreManager extends User {

    @OneToMany(mappedBy = "storeManager")
    private List<Store> storeList;

    public StoreManager() {

    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}
