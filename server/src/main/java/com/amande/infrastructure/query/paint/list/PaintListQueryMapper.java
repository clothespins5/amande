package com.amande.infrastructure.query.paint.list;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface PaintListQueryMapper {
  Cursor<PaintListQueryRecord> select();
}
