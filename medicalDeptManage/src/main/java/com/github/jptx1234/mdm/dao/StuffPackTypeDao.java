package com.github.jptx1234.mdm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.jptx1234.mdm.model.StuffPackType;

public interface StuffPackTypeDao {

	int count(StuffPackType example);

	List<StuffPackType> listByPage(@Param("example") StuffPackType example, @Param("start") int start, @Param("size") int size);

	int delete(List<Integer> idList);

}
