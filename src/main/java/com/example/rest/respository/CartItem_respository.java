package com.example.rest.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.model.Cart_item;
import com.example.rest.model.Product;

@Repository
public  interface CartItem_respository extends JpaRepository<Cart_item,Integer> {

	Optional<Cart_item> findByUserIdAndProductId(int user_id, int productid);
	List<Cart_item> findByUserId(int user_id);
	@Query("SELECT c FROM Cart_item c WHERE c.userId = :userId AND c.productId = :productId")
	Cart_item findByUserIdAndProductId1(@Param("userId") int userId, @Param("productId") int productId);

	
	
}
