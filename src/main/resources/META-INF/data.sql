
INSERT INTO suppliers (name) VALUES ('Produccion');
INSERT INTO suppliers (name) VALUES ('Contabilidad');
INSERT INTO suppliers (name) VALUES ('TI');

INSERT INTO products (name,supplier_id,category,unit_price,units_in_stock) VALUES ('Gabinetes', 1, 2, 18.09, 10);
INSERT INTO products (name,supplier_id,category,unit_price,units_in_stock) VALUES ('Dispersadores', 1, 2, 21.09, 40);
INSERT INTO products (name,supplier_id,category,unit_price,units_in_stock) VALUES ('PLC', 2, 1, 01.09, 10);
INSERT INTO products (name,supplier_id,category,unit_price,units_in_stock) VALUES ('Mangueras', 2, 2, 05.08, 20);
INSERT INTO products (name,supplier_id,category,unit_price,units_in_stock) VALUES ('Fajas', 3, 1, 01.09, 30);

INSERT INTO orden (proveedor,fecha,responsable,producto,detalle) VALUES ('asda','12-07-1995','marcos piña', 'anis', 'gg');
