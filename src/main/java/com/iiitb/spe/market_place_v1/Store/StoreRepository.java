package com.iiitb.spe.market_place_v1.Store;

import com.iiitb.spe.market_place_v1.Product.ProductStore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends CrudRepository<Store,Integer> {

    @Query("select s from Store s join fetch s.productStoreList where s.sid=:id")
     Store fetchProducts(@Param("id") int id);

    @Query("select s from Store s join fetch s.orderList where s.sid=:id")
    Store fetchOrders(@Param("id") int id);

    @Query("select s from Store s join fetch s.orderList o where o.order_type=:type and s.sid=:sid")
    Store fetchOrdersByType(@Param("type") String type,@Param("sid") int sid);

    @Query("select s from Store s inner join s.productStoreList ps where ps.quantity <=:quantity  and s.sid=:sid")
    Store fetchProductStoreListByQuantity(@Param("sid") int sid, @Param("quantity") int quantity);

    @Query("select s from Store s join fetch s.slotsList where s.sid=:sid")
    Store fetchSlotList(@Param("sid") int sid);

    List<Store> findByAddress_Pincode(String pincode);
}
