package com.amande.infrastructure.query.paint;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaintQueryMapper {

  List<PaintQueryRecord> selectAll();

  int upsert(@Param("queryRecords") List<PaintQueryRecord> queryRecords);
}
