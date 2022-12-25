create table domain.paint_aggregate
(
  aggregate_id text primary key,
  last_version integer not null
);
create table domain.paint_event
(
  aggregate_id text,
  "version"    integer,
  event_type   text  not null,
  json_data    jsonb not null,
  primary key (aggregate_id, "version")
);
create table query.paint
(
  aggregate_id text primary key,
  last_version integer not null,
  color_name   text    not null,
  color_code   text    not null
);
