ALTER TABLE medicos ADD COLUMN estado  tinyint NOT NULL;
UPDATE medicos SET estado = 1;