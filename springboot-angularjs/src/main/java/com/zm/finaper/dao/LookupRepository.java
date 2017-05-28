package com.zm.finaper.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zm.finaper.entity.Lookup;

/**
 * Created by wzhang on 23/05/2017.
 */
public interface LookupRepository extends CrudRepository<Lookup, Long> {
	
	@Query("from Lookup l where l.lookupType.id = (select t.id from LookupType t where t.code = :typeCode )")
	public Iterable<Lookup> findLookupsForType(@Param("typeCode") String typeCode);
}
