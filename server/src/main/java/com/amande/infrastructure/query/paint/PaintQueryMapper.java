package com.amande.infrastructure.query.paint;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

@Mapper
public interface PaintQueryMapper {

  Cursor<PaintQueryRecord> selectAll();

  int upsert(@Param("queryRecords") List<PaintQueryRecord> queryRecords);
}
