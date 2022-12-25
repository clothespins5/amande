package com.amande.infrastructure.projection.paint;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaintProjectionMapper {
  List<String> searchForUpdateTargets();
}
