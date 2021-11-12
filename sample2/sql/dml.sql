TRUNCATE hoge;
TRUNCATE building;
TRUNCATE room;

INSERT INTO hoge(
	id, name, explanation)
	VALUES ('100001', 'ochi', 'MIZUSHIMA HIRO NI NITEIRU.');

INSERT INTO hoge(
	id, name, explanation)
	VALUES ('100002', 'ohnuki', 'NUKIMARU');
	
INSERT INTO hoge(
	id, name, explanation)
	VALUES ('100003', 'iwasaki', 'NI-SAN');
	
INSERT INTO hoge(
	id, name, explanation)
	VALUES ('100004', 'quality', 'DOREI HA NIDO SASU.');


INSERT INTO building(
	id, building_name, building_detail)
	VALUES ('100001', 'building1', 'ochi building');

INSERT INTO building(
	id, building_name, building_detail)
	VALUES ('100002', 'building2', 'ohnuki building');


INSERT INTO building(
	id, building_name, building_detail)
	VALUES ('100004', 'building4', 'quality building');


INSERT INTO room(
	id, room_name, room_detail)
	VALUES ('100001', 'ochi room', 'aaa');

INSERT INTO room(
	id, room_name, room_detail)
	VALUES ('100003', 'iwasaki room', 'ccc');

INSERT INTO room(
	id, room_name, room_detail)
	VALUES ('100004', 'quality room', 'ddd');