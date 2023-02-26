package com.amande.infrastructure.query.paint.search;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface PaintSearchQueryMapper {

  Cursor<PaintSearchQueryRecord> select();

}
