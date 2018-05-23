package com.github.jptx1234.mdm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.jptx1234.mdm.model.StuffPack;

public interface StuffPackDao {

	int count(StuffPack example);

	List<StuffPack> listByPage(@Param("example") StuffPack example, @Param("start") int start, @Param("size") int size);

	int delete(List<Integer> idList);

	void insert(StuffPack stuffPack);

	int countBlur(@Param("kw") String kw, @Param("packTypeId")Integer packTypeId);

	List<StuffPack> listBlur(@Param("kw") String kw, @Param("packTypeId") Integer packTypeId, @Param("start") int start, @Param("size") int pageSize);

}
