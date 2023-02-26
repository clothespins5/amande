package com.amande.infrastructure.projection.paint;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaintProjectorMapper {
  List<String> searchForUpdateTargets();
  int upsert(@Param("paintRecords") List<PaintRecord> paintRecords);
}
