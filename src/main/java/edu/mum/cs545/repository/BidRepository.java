package edu.mum.cs545.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs545.model.Bids;

@Repository
public interface BidRepository extends CrudRepository<Bids, Long> {

	@Query("select b from Bids b where b.carId = :id")
	public List<Bids> getBidsByCarId(@Param("id") Long id);
}
