package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2__insert_paint extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
//    var jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true));
//    jdbcTemplate.execute("INSERT INTO amande.paint(paint_id, color_name, color_code) VALUES(70855, 'ブラックグレーズ(上塗り用)', 'rgb(34,24,21)');");
  }

}
